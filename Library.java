package pack1;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a book to the library
    public boolean addBook(Book book) {
        books.add(book);
        return true; // Return true after adding the book
    }

    // Add a member to the library
    public void addMember(Member member) {
        members.add(member);
    }

    // Get list of members
    public List<Member> getMembers() {
        return members;
    }

    // Display all available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    // Display all borrowed books
    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    // Borrow a book
    public void borrowBook(Member member, String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                member.borrowBook(book);
                System.out.println(member.getName() + " borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    // Return a book
    public void returnBook(Member member, String ISBN) {
        for (Book book : member.getBorrowedBooks()) {
            if (book.getISBN().equals(ISBN)) {
                member.returnBook(book);
                System.out.println(member.getName() + " returned " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }

    // Display all members and their borrowed books
    public void displayMembers() {
        System.out.println("Library Members:");
        for (Member member : members) {
            System.out.println(member);
            for (Book book : member.getBorrowedBooks()) {
                System.out.println("  Borrowed: " + book);
            }
        }
    }
}
