package global.goit.edu;

import global.goit.edu.cli.HttpImageStatusCli;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HTTPImageStatusCliTests {

    private static HttpImageStatusCli cli;

    @BeforeAll
    public static void BeforeAll() {
        cli = new HttpImageStatusCli();
    }

    @Test
    public void testThatMethodCheckInputValueWithValue200WorkOk() {
        List<String> inputValues = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        PrintStream out = System.out;
        inputValues.add("200");
        inputValues.add("exit");
        expected.add("Image for HTTP status - 200, download successfully");
        expected.add("User input exit");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        for (String inputValue : inputValues) {
            cli.checkInputValue(inputValue);
        }

        System.setOut(out);
        String[] line = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < line.length; i++) {
            Assertions.assertEquals(expected.get(i), line[i]);
        }
    }

    @Test
    public void testMethodCheckInputValueWithValue2200WorkOk() {
        String inputValue = "2200";
        List<String> expected = new ArrayList<>();
        PrintStream out = System.out;
        expected.add("There is not image for HTTP status 2200");
        expected.add("Please enter valid HTTP status:");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        cli.checkInputValue(inputValue);

        System.setOut(out);
        String[] line = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < line.length; i++) {
            Assertions.assertEquals(expected.get(i), line[i]);
        }
    }

    @Test
    public void testMethodCheckInputValueWithValueMailWorkOk() {
        String inputValue = "mail";
        List<String> expected = new ArrayList<>();
        PrintStream out = System.out;
        expected.add("Please enter valid number");
        expected.add("User input exit");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        cli.checkInputValue(inputValue);

        System.setOut(out);
        String[] line = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < line.length; i++) {
            Assertions.assertEquals(expected.get(i), line[i]);
        }
    }
}
