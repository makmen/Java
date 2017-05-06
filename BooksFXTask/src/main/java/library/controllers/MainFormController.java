package library.controllers;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import library.MainApp;
import library.models.Book;
import library.models.Genre;
import library.models.Publishing;
import libs.ShowAlarm;

/**
 * Created by AMakas on 25.01.2017.
 */
public class MainFormController {
    @FXML
    private TableView tblBook;

    @FXML
    private TableColumn<Book, String> idColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;
    @FXML
    private TableColumn<Book, String> publishingColumn;

    private MainApp mainApp;
    public MainApp getMainApp() {
        return mainApp;
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void onAdd() {
        mainApp.showBookDialog(null);
    }

    @FXML
    private void onEdit() {
        Book book = ((Book)tblBook.getSelectionModel().getSelectedItem());
        if (book != null) {
            mainApp.showBookDialog(book);
        }
    }

    @FXML
    private void onDelete() {
        Book book = ((Book)tblBook.getSelectionModel().getSelectedItem());
        if (book != null) {
            for(Book item : mainApp.getBookDataList()) {
                if (item.getId().equals(book.getId())) {
                    mainApp.getBookDataList().remove(item);
                    break;
                }
            }
        }
    }

    public void bindBooks() {
        mainApp.getGenreDataList().add(new Genre("Action"));
        mainApp.getGenreDataList().add(new Genre("Rossi"));
        mainApp.getGenreDataList().add(new Genre("Killun"));
        mainApp.getGenreDataList().add(new Genre("Аргентина"));

        mainApp.getPublishingDataList().add(new Publishing("Lido", "RU"));
        mainApp.getPublishingDataList().add(new Publishing("Питер", "BY"));
        mainApp.getPublishingDataList().add(new Publishing("Краснюк", "AR"));

        Book book = new Book(
                "title", "autror",
                mainApp.getGenreDataList().get(0).getTitle(), mainApp.getPublishingDataList().get(0).toString()
        );
        mainApp.getBookDataList().add(book);

        book = new Book(
                "title11", "autror222",
                mainApp.getGenreDataList().get(1).getTitle(), mainApp.getPublishingDataList().get(1).toString()
        );
        mainApp.getBookDataList().add(book);

        book = new Book(
                "Торт", "Kros",
                mainApp.getGenreDataList().get(2).getTitle(), mainApp.getPublishingDataList().get(2).toString()
        );
        mainApp.getBookDataList().add(book);

        tblBook.setItems(mainApp.getBookDataList());
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        publishingColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishing"));
    }


}
