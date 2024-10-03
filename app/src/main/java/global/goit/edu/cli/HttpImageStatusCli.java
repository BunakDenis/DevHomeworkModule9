package global.goit.edu.cli;

import global.goit.edu.httpstatus.HttpStatusImageDownloader;


import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;

    private final java.util.logging.Logger log;

    public HttpImageStatusCli() {
        downloader = new HttpStatusImageDownloader();
        log = java.util.logging.Logger.getLogger(HttpImageStatusCli.class.getName());

    }

    public void askStatus(Scanner sc) {

        System.out.println("Enter HTTP status code:");

        while (true) {
            String input = sc.nextLine();

            if (isInteger(input)) {
                try {
                    downloader.downloadStatusImage(Integer.parseInt(input));
                    System.out.println("Image for HTTP status - " + input + ", download successfully");
                    log.info("Image for HTTP status - " + input + ", download successfully");
                } catch (IllegalArgumentException e) {
                    System.out.println("There is not image for HTTP status " + input);
                    System.out.println("Please enter valid HTTP status:");
                }
            } else if (input.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Please enter valid number");
            }
        }
    }

    private boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
