package library;

import java.util.*;

public class LibraryManagement {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> books = new ArrayList<>(Arrays.asList("The Alchemist", "1984", "Harry Potter", "The Hobbit", "Wings of Fire"));
    private static ArrayList<String> borrowed = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║    📚 LIBRARY PORTAL      ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ 1. 📖 View Books           ║");
        System.out.println("║ 2. 🛒 Borrow Book          ║");
        System.out.println("║ 3. 📥 Return Book          ║");
        System.out.println("║ 4. 📋 My Borrowed Books    ║");
        System.out.println("║ 5. 🚪 Exit                 ║");
        System.out.println("╚════════════════════════════╝");
        System.out.print("👉 Choose: ");

        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        switch (choice) {
            case 1 -> viewBooks();
            case 2 -> borrowBook();
            case 3 -> returnBook();
            case 4 -> viewBorrowed();
            case 5 -> exit();
            default -> {
                System.out.println("❌ Invalid choice!");
                showMenu();
            }
        }
    }

    private static void viewBooks() {
        System.out.println("\n╔══════════════════════╗");
        System.out.println("║    AVAILABLE BOOKS   ║");
        System.out.println("╠══════════════════════╣");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("║ " + (i + 1) + ". " + books.get(i));
        }
        System.out.println("╚══════════════════════╝");
        showMenu();
    }

    private static void borrowBook() {
        viewBooks();
        System.out.print("\nEnter book number to borrow: ");
        int bookNum = sc.nextInt();
        sc.nextLine();

        if (bookNum > 0 && bookNum <= books.size()) {
            String book = books.remove(bookNum - 1);
            borrowed.add(book);
            System.out.println("✅ You borrowed: " + book);
        } else {
            System.out.println("❌ Invalid book number!");
        }
        showMenu();
    }

    private static void returnBook() {
        if (borrowed.isEmpty()) {
            System.out.println("\nNo books to return.");
            showMenu();
            return;
        }

        System.out.println("\n╔══════════════════════╗");
        System.out.println("║    BORROWED BOOKS    ║");
        System.out.println("╠══════════════════════╣");
        for (int i = 0; i < borrowed.size(); i++) {
            System.out.println("║ " + (i + 1) + ". " + borrowed.get(i));
        }
        System.out.println("╚══════════════════════╝");

        System.out.print("Enter book number to return: ");
        int returnNum = sc.nextInt();
        sc.nextLine();

        if (returnNum > 0 && returnNum <= borrowed.size()) {
            String book = borrowed.remove(returnNum - 1);
            books.add(book);
            System.out.println("✅ Returned: " + book);
        } else {
            System.out.println("❌ Invalid selection!");
        }
        showMenu();
    }

    private static void viewBorrowed() {
        System.out.println("\n╔══════════════════════════╗");
        System.out.println("║    YOUR BORROWED BOOKS   ║");
        System.out.println("╠══════════════════════════╣");
        if (borrowed.isEmpty()) {
            System.out.println("║   No books borrowed.     ║");
        } else {
            for (String b : borrowed) {
                System.out.println("║ " + b);
            }
        }
        System.out.println("╚══════════════════════════╝");
        showMenu();
    }

    private static void exit() {
        System.out.println("\n╔════════════════════════╗");
        System.out.println("║   Goodbye, Reader!     ║");
        System.out.println("╚════════════════════════╝");
        System.exit(0);
    }
}