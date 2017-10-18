package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.check.Check;
import model.entity.Book;
import model.entity.Reader;
import model.queue.queueBase;
import model.queue.queueBook;
import model.queue.queueReader;

import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerGetBook {

    ObservableList listReader = FXCollections.observableArrayList();
    ObservableList listBook = FXCollections.observableArrayList();

    private Book book;
    private Reader reader;

    @FXML
    private ListView readerList;

    @FXML
    private ListView bookList;

    @FXML
    private Button getButton;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        String queue = queueBook.allFreeBook();
        String queueRead = queueReader.selectAllReader();
        listBook = (ObservableList<Book>) queueBook.makeQueueReturn( queue);
        listReader = (ObservableList<Reader>) queueReader.makeQueueReturn(queueRead);
        bookList.setItems(listBook);
        readerList.setItems(listReader);
    }

    public void chooseReader(MouseEvent mouseEvent)
    {
        Book focusedBook = (Book) bookList.getSelectionModel().getSelectedItem();
        Reader focusedReader = (Reader) readerList.getSelectionModel().getSelectedItem();
        if(focusedBook != null && focusedReader != null)
        {
           getButton.setDisable(false);
        }
    }

    public void chooseBook(MouseEvent mouseEvent)
    {
        book = (Book) bookList.getSelectionModel().getSelectedItem();
        reader = (Reader) readerList.getSelectionModel().getSelectedItem();
        if(book != null && reader != null)
        {
            getButton.setDisable(false);
        }
    }

    public void getBook(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int idBook = queueBook.getId(queueBook.selectIdBook(book.getAuthor(), book.getName()));
        int idReader = queueBook.getId(queueReader.selectIdReader(reader.getLastName(), reader.getFirstName(),
                reader.getPatronymic()));
        queueBook.makeQueue(queueBase.getBook(idReader, idBook, LocalDate.now().toString(), ""));
        sameFunc.createAlert("information", "Выдача книг", "Операция прошла успешна",
                    reader.toString() + ' ' + book.toString());
        listBook.remove(book);
        queueBook.makeUpdateQueue(queueBook.updatePropertyIsFree(idBook, false));

    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }

}
