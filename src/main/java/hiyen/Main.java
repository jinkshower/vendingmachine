package hiyen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        Console console = new PrintConsole(scanner);

        String order = console.read();

        Product popped = vendingMachine.pop(order);
        console.print(popped.consume());
    }
}
