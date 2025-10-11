package se.jensen.quyen.webshopadmin.model;

public class Book extends Product {
    public Book(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Bok";
    }
}
