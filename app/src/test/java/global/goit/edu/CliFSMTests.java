package global.goit.edu;

import global.goit.edu.cli.HttpImageStatusCli;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CliFSMTests {

    private static HttpImageStatusCli cli;

    @BeforeAll
    public static void BeforeAll() {
        cli = new HttpImageStatusCli();
    }

    @Test
    public void testThatCommand200DownloadImage() {
        List<String> inputValues = new ArrayList<>();
        PrintStream out = System.out;
        inputValues.add("200");
        inputValues.add("exit");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        for (String inputValue : inputValues) {
            cli.checkInputValue(inputValue);
        }

        System.setOut(out);
        System.out.println(outputStream);

    }

}
