package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerLibririan {

    private Alert alert = new Alert(Alert.AlertType.WARNING);

    public void showAddBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleAddBook.fxml"));
            stage.setTitle("Добавление книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается добавление", "Ошибка", exp.getMessage());
        }
    }

    public void showDeleteBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleDeleteBook.fxml"));
            stage.setTitle("Удаление книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается удаление", "Ошибка", exp.toString());
        }
    }

    public void showEditBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleInformationBook.fxml"));
            stage.setTitle("Редактирование книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается редактирование", "Ошибка", exp.getMessage());
        }
    }

    public void showInformationAboutBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleInformationAboutBook.fxml"));
            stage.setTitle("Информация о выданных книгах");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается информациооное окно", "Ошибка", exp.getMessage());
            exp.printStackTrace();
        }
    }

    public void showInformationAboutReader(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleInformationReader.fxml"));
            stage.setTitle("Информация о читателях");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается информационное окно", "Ошибка", exp.getMessage());
            exp.printStackTrace();
        }
    }

    public void showGetBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleGetBook.fxml"));
            stage.setTitle("Выдача книг");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается выдача книг", "Ошибка", exp.getMessage());
        }
    }

    public void showReturnBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleReturnBook.fxml"));
            stage.setTitle("Возврат книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception exp)
        {
            sameFunc.createAlert("error", "Не открывается возврат книг", "Ошибка", exp.getMessage());
        }
    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
