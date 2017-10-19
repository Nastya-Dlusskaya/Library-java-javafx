package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.check.Check;
import model.queue.queueBook;

import java.sql.SQLException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class ControllerEditBook {

    @FXML
    private TextField authorEdit;

    @FXML
    private TextField nameEdit;

    @FXML
    private TextField yearEdit;

    @FXML
    private TextField publisherEdit;

    @FXML
    private Button editButton;

    @FXML
    private void initialize()
    {

    }

    public void editBook(ActionEvent actionEvent)
    {
        try {
            String author = authorEdit.getText(), name = nameEdit.getText(), publisher = publisherEdit.getText();
            int year = parseInt(yearEdit.getText());
            if(Check.checkIsNull(author, name, year, publisher))
            {
                sameFunc.createAlert("error", "Ошибка", "Пустое поле", "Вы не заполнили поле!" +
                        " Проверьте свои данные");
            }
            else if((Check.checkStringMinSize(author, 2) && Check.checkStringMaxSize(author, 30)) |
                    (Check.checkStringMinSize(name, 1) && Check.checkStringMaxSize(name, 60)) |
                    (Check.checkStringMinSize(publisher, 2) && Check.checkStringMaxSize(publisher, 60)) |
                    ((year > 1500) && (year <= LocalDate.now().getYear())))
            {
                sameFunc.createAlert("warning", "Неверные данные", "Вы ввели неверный значение для этого типа",
                        "Допустимое значения для строк: мин - 2 символа, макс - 60 символов");
            }
            else {
                String queue = queueBook.addBook(author, name, year, publisher);
                queueBook.makeQueue(queue);
                showBack(actionEvent);
                sameFunc.createAlert("information", "Добавление", "Добавление прошло успешно", "");
            }
        }
        catch (NumberFormatException e)
        {
            sameFunc.createAlert("error", "Ошибка", "Пустое поле", "Вы не заполнили поле!" +
                    " Проверьте свои данные");
        }
        catch (SQLException e) {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", e.toString());
        }
        catch (ClassNotFoundException e) {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", e.toString());
        }

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
