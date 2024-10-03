package global.goit.edu.httpstatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Files {

    public static void write(byte[] fileContent, String url) {

        String fileName = getFileName(url);

        File file = new File(fileName);

        try (OutputStream out = new FileOutputStream(file)) {
            out.write(fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(String url) {

        StringBuilder result = new StringBuilder("D:\\Java\\IDEProjects\\Developer\\DevHomeworkModule9\\app\\src\\main\\resources\\");

        String[] stringsUrl = url.split("/");

        result.append("status_code_");
        result.append(stringsUrl[stringsUrl.length - 1]);

        return result.toString();
    }

}
