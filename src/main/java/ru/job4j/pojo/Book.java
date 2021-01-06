package ru.job4j.pojo;

public class Book {
    private String bookName;
    private int pagesAmount;

    public Book(String bookName, int pagesAmount) {
        this.bookName = bookName;
        this.pagesAmount = pagesAmount;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }
}
