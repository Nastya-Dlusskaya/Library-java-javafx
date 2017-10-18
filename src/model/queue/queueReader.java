package model.queue;

import model.bd.BaseManagement;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;

public class queueReader {

    public static String librarianLogin(String logins, String password)
    {
        return new Formatter().format("SELECT login FROM librarianLogin WHERE login = '%s' AND password = '%s';",
                logins, password).toString();
    }

    public static String selectAllReader()
    {
        return new Formatter().format("SELECT * FROM readers ORDER BY lastname;").toString();
    }

    public static String readerLogin(String logins, String password)
    {
        return new Formatter().format("SELECT login FROM readerLogin WHERE login = '%s' AND password = '%s';",
                logins, password).toString();
    }

    public static String updatePropertyIsAuth(int id, boolean isFree)
    {
        return new Formatter().format("UPDATE readerLogin SET isFree = '%s' WHERE id = %d", isFree, id).toString();
    }

    public static String selectIdReader(String lastname, String firstname, String patronymic)
    {
        return new Formatter().format("SELECT id FROM readers WHERE lastname='%s' AND firstname='%s' AND patronymic='%s'", lastname, firstname, patronymic).toString();
    }

    public static String addReader(String name, String surname, String patronymic, String region, String area,
                                      String city, String street, String phone, String passport, int home, int flat,
                                      LocalDate dates)
    {
        return new Formatter().format("INSERT INTO readers (lastname, firstname, patronymic, region, area, city, street, " +
                        "numberPhone, numberPassport, home, flat, birthday) VALUES('%s', '%s', '%s', '%s', '%s', '%s'," +
                        " '%s', '%s', '%s', %d, %d, '%s')",
                surname,  name, patronymic, region, area, city, street, phone, passport, home, flat, dates.toString()).toString();
    }

    public static String addLogin(String login, String password)
    {
        return new Formatter().format("INSERT INTO readerLogin (login, password) VALUES('%s', '%s')",
                login, password).toString();
    }

    public static String makeQueue(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        String list = BaseManagement.ReadDBAdmin(queue);
        BaseManagement.CloseDB();
        return list;
    }

    public static List makeQueueReturn(String queue) throws SQLException, ClassNotFoundException {
        BaseManagement.Conn();
        List list = BaseManagement.ReadDBReader(queue);
        BaseManagement.CloseDB();
        return list;
    }
}
