package global.goit.edu;

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

    public static void main(String[] args) {

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        downloader.downloadStatusImage(200);
        downloader.downloadStatusImage(300);
        downloader.downloadStatusImage(400);

    }

}
