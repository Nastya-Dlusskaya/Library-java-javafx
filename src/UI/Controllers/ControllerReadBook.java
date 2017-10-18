package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerReadBook {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TableColumn authorColumn;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn getColumn;

    @FXML
    private TableColumn returnColumn;

    @FXML
    private TableView bookTable;

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
        try {
            list.add(new Base("asd", "asd", new
                    SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"),
                    new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11")));
        }catch (ParseException e){
            System.out.println("qwe");
        }

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
