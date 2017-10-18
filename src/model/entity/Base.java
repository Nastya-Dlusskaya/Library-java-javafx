package model.entity;

import java.util.Date;

public class Base {

    private String reader;
    private String book;
    private Date getBook;
    private Date returnBook;

    public Base(String asd, String s, Date parse, Date date) {
    }

    public Base(String readerFirstname, String readerLastname, String patronymic, String bookAuthor, String bookName,
                Date getBook, Date returnBook) {
        this.reader = readerFirstname + ' ' + readerLastname + ' ' + patronymic;
        this.book = bookAuthor + ' ' + bookName;
        this.getBook = getBook;
        this.returnBook = returnBook;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getGetBook() {
        return getBook;
    }

    public void setGetBook(Date getBook) {
        this.getBook = getBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }
}