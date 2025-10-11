package se.jensen.quyen.webshopadmin.model;

public class Clothing extends Product {
    public Clothing(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Kläder";
    }
}
