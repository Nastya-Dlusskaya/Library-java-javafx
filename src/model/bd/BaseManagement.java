package model.bd;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.entity.Base;
import model.entity.Book;
import model.entity.Reader;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class BaseManagement {
    public static Connection conn;
    public static Statement statmt;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn()
    {
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:src/files/library.db");

        } catch (ClassNotFoundException e){
            System.out.println("classNotFound");
        } catch (SQLException e){
            System.out.println("SQLExc");
        }
    }

    // --------Создание таблицы--------
    public static void CreateDB(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute(queue);
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(String queue) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute(queue);
    }

    public static void updateBD(String queue) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.executeUpdate(queue);
    }


    // -------- Вывод таблицы--------
    public static List<Book> ReadDBBook(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        ResultSet resSet = null;
        resSet = statmt.executeQuery(queue);
        List<Book> books = FXCollections.observableArrayList();


        while(resSet.next())
        {
            String  name = resSet.getString("name");
            String  author = resSet.getString("author");
            int year = resSet.getInt("year");
            String publisher = resSet.getString("publisher");
            books.add(new Book(name, author,year,publisher));
        }
        return books;
    }

    public static List<Base> ReadDBReadBase(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        ResultSet resSet = null;
        resSet = statmt.executeQuery(queue);
        List<Base> records = FXCollections.observableArrayList();

        while(resSet.next())
        {
            String  firstname = resSet.getString("firstname");
            String  lastname = resSet.getString("lastname");
            String patronymic = resSet.getString("patronymic");
            String name = resSet.getString("name");
            String author = resSet.getString("author");
            Date getBook = Date.valueOf(resSet.getString("dateGet"));
            Date returnBook = null;
            try {
                returnBook = Date.valueOf(resSet.getString("dateReturn"));
            }catch(Exception e){}
            records.add(new Base(firstname, lastname, patronymic, name, author, getBook, returnBook));
        }
        return records;
    }

    public static String ReadDBAdmin(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        ResultSet resSet = null;
        resSet = statmt.executeQuery(queue);
        String str = "";

        while(resSet.next())
        {
            String  login = resSet.getString("login");
            str += login;
        }
        return str;
    }

    public static int ReadDBId(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        ResultSet resSet = null;
        resSet = statmt.executeQuery(queue);
        int id = 0;

        while(resSet.next())
        {
            id = resSet.getInt("id");
        }
        return id;
    }

    public static List ReadDBReader(String queue) throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        ResultSet resSet = null;
        resSet = statmt.executeQuery(queue);
        List<Reader> readers = FXCollections.observableArrayList();

        while(resSet.next())
        {
            String  firstName = resSet.getString("firstname");
            String  lastName = resSet.getString("lastname");
            String patronymic = resSet.getString("patronymic");
            Date birthday = Date.valueOf(resSet.getString("birthday"));
            String region = resSet.getString("region");
            String area = resSet.getString("area");
            String city = resSet.getString("city");
            String street = resSet.getString("street");
            int home = resSet.getInt("home");
            int flat = resSet.getInt("flat");
            String numberPhone = resSet.getString("numberPhone");
            String numberPassport = resSet.getString("numberPassport");
            readers.add(new Reader(firstName, lastName, patronymic, birthday, region, area, city, street, home, flat,
                    numberPhone, numberPassport));
        }
        return readers;
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
    }
}
