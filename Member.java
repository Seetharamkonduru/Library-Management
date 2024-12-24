package pack1;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Get member ID (this is the method you need)
    public int getMemberId() {
        return memberId;
    }

    // Get member name
    public String getName() {
        return name;
    }

    // Methods to borrow and return books
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false); // Mark the book as not available
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true); // Mark the book as available again
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member Name: " + name + ", ID: " + memberId + ", Borrowed Books: " + borrowedBooks.size();
    }
}
