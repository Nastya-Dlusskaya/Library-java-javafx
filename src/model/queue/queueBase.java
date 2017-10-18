package model.queue;

import model.bd.BaseManagement;
import model.entity.Base;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

public class queueBase {

    public static String getBook(int idReader, int idBook, String dateGet, String dateReturn) {
        return new Formatter().format("INSERT INTO accountBook (idReader, idBook, dateGet, dateReturn) VALUES " +
                "(%d, %d, '%s', NULL)", idReader, idBook, dateGet).toString();
    }

    public static String returnBook(int idReader, int idBook, String dateReturns) {
        return new Formatter().format("UPDATE accountBook SET dateReturn = '%s' WHERE idReader = %d AND idBook = %d " +
                "AND dateReturn IS NULL", dateReturns, idReader, idBook).toString();
    }

    public static String selectReadBook(int id) {
        return new Formatter().format("SELECT * FROM books JOIN accountBook ON accountBook.idBook = books.id " +
                "WHERE accountBook.idReader = %d AND dateReturn IS NULL", id).toString();
    }

    public static String selectAllReadBook() {
        return new Formatter().format("SELECT * FROM accountBook JOIN books ON accountBook.idBook = books.id JOIN readers " +
                " ON accountBook.idReader = readers.id WHERE dateReturn IS NULL").toString();
    }

    public static List<Base> returnBase(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        List l;
        l = BaseManagement.ReadDBReadBase(queue);
        BaseManagement.CloseDB();
        return l;
    }
}




