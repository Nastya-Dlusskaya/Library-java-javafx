package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControllerEditReader {

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

    public void editReader(ActionEvent actionEvent)
    {

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
