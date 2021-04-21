package com.company;

import java.util.HashMap;

public class Library {
    // Add the missing implementation to this class
    private HashMap<String, Book> books;
    private String address;

    public Library(String address) {
        this.address = address;
        this.books = new HashMap<String, Book>();
    }



    public void addBook(Book book) {
        this.books.put(book.getTitle(), book);
    }

    public void borrowBook(String bookTitle) {
        if (this.books.containsKey(bookTitle)) {
            Book myBook = this.books.get(bookTitle);
            if (!myBook.isBorrowed()) {
                myBook.rented();
                System.out.println("You successfully borrowed " + bookTitle);
            } else {
                System.out.println("Sorry, this book is already borrowed.");
            }
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void returnBook(String bookTitle) {
        if (this.books.containsKey(bookTitle)) {
            Book myBook = this.books.get(bookTitle);
            if (myBook.isBorrowed()) {
                myBook.returned();
                System.out.println("You successfully returned " + bookTitle);
            } else {
                System.out.println("This book has already been returned.");
            }
        } else {
            System.out.println("No book in catalog.");
        }
    }



    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void printAvailableBooks() {
        if (!this.books.isEmpty()) {
            for (Book book : this.books.values()) {
                if (!book.isBorrowed()) {
                    System.out.println(book.getTitle());
                }
            }
        } else {
            System.out.println("No book in catalog.");
        }
    }



}
