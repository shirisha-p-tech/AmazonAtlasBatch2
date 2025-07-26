package ooad.day21;

// DIP Violation

// Low-level module: Clothes
class Clothes {
    void seeRating() {
        System.out.println("Rating of clothes");
    }

    void viewSample() {
        System.out.println("Viewing clothes sample");
    }
}

// Low-level module: Books
class Books {
    void seeRating() {
        System.out.println("Rating of books");
    }

    void readSample() {
        System.out.println("Reading book sample");
    }
}

// High-level module: Cupboard
class Cupboard {
    Clothes cobj;  // DIP Violation: Directly depends on low-level class Clothes
    Books bobj;    // DIP Violation: Directly depends on low-level class Books

    void addClothes(Clothes cobj) {
        this.cobj = cobj;
        System.out.println("Clothes added to cupboard");
    }

    void customizeClothes() {
        cobj.viewSample();  // Tied to Clothes implementation
        cobj.seeRating();
    }

    void addBooks(Books bobj) {
        this.bobj = bobj;
        System.out.println("Books added to cupboard");
    }

    void customizeBooks() {
        bobj.readSample();  // Tied to Books implementation
        bobj.seeRating();
    }
}


public class Task05 {
    public static void main(String[] args) {

        System.out.println("\nDIP Violation:\n");
        Cupboard cupboard = new Cupboard();

        // Add and customize clothes
        Clothes clothes = new Clothes();
        cupboard.addClothes(clothes);
        cupboard.customizeClothes();

        System.out.println("------");

        // Add and customize books
        Books books = new Books();
        cupboard.addBooks(books);
        cupboard.customizeBooks();
    }
}



