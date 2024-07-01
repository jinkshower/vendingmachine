package hiyen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();

        Drink popped = vendingMachine.pop(order);
        popped.drink();
    }
}
