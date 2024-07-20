package com.library;

import java.util.Scanner;

public class App {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1: addBook(); break;
                case 2: removeBook(); break;
                case 3: searchBook(); break;
                case 4: listBooksByGenre(); break;
                case 5: displayAllBooks(); break;
                case 0: System.exit(0);
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nLibrary Inventory Management System");
        System.out.println("1. Add a new book");
        System.out.println("2. Remove a book");
        System.out.println("3. Search for a book by Title or Author");
        System.out.println("4. List books by Genre");
        System.out.println("5. Display all books");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        library.addBook(new Book(title, author, genre));
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        if (library.removeBook(title)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBook() {
        System.out.print("Enter title or author: ");
        String query = scanner.nextLine();
        library.searchBooks(query).forEach(System.out::println);
    }

    private static void listBooksByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        library.listBooksByGenre(genre).forEach(System.out::println);
    }

    private static void displayAllBooks() {
        library.displayAllBooks().forEach(System.out::println);
    }
}

