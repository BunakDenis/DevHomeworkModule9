package global.goit.edu.httpstatus;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code){

        StringBuilder url = new StringBuilder();
        url.append("https://http.cat/");
        url.append(code);
        url.append(".jpg");

        try {
            Connection.Response execute = Jsoup.connect(url.toString()).ignoreContentType(true).execute();

        } catch (IOException e) {
            String message = "Incorrect code - " + code;
            throw new IllegalArgumentException(message);
        }
        return url.toString();
    }

}
