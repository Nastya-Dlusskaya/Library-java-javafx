package model.queue;

import model.bd.BaseManagement;
import model.entity.Base;
import model.entity.Book;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

public class queueBook {

    public static String addBook(String author, String name, int year, String publisher)
    {
        return new Formatter().format("INSERT INTO books (author, name, year, publisher, isFree) " +
                        "VALUES('%s', '%s', %d, '%s', '%s')", author, name, year, publisher, true).toString();
    }

    public static void makeQueue(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        BaseManagement.WriteDB(queue);
        BaseManagement.CloseDB();
    }

    public static void makeUpdateQueue(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        BaseManagement.updateBD(queue);
        BaseManagement.CloseDB();
    }

    public static String selectIdBook(String author, String name)
    {
        return new Formatter().format("SELECT id FROM books WHERE author='%s' AND name='%s'", author, name).toString();
    }

    public static List makeQueueReturn(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        List<Book> l = BaseManagement.ReadDBBook(queue);
        BaseManagement.CloseDB();
        return l;
    }

    public static int getId(String queue) throws SQLException, ClassNotFoundException
    {
        BaseManagement.Conn();
        int id =BaseManagement.ReadDBId(queue);
        BaseManagement.CloseDB();
        return id;
    }

    public static String updatePropertyIsFree(int id, boolean isFree)
    {
        return new Formatter().format("UPDATE books SET isFree = '%s' WHERE id = %d", isFree, id).toString();
    }

    public static String allFreeBook()
    {
        return new Formatter().format("SELECT name, author, year, publisher FROM books WHERE isFree = '%s'", true).toString();
    }

    public static String deleteBook(String author, String name, int year, String publisher)
    {
        return new Formatter().format("DELETE FROM books WHERE id = (SELECT id FROM books WHERE author = '%s' AND" +
                " name = '%s' AND year = %d AND publisher = '%s')", author, name, year, publisher).toString();
    }

    public static String allBook()
    {
        return new Formatter().format("SELECT id, name, author, year, publisher FROM books ORDER BY author").toString();
    }
    }
