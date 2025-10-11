package se.jensen.quyen.webshopadmin.app;
//anger att denna klass ligger i paketet app, vilket håller projektet organiserat.
import se.jensen.quyen.webshopadmin.Interface.*;
import se.jensen.quyen.webshopadmin.model.*;

import java.util.List;//används för att lagra flera produkter

public class Main {
    private static List<Product> products;
    private static UI ui = new ConsoleUI();//Det visar polymorfism.

    public static void main(String[] args) {
        // Läs in produkter från fil
        products = FileHandler.loadProducts();
        //Spara och läsa data, så att informationen finns kvar även nästa gång man startar det.
        ui.info("Laddade " + products.size() + " produkter från fil.");

        boolean running = true;
        while (running) {
            int choice = ui.menu();
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> listProducts();
                case 3 -> showProduct();
                case 4 -> {
                    ui.info("Sparar produkter och avslutar...");
                    FileHandler.saveProducts(products);
                    running = false;
                }
                default -> ui.info("Ogiltigt val!");
            }
        }
    }

    private static void addProduct() {
        ui.info("\nVilken typ av produkt vill du lägga till?");
        ui.info("1. Bok\n2. Kläder\n3. Dator");
        int type = Integer.parseInt(ui.prompt("Välj typ (1-3)"));

        int article = Integer.parseInt(ui.prompt("Artikelnummer"));
        String title = ui.prompt("Titel");
        double price = Double.parseDouble(ui.prompt("Pris"));
        String desc = ui.prompt("Beskrivning");

        Product p = switch (type) {
            case 1 -> new Book(article, title, price, desc);
            case 2 -> new Clothing(article, title, price, desc);
            case 3 -> new Computer(article, title, price, desc);
            default -> null;
        };

        if (p != null) {
            products.add(p);
            ui.info("Produkten har lagts till!");
        } else {
            ui.info("Felaktig produktkategori!");
        }
    }

    private static void listProducts() {
        ui.info("\n=== Alla produkter ===");
        if (products.isEmpty()) {
            ui.info("Inga produkter finns ännu.");
        } else {
            for (Product p : products) {
                ui.info(p.toString() + "\n");
            }
        }
    }

    private static void showProduct() {
        int id = Integer.parseInt(ui.prompt("Ange artikelnummer"));
        for (Product p : products) {
            if (p.getArticleNumber() == id) {
                ui.info("\n" + p.toString());
                return;
            }
        }
        ui.info("Ingen produkt hittades.");
    }
}
