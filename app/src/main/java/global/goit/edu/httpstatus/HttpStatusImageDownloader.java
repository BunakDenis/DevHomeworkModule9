package global.goit.edu.httpstatus;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusImageDownloader {
    private Connection.Response execute;

    public void downloadStatusImage(int code) {
        HttpStatusChecker checker = new HttpStatusChecker();

        String urlStatusImage = checker.getStatusImage(code);

        try {

            execute = Jsoup.connect(urlStatusImage).ignoreContentType(true).execute();

            byte[] fileContent = execute.bodyAsBytes();

            Files.write(fileContent, urlStatusImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
