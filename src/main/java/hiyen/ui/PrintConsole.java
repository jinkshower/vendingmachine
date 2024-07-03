package hiyen.ui;

import java.util.Scanner;

public class PrintConsole implements Console {

    private final Scanner scanner;

    public PrintConsole(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void print(final String message) {
        System.out.println(message);
    }
}
