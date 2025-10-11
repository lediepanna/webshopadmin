package se.jensen.quyen.webshopadmin.Interface;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String prompt(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public int menu() {
        System.out.println("\n=== Webshop Admin ===");
        System.out.println("1. Lägg till produkt");
        System.out.println("2. Lista alla produkter");
        System.out.println("3. Visa info om en produkt");
        System.out.println("4. Avsluta");
        System.out.print("Välj: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
