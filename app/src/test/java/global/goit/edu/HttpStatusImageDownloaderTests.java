package global.goit.edu;

import global.goit.edu.httpstatus.HttpStatusImageDownloader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HttpStatusImageDownloaderTests {

    @Test
    public void testThatMethodDownloadStatusImageWorkOk() {

        //Given
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        List<Integer> codes = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        codes.add(200);
        codes.add(300);
        codes.add(400);
        expected.add("src/main/resources/status_code_200.jpg");
        expected.add("src/main/resources/status_code_300.jpg");
        expected.add("src/main/resources/status_code_400.jpg");

        //When
        for (Integer code : codes) {
            downloader.downloadStatusImage(code);
        }

        //Then
        for (String path : expected) {
            Assertions.assertTrue(Files.exists(Path.of(path)));
        }

    }

}
