package UI.Controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.entity.Base;
import model.entity.Book;
import model.entity.Reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerReader {

    private ObservableList<Base> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Base, String> authorColumn;

    @FXML
    private TableColumn<Base, String> nameColumn;

    @FXML
    private TableColumn<Base, Date> getColumn;

    @FXML
    private TableColumn<Base, Date> returnColumn;

    @FXML
    private TableView<Base> bookTable;

    @FXML
    private void initialize()
    {
        initList();
        authorColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("bookAuthor"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("bookName"));
        getColumn.setCellValueFactory(new PropertyValueFactory<Base, Date>("getBook"));
        returnColumn.setCellValueFactory(new PropertyValueFactory<Base, Date>("returnBook"));


        bookTable.setItems(list);
    }

    private void initList()
    {

    }

    public void showSearchBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleSearchBook.fxml"));
            stage.setTitle("Поиск книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch(Exception exp)
        {
            System.out.println("2");
        }
    }

    public void showReadBook(ActionEvent actionEvent)
    {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/sampleReadBook.fxml"));
            stage.setTitle("Прочитанные книги");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch(Exception exp)
        {
            System.out.println("3");
        }

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
