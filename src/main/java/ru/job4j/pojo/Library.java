package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book thinkingInJava = new Book("Thinking In Java", 1079);
        Book headFirstJava = new Book("Head First Java", 720);
        Book grokkingAlgorithms = new Book("Grokking Algorithms", 288);
        Book cleanCode = new Book("Clean code", 464);
        Book[] books = new Book[4];
        books[0] = thinkingInJava;
        books[1] = headFirstJava;
        books[2] = grokkingAlgorithms;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getBookName() + " " + book.getPagesAmount());
        }
        System.out.println("//////////");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getBookName() + " " + book.getPagesAmount());
        }
        System.out.println("//////////");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getBookName().equals("Clean code")) {
                System.out.println(book.getBookName() + " " + book.getPagesAmount());
            }
        }
    }
}
