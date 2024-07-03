package hiyen;

import hiyen.product.Product;
import hiyen.ui.Console;
import hiyen.ui.PrintConsole;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initialize();
        Scanner scanner = new Scanner(System.in);
        Console console = new PrintConsole(scanner);

        String order = console.read();

        Product popped = vendingMachine.pop(order);
        console.print(popped.consume());
    }
}
