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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entity.Book;
import model.entity.Reader;
import model.queue.queueBook;
import model.queue.queueReader;

import java.sql.SQLException;

public class ControllerInformationReader {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private ListView readersList;

    @FXML
    private Button editButton;

    @FXML
    private TextArea textReader;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        String queue = queueReader.selectAllReader();
        list = (ObservableList<Reader>) queueReader.makeQueueReturn( queue);
        readersList.setItems(list);
    }

    public void chooseReader(MouseEvent actionEvent)
    {
        editButton.setDisable(false);
        Reader focusedItem = (Reader) readersList.getSelectionModel().getSelectedItem();
        textReader.setWrapText(true);
        textReader.setPromptText(focusedItem.fullString());
    }


    public void showEditReader(ActionEvent actionEvent)
    {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleEditReader.fxml"));
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
