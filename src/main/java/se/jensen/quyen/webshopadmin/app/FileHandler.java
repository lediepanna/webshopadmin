package se.jensen.quyen.webshopadmin.app;

import se.jensen.quyen.webshopadmin.model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "products.dat";

    public static void saveProducts(List<Product> products) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(products);
        } catch (IOException e) {
            System.out.println("Fel vid sparning av produkter: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Product> loadProducts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fel vid inläsning av produkter: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
