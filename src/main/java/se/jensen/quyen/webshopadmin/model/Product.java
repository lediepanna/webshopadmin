package se.jensen.quyen.webshopadmin.model;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private int articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(int articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public int getArticleNumber() { return articleNumber; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    public void setArticleNumber(int articleNumber) { this.articleNumber = articleNumber; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }

    public abstract String category();

    @Override
    public String toString() {
        return "[" + category() + "] " + title + " (ID: " + articleNumber + ") - " + price + " kr\n" +
                description;
    }
}
