package ooad.day21;

// DIP Implementation


// Interface — abstraction for all products
interface IProduct {
    void seeRating();
    void viewSample(); // General sample view method
}

// Low-level module: Clothes
class Clothes1 implements IProduct {
    @Override
    public void seeRating() {
        System.out.println("Rating of clothes");
    }

    @Override
    public void viewSample() {
        System.out.println("Viewing clothes sample");
    }
}

// Low-level module: Books
class Books1 implements IProduct {
    @Override
    public void seeRating() {
        System.out.println("Rating of books");
    }

    @Override
    public void viewSample() {
        System.out.println("Reading book sample");
    }
}

// High-level module: Cupboard depends on abstraction IProduct
class Cupboard1 {
    IProduct product; // Depends on interface, not a specific class

    void addItem(IProduct product) {
        this.product = product;
        System.out.println("Product added to Cupboard");
    }

    void customizeItem() {
        product.viewSample();
        product.seeRating();
    }
}


public class Task06 {
    public static void main(String[] args) {
        System.out.println("\nDIP Implementation:\n");
        Cupboard1 cupboard = new Cupboard1();

        // Add clothes to cupboard
        IProduct clothes = new Clothes1();
        cupboard.addItem(clothes);
        cupboard.customizeItem();

        System.out.println("");

        // Add books to cupboard
        IProduct books = new Books1();
        cupboard.addItem(books);
        cupboard.customizeItem();
    }
}

