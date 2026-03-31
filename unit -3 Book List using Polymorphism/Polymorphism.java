import java.util.*;
import java.io.*;

class BookList {
    String bookName;
    String authorName;
    String bookType;

    BookList(String a, String b, String c) {
        this.bookName = a;
        this.authorName = b;
        this.bookType = c;
    }
    void showDetails(int price) {
        System.out.println("Book Name: " + bookName + " Price: " + price);
    }

    void showDetails(String category) {
        System.out.println("Book Name: " + bookName + " Category: " + category);
    }

    void showDetails(int pages, int edition) {
        System.out.println("Book Name: " + bookName +
                " Pages: " + pages + " Edition: " + edition);
    }

    void displayInfo() {
        System.out.println("Book Name: " + bookName +
                " Author: " + authorName +
                " Type: " + bookType);
    }
}

class StoryBook extends BookList {

    int chapters;

    StoryBook(String a, String b, String c, int d) {
        super(a, b, c);
        this.chapters = d;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Chapters: " + chapters);
    }
}

class TextBook extends BookList {

    int units;

    TextBook(String a, String b, String c, int d) {
        super(a, b, c);
        this.units = d;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Units: " + units);
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        BookList b1 = new StoryBook("Harry Potter", "J.K. Rowling", "Fantasy", 12);
        BookList b2 = new TextBook("Java Programming", "James Gosling", "Education", 8);

        b1.displayInfo();
        b2.displayInfo();

        b1.showDetails(450);
        b1.showDetails("Fiction");
        b2.showDetails(500, 3);
    }
}