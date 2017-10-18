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
import model.entity.Reader;
import model.queue.queueBase;
import model.queue.queueBook;
import model.queue.queueReader;

import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerReturnBook {

    ObservableList listReader = FXCollections.observableArrayList();
    ObservableList listBook = FXCollections.observableArrayList();

    private Book book;
    private Reader reader;
    private int idReader;

    @FXML
    private ListView readersList;

    @FXML

    private ListView bookList;

    @FXML
    private Button returnButton;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        listReader = (ObservableList<Reader>) queueReader.makeQueueReturn(queueReader.selectAllReader());
        readersList.setItems(listReader);
    }

    public void chooseReader(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        Reader reader = (Reader) readersList.getSelectionModel().getSelectedItem();
        idReader = queueBook.getId(queueReader.selectIdReader(reader.getLastName(), reader.getFirstName(),
                reader.getPatronymic()));
        listBook = (ObservableList<Book>) queueBook.makeQueueReturn(queueBase.selectReadBook(idReader));
        bookList.setItems(listBook);
    }

    public void chooseBook(MouseEvent mouseEvent)
    {
        book = (Book) bookList.getSelectionModel().getSelectedItem();
        reader = (Reader) readersList.getSelectionModel().getSelectedItem();
        if(book != null && reader != null)
        {
            returnButton.setDisable(false);
        }
    }


    public void returnBook(ActionEvent actionEvent){
        int idBook = 0;
        int idReader = 0;
        try {
            idBook = queueBook.getId(queueBook.selectIdBook(book.getAuthor(), book.getName()));
            idReader = queueBook.getId(queueReader.selectIdReader(reader.getLastName(), reader.getFirstName(),
                    reader.getPatronymic()));
            listBook.remove(book);
            queueBook.makeUpdateQueue(queueBook.updatePropertyIsFree(idBook, true));
            queueBook.makeUpdateQueue(queueBase.returnBook(idReader, idBook, LocalDate.now().toString()));
        } catch (SQLException e) {
            sameFunc.createAlert("error", "Ошибка соединения", "Ошибкаа соединения с базой данных",
                    "Проверьте, используют ли другие приложения эту базу данных");
        } catch (ClassNotFoundException e) {
            sameFunc.createAlert("error","Ошибка класса","Не найден класс",e.getMessage());
        }


    }

    public void showBack(ActionEvent actionEvent)
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
    }
}
