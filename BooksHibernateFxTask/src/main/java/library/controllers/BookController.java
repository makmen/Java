package library.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.MainApp;
import library.models.Book;
import library.models.Genre;
import library.models.Publishing;
import libs.ErrorControls;
import libs.ShowAlarm;


/**
 * Created by AMakas on 08.02.2017.
 */
public class BookController {
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfAuthor;
    @FXML
    private ComboBox cmbGenre;
    @FXML
    private ChoiceBox chPublishing;

    private Book editBook;

    private MainApp mainApp;
    public MainApp getMainApp() {
        return mainApp;
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void bindCombo() {
        cmbGenre.setItems(mainApp.getGenreDataList());
        chPublishing.setItems(mainApp.getPublishingDataList());
    }

    public void setBook(Book book) {
        this.editBook = book;
        if (editBook != null) {
            tfTitle.setText(editBook.getTitle());
            tfAuthor.setText(editBook.getAuthor());
            cmbGenre.getSelectionModel().select( findGenre(editBook.getGenre()) );
            chPublishing.getSelectionModel().select( findPublishing(editBook.getPublishing()) );
        }
    }

    private int findPublishing(Publishing publishing) {
        int index = 0;
        for (Publishing item : mainApp.getPublishingDataList()) {
            if (item.getId() == publishing.getId()) {
                return index;
            }
            index++;
        }

        return 0;
    }

    private int findGenre(Genre genre) {
        int index = 0;
        for (Genre item : mainApp.getGenreDataList()) {
            if (item.getId() == genre.getId()) {
                return index;
            }
            index++;
        }

        return 0;
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    @FXML
    private void handleAddGenre() {
        mainApp.showGenreDialog(dialogStage, null);
    }

    @FXML
    private void handleEditGenre() {
        Genre genre = (Genre) cmbGenre.getSelectionModel().getSelectedItem();
        if (genre != null) {
            mainApp.showGenreDialog(dialogStage, genre);
        }
    }

    @FXML
    private void handleDeleteGenre() {
        Genre genre = (Genre) cmbGenre.getSelectionModel().getSelectedItem();
        if (genre != null) {
            mainApp.getGenreDataList().remove( findGenre(genre) );
            mainApp.getGenreRepository().delete(genre);
            if (mainApp.getGenreDataList().size() > 0) {
                cmbGenre.getSelectionModel().select(0);
            }
        }
    }

    @FXML
    private void handleAddPublishing() {
        mainApp.showPublishingDialog(dialogStage, null);
    }

    @FXML
    private void handleEditPublishing() {
        Publishing publishing = (Publishing) chPublishing.getSelectionModel().getSelectedItem();
        if (publishing != null) {
            mainApp.showPublishingDialog(dialogStage, publishing);
        }
    }
    @FXML
    private void handleDeletePublishing() {
        Publishing publishing = (Publishing) chPublishing.getSelectionModel().getSelectedItem();
        if (publishing != null) {
            mainApp.getPublishingDataList().remove( findPublishing(publishing) );
            mainApp.getPublishingRepository().delete(publishing);
            if (mainApp.getPublishingDataList().size() > 0) {
                chPublishing.getSelectionModel().select(0);
            }
        }
    }
    @FXML
    private void handleOk() {
        int res = CheckData();
        if ( res == 0 ) {
            Book book = new Book(
                tfTitle.getText(),
                tfAuthor.getText(),
                (Genre)cmbGenre.getSelectionModel().getSelectedItem(),
                (Publishing)chPublishing.getSelectionModel().getSelectedItem()
            );
            if (editBook != null) {
                book.setId(editBook.getId());
                editBook.setTitle(book.getTitle());
                editBook.setAuthor(book.getAuthor());
                editBook.setGenre(book.getGenre());
                editBook.setPublishing(book.getPublishing());
             } else {
                mainApp.getBookDataList().add(book);
            }
            mainApp.getBookRepository().set(book);
            dialogStage.close();
        } else {
            ShowAlarm.show("error", "error");
        }
    }

    private int CheckData() {
        ErrorControls.notEmptyTextField(tfTitle);
        ErrorControls.notEmptyTextField(tfAuthor);
        Genre genre = (Genre) cmbGenre.getSelectionModel().getSelectedItem();
        if (genre == null) {
            ErrorControls.countErrors(false);
        }
        Publishing publishing = (Publishing) chPublishing.getSelectionModel().getSelectedItem();
        if (publishing == null) {
            ErrorControls.countErrors(false);
        }

        return ErrorControls.getTotalCount();
    }

}
