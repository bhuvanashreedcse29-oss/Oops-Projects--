import java.io.*;
import java.time.LocalDate;
import java.util.*;
class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String author;
    private String genre;   
    private String language; 
    private boolean available;
    public Book(int id, String title, String author, String genre, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.available = true;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; } 
    public String getGenre() { return genre; }
    public String getLanguage() { return language; }
    public boolean isAvailable() { return available; }
    public void borrow() { available = false; }
    public void returnBook() { available = true; }
    public void display() {
        System.out.printf("%-4d | %-15s | %-12s | %-10s | %-10s | %-10s\n", 
                          id, title, author, genre, language, (available ? "Available" : "Borrowed"));
    }
}
class BorrowRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    Book book;
    LocalDate borrowDate;
    LocalDate dueDate;

    public BorrowRecord(Book book) {
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(7);
    }
}
class User {
    private String name;
    private List<BorrowRecord> records = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
    public void borrow(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            records.add(new BorrowRecord(book));
            System.out.println("✅ Borrowed '" + book.getTitle() + "' successfully!");
        } else {
            System.out.println("❌ Sorry, this book is currently not available.");
        }
    }
    public void returnBook(Book book) {
        Iterator<BorrowRecord> it = records.iterator();
        while (it.hasNext()) {
            BorrowRecord r = it.next();
            if (r.book.getId() == book.getId()) {
                LocalDate today = LocalDate.now();
                if (today.isAfter(r.dueDate)) {
                    long daysLate = today.toEpochDay() - r.dueDate.toEpochDay();
                    long fine = daysLate * 10;
                    System.out.println("⚠️ Late return! Fine to pay = ₹" + fine);
                }
                book.returnBook();
                it.remove();
                System.out.println("✅ Returned successfully!");
                return;
            }
        }
        System.out.println("❌ You haven't borrowed this book!");
    }
    public void showBorrowed() {
        if (records.isEmpty()) {
            System.out.println("You have no borrowed books.");
            return;
        }
        System.out.println("\n--- YOUR BORROWED BOOKS ---");
        for (BorrowRecord r : records) {
            System.out.println("- " + r.book.getTitle() + " | Due Date: " + r.dueDate);
        }
    }
}
class FileManager {
    public static void save(List<Book> books) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library_data.dat"));
        oos.writeObject(books);
        oos.close();
    }
    @SuppressWarnings("unchecked")
    public static List<Book> load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library_data.dat"));
            List<Book> data = (List<Book>) ois.readObject();
            ois.close();
            return data;
        } catch (Exception e) {
            return new ArrayList<>(); // Return empty list if no file exists yet
        }
    }
}
class Library {
    private List<Book> books;

    public Library() {
        books = FileManager.load();
    }
    public void addBook(Book b) {
        books.add(b);
    }
    public void printHeader() {
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-15s | %-12s | %-10s | %-10s | %-10s\n", "ID", "Title", "Author", "Genre", "Language", "Status");
        System.out.println("---------------------------------------------------------------------------------");
    }
    public void showBooks() {
        printHeader();
        for (Book b : books) b.display();
    }
    public void showByCategory(String genre) {
        printHeader();
        boolean found = false;
        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("No books found in this category.");
    }
    public void showByLanguage(String lang) {
        printHeader();
        boolean found = false;
        for (Book b : books) {
            if (b.getLanguage().equalsIgnoreCase(lang)) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("No books found in this language.");
    }
    public Book find(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }
    public void search(String key) {
        printHeader();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(key.toLowerCase()) || 
                b.getAuthor().toLowerCase().contains(key.toLowerCase())) {
                b.display();
            }
        }
    }
    public void save() throws Exception {
        FileManager.save(books);
    }
    public boolean isEmpty() {
        return books.isEmpty();
    }
}
public class ProLibrarySystem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        
        System.out.print("Enter your name to login: ");
        String userName = sc.nextLine();
        User user = new User(userName);
        if (lib.isEmpty()) {
            lib.addBook(new Book(101, "Dracula", "Bram Stoker", "Horror", "English"));
            lib.addBook(new Book(102, "El resplandor", "Stephen King", "Horror", "Spanish"));
            lib.addBook(new Book(103, "Core Java", "Gary Cornell", "Education", "English"));
            lib.addBook(new Book(104, "Dune", "Frank Herbert", "Sci-Fi", "English"));
            lib.addBook(new Book(105, "Cien Años", "G. Marquez", "Novel", "Spanish"));
            lib.addBook(new Book(106, "Ponniyin Selvan", "Kalki", "History", "Tamil"));
        }
        System.out.println("\n👋 Welcome to the Pro Library, " + userName + "!");
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View All Books");
            System.out.println("2. Browse by Category (e.g., Horror)");
            System.out.println("3. Browse by Language (e.g., Spanish)");
            System.out.println("4. Search Title/Author");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. My Borrowed Books");
            System.out.println("8. Save & Exit");
            System.out.print("👉 Choose an option: ");            
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Category (Horror/Sci-Fi/Education/History/Novel): ");
                    String cat = sc.nextLine();
                    lib.showByCategory(cat);
                    break;
                case 3:
                    System.out.print("Enter Language (English/Spanish/Tamil): ");
                    String lang = sc.nextLine();
                    lib.showByLanguage(lang);
                    break;
                case 4:
                    System.out.print("Enter Search Keyword: ");
                    String key = sc.nextLine();
                    lib.search(key);
                    break;
                case 5:
                    System.out.print("Enter Book ID to Borrow: ");
                    int borrowId = sc.nextInt();
                    Book bToBorrow = lib.find(borrowId);
                    if (bToBorrow != null) user.borrow(bToBorrow);
                    else System.out.println("❌ Invalid Book ID.");
                    break;
                case 6:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    Book bToReturn = lib.find(returnId);
                    if (bToReturn != null) user.returnBook(bToReturn);
                    else System.out.println("❌ Invalid Book ID.");
                    break;
                case 7:
                    user.showBorrowed();
                    break;
                case 8:
                    lib.save();
                    System.out.println("💾 Data saved successfully. Goodbye, " + userName + "!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}