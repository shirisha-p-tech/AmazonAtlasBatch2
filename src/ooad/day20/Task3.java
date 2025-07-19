package ooad.day20;
// SRP Implementation - Book example

class BookDetails {
    private String title;
    private String author;
    private double price;

    public BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title= title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author= author;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price= price;
    }
}

class BookFormatter {
    public String formatTitle(String title) {
        return "Title: " + title.toUpperCase();
    }
    public String formatAuthor(String author) {
        return "Author: " + author;
    }
    public String formatBook(BookDetails book) {
        return formatTitle(book.getTitle()) + "\n" + formatAuthor(book.getAuthor());
    }
}

class PriceCalculator {
    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        return originalPrice * (1 - discountPercentage / 100);
    }
}

public class Task3{
    public static void main(String[] args) {

        BookDetails book = new BookDetails("Harry Potter and the Goblet of Fire", "J. K. Rowling", 500.00);
        System.out.println("Book details:");
        BookFormatter formatter = new BookFormatter();
        System.out.println(formatter.formatBook(book));

        PriceCalculator calc = new PriceCalculator();
        double discountPrice = calc.calculateDiscountedPrice(book.getPrice(), 10);
        System.out.printf("Discounted price: \u20B9%.2f ", discountPrice);
    }
}

/*
// srp violation code

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getFormattedTitle() {
        return "Title: " + title.toUpperCase();
    }

    public double calculateDiscountedPrice(double discountPercentage) {
        return price * (1 - discountPercentage);
    }

    // ... other methods for book details
}
*/