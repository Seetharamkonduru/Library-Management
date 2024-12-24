package pack1;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample books and members
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "123456"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "7891011"));
        Member member1 = new Member("Seetharam", 1);
        Member member2 = new Member("Hitesh", 2);
        Member member3 = new Member("Janaki", 3);
        Member member4 = new Member("Goutham", 4);
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
        library.addMember(member4);

        // Main menu
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book to the library");
            System.out.println("2. Display all available books");
            System.out.println("3. Display all borrowed books");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Display all members and their borrowed books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    boolean isAdded = library.addBook(new Book(title, author, ISBN));
                    if (isAdded) {
                        System.out.println("Book added successfully!!!");
                    }
                    break;

                case 2:
                    library.displayAvailableBooks();
                    break;

                case 3:
                    library.displayBorrowedBooks();
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    System.out.print("Enter ISBN of book to borrow: ");
                    ISBN = scanner.next();
                    for (Member member : library.getMembers()) {
                        if (member.getMemberId() == memberId) {
                            library.borrowBook(member, ISBN);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    System.out.print("Enter ISBN of book to return: ");
                    ISBN = scanner.next();
                    for (Member member : library.getMembers()) {
                        if (member.getMemberId() == memberId) {
                            library.returnBook(member, ISBN);
                            break;
                        }
                    }
                    break;

                case 6:
                    library.displayMembers();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
