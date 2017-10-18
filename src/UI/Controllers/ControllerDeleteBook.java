package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.entity.Book;
import model.queue.queueBook;

import java.sql.SQLException;

public class ControllerDeleteBook {

    private ObservableList<Book> list = FXCollections.observableArrayList();

    @FXML
    private ListView bookList;

    @FXML
    private Button deleteButton;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        String queue = queueBook.allBook();
        list = (ObservableList<Book>) queueBook.makeQueueReturn(queue);
        bookList.setItems(list);
    }

    public void deleteBook(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Book focusedItem = (Book) bookList.getSelectionModel().getSelectedItem();
        String queue = queueBook.deleteBook(focusedItem.getAuthor(), focusedItem.getName(), focusedItem.getYear(),
                focusedItem.getPublisher());
        list.remove(focusedItem);
        bookList.setItems(list);
        try {
            queueBook.makeQueue(queue);
        } catch (SQLException e) {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", e.toString());
        } catch (ClassNotFoundException e) {
            sameFunc.createAlert("error", "Ошибка", "Появилась ошибка", e.toString());
        }
    }

    public void chooseAndUnblock(MouseEvent actionEvent)
    {
        deleteButton.setDisable(false);
    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
