package global.goit.edu;

import global.goit.edu.cli.CliFSM;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class CliFSMTests {
    private static CliFSM cli;
    private ByteArrayInputStream in;

    @BeforeAll
    private static void BeforeAll() {
        cli = new CliFSM();
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void testThatCliFSMDownloadImage() {

        //Given
        String code = "200\n";
        String expectedCliAnswer = "Image for HTTP status - 200, download successfully";

        //When
        provideInput(code);

        cli.startInputLoop();

        String actualCliAnswer = systemOutRule.getLog();

        //Then
        Assertions.assertEquals(expectedCliAnswer, actualCliAnswer);
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}