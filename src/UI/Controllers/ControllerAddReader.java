package UI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import model.check.Check;
import model.queue.queueBook;
import model.queue.queueReader;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class ControllerAddReader {

    @FXML
    private DatePicker date;

    @FXML
    private TextField firstnameEdit;

    @FXML
    private TextField patronymicEdit;

    @FXML
    private TextField lastnameEdit;

    @FXML
    private TextField regionEdit;

    @FXML
    private TextField areaEdit;

    @FXML
    private TextField cityEdit;

    @FXML
    private TextField streetEdit;

    @FXML
    private TextField homeEdit;

    @FXML
    private TextField flatEdit;

    @FXML
    private TextField phoneEdit;

    @FXML
    private TextField passportEdit;

    @FXML
    private TextField loginEdit;

    @FXML
    private TextField passwordEdit;

    public void showBack(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }


    public void adReader(ActionEvent actionEvent) {
        try {
            String name = firstnameEdit.getText(), surname = lastnameEdit.getText(), patronymic = patronymicEdit.getText(),
                    region = regionEdit.getText(), area = areaEdit.getText(), city = cityEdit.getText(),
                    street = streetEdit.getText(), phone = phoneEdit.getText(), passport = passportEdit.getText(),
                    login = loginEdit.getText(), password = passwordEdit.getText();
            int home = parseInt(homeEdit.getText()), flat = parseInt(flatEdit.getText());
            LocalDate dates = date.getValue();

            if (Check.checkIsNull(name, surname, patronymic, region, area, city, street, phone, passport, home, flat,
                    dates) && Check.checkIsNull(login, password)) {
                sameFunc.createAlert("warning", "Ошибка", "Пустое поле", "Вы не заполнили поле!" +
                        " Проверьте свои данные");
            }
            else if(Check.checkLoginAndPasswordReader(login,password))
            {
                sameFunc.createAlert("warning", "Проверка логина и пароля", "Ошибка", "Такой пароль или" +
                        " логин уже есть");
            }
            else
            {
                String queue = queueReader.addReader(name, surname, patronymic, region, area, city, street, phone,
                        passport, home, flat, dates);
                String queueLogin = queueReader.addLogin(login, password);
                queueBook.makeQueue(queue);
                queueBook.makeQueue(queueLogin);
                showBack(actionEvent);
                sameFunc.createAlert("information", "Добавление", "Добавление прошло успешно", "");
            }
        } catch (NumberFormatException e) {
            sameFunc.createAlert("warning", "Ошибка", "Программа выдаёт ошибку", "Вы ввели вместо числа символ");
        } catch (SQLException e) {
            sameFunc.createAlert("warning", "Ошибка", "Программа выдаёт ошибку", e.toString());
        } catch (ClassNotFoundException e) {
            sameFunc.createAlert("warning", "Ошибка", "Программа выдаёт ошибку", e.toString());
        }catch (Exception e)        {
            sameFunc.createAlert("warning", "Ошибка", "Программа выдаёт ошибку", e.toString());
        }
    }
}

