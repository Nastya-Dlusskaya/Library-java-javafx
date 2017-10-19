package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.bd.BaseManagement;
import model.entity.Base;
import model.queue.queueBase;
import model.queue.queueBook;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerInformationAboutBook {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn bookColumn;

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
        bookColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("book"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Base, String>("reader"));
        getColumn.setCellValueFactory(new PropertyValueFactory<Base, Date>("getBook"));
        returnColumn.setCellValueFactory(new PropertyValueFactory<Base, Date>("returnBook"));
        bookTable.setItems(list);
    }

    private void initList()
    {
        try {
            list = (ObservableList) queueBase.returnBase(queueBase.selectAllReadBook());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
