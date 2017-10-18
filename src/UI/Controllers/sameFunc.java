package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class sameFunc {

    public static void createAlert(String type, String title, String header, String text)
    {
        Alert alert1 = new Alert(Alert.AlertType.WARNING);
        switch (type)
        {
            case "error":
            {
                alert1.setAlertType(Alert.AlertType.ERROR);
                break;
            }
            case "warning":
            {
                alert1.setAlertType(Alert.AlertType.WARNING);
                break;
            }
            case "information":
            {
                alert1.setAlertType(Alert.AlertType.INFORMATION);
                break;
            }
            default:
            {
                alert1.setAlertType(Alert.AlertType.INFORMATION);
            }
        }
        alert1.setTitle(title);
        alert1.setHeaderText(header);
        alert1.setContentText(text);
        alert1.showAndWait();
    }

}
