package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerSearchBook {

    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextField searchAuthor;

    @FXML
    private TextField searchName;

    @FXML
    private TableColumn authorColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableView bookTable;

    @FXML
    private void initialize()
    {
        initList();
        authorColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("bookAuthor"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("bookName"));

        bookTable.setItems(list);
    }

    private void initList()
    {
        try {
            list.add(new Base("asd", "asd", new
                    SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"),
                    new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11")));
        }catch (ParseException e){
            System.out.println("qwe");
        }

    }

    public void searchBook(ActionEvent actionEvent)
    {

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }

    public void authorCheck(ActionEvent actionEvent) {
    }

    public void nameCheck(ActionEvent actionEvent) {
    }
}
