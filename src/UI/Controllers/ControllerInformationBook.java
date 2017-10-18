package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entity.Book;
import model.entity.Reader;
import model.queue.queueBook;
import model.queue.queueReader;

import java.sql.SQLException;

public class ControllerInformationBook {

    private ObservableList<Book> list = FXCollections.observableArrayList();
    @FXML
    private ListView readersList;

    @FXML
    private Button editButton;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        String queue = queueBook.allBook();
        list = (ObservableList<Book>) queueReader.makeQueueReturn( queue);
        readersList.setItems(list);
    }

    public void showEditBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleEditBook.fxml"));
            stage.setTitle("Редактирование");
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

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
