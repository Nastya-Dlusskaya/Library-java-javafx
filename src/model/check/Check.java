package model.check;

import model.queue.queueReader;
import java.sql.SQLException;
import java.time.LocalDate;


public class Check {

    public static boolean checkLoginAndPasswordLibrarian(String login, String password)
            throws SQLException, ClassNotFoundException {
        boolean answer = false;
        String queue = queueReader.librarianLogin(login, password);
        if(queueReader.makeQueue(queue) != ""){
            answer = true;
        }
        return answer;
    }

    public static boolean checkStringMinSize(String str, int size)
    {
        boolean answer = true;
        if(str.length() < size)
        {
            answer = false;
        }
        return answer;
    }

    public static boolean checkStringMaxSize(String str, int size)
    {
        boolean answer = true;
        if(str.length() > size)
        {
            answer = false;
        }
        return answer;
    }

    public static boolean checkLoginAndPasswordReader(String login, String password) throws SQLException, ClassNotFoundException {
        boolean answer = false;
        String queue = queueReader.readerLogin(login, password);
        if(queueReader.makeQueue(queue) == ""){
            answer = true;
        }
        return answer;
    }

    public static boolean checkIsNull(String login, String password)
    {
        boolean answer = false;
        if (login.isEmpty() | password.isEmpty())
        {
            answer = true;
        }
        return answer;
    }

    public static boolean checkIsNull(String author, String name, int year, String publisher)
    {
        boolean answer = false;
        if (author.isEmpty() | name.isEmpty() | year == 0 | publisher.isEmpty())
        {
            answer = true;
        }
        return answer;
    }

    public static boolean checkIsNull(String name, String surname, String patronymic, String region, String area,
                                      String city, String street, String phone, String passport, int home, int flat,
                                      LocalDate dates)
    {
        boolean answer = false;
        if (name.isEmpty() | surname.isEmpty() | patronymic.isEmpty() | region.isEmpty() | area.isEmpty() |
                city.isEmpty() | street.isEmpty() | phone.isEmpty() | passport.isEmpty() | home == 0 |
                dates.toString().isEmpty())
        {
            answer = true;
        }
        return answer;
    }
}
