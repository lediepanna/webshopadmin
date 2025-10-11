package se.jensen.quyen.webshopadmin.model;

public class Computer extends Product {
    public Computer(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Elektronik";
    }
}
