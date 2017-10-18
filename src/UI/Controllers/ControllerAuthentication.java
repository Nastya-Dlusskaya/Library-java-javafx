package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.check.Check;

public class ControllerAuthentication {

    @FXML
    private TextField readerLogin;

    @FXML
    private PasswordField readerPassword;

    @FXML
    private TextField librarianLogin;

    @FXML
    private PasswordField librarianPassword;

    public void showDialog(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        try {

            if(Check.checkIsNull(readerLogin.getText(), readerPassword.getText()))
            {
                sameFunc.createAlert("warning", "Ошибка", "Пустое поле", "Вы не заполнили поле! " +
                        "Проверьте свои данные");
            }
            else if(Check.checkLoginAndPasswordReader(readerLogin.getText(), readerPassword.getText()))
            {
                ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleReader.fxml"));
                stage.setTitle("Аккаунт читателя");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.show();
            }
            else
            {
                sameFunc.createAlert("warning", "Ошибка", "Неверное значение", "Вы ввели неправильный логин " +
                        "или пароль! Проверьте свои данные");
            }
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("warning", "Ошибка", "Данная программа выдала ошибку:", exp.getMessage());
        }
    }


    public void showLibrarian(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.WARNING);

        try {
           if(Check.checkIsNull(librarianLogin.getText(), librarianPassword.getText()))
            {
                sameFunc.createAlert("warning", "Ошибка", "Пустое поле", "Вы не заполнили поле! " +
                        "Проверьте свои данные");
            }
            else if(Check.checkLoginAndPasswordLibrarian(librarianLogin.getText(), librarianPassword.getText()))
            {
                ((Node) actionEvent.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleLibririan.fxml"));
                stage.setTitle("Аккаунт библиотекаря");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.show();
            }
            else
            {
                sameFunc.createAlert("warning", "Ошибка", "Неверное значение", "Вы ввели неверный логин или пароль!" +
                        " Проверьте свои данные");
            }
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("warning", "Ошибка", "Данная программа выдала ошибку:", exp.getMessage());
        }
    }

    public void showGuest(ActionEvent actionEvent){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleSearchBook.fxml"));
            stage.setTitle("Гость");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", exp.toString());
        }
    }

    public void showAddReader(ActionEvent actionEvent){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleAddReader.fxml"));
            stage.setTitle("Зарегистрироваться");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", exp.toString());
        }
    }
}
