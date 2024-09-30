package global.goit.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HttpStatusCheckerTests {
    private static HttpStatusChecker checker;


    @BeforeAll
    public static void BeforeAll() {

        checker = new HttpStatusChecker();

    }

    @Test
    public void testThatMethodGetStatusImageWorkOk() {

        //Given
        int code = 200;
        String expected = "https://http.cat/200.jpg";

        //When
        String actual = checker.getStatusImage(code);

        //Then
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testThatMethodGetStatusImageThrowException() {

        //Given
        int code = 1000;
        String expectedMessage = "Incorrect code - " + code;

        //Then
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            checker.getStatusImage(code);
        });

        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }

}
