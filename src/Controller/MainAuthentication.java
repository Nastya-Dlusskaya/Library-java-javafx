package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import model.bd.BaseManagement;

import java.sql.SQLException;


public class MainAuthentication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../UI/FXMLs/sampleAuthentication.fxml"));
        primaryStage.setTitle("Authentication");
        Scene scene = new Scene(root,  445, 180);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
