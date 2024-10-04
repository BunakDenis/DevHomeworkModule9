package global.goit.edu.cli;

import lombok.Data;

import java.util.Scanner;
@Data
public class CliFSM {

    private HttpImageStatusCli status;

    private Scanner sc;

    public CliFSM() {
        status = new HttpImageStatusCli();
        sc = new Scanner(System.in);
    }

    public CliFSM(Scanner scanner) {
        status = new HttpImageStatusCli();
        this.sc = scanner;
    }

    public void startInputLoop() {
        status.askStatus(sc);
    }

}
