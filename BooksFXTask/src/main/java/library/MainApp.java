package library;/**
 * Created by AMakas on 24.01.2017.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;


import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import library.controllers.BookController;
import library.controllers.GenreController;
import library.controllers.MainFormController;
import library.controllers.PublishingController;
import library.models.Book;
import library.models.Genre;
import library.models.Publishing;


public class MainApp extends Application {

    private Stage primaryStage;
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private AnchorPane personOverview;
    public AnchorPane getPersonOverview() {
        return personOverview;
    }

    private ObservableList<Book> bookDataList = FXCollections.observableArrayList();
    public ObservableList<Book> getBookDataList() {
        return bookDataList;
    }
    private ObservableList<Genre> genreDataList = FXCollections.observableArrayList();
    public ObservableList<Genre> getGenreDataList() {
        return genreDataList;
    }
    private ObservableList<Publishing> publishingDataList = FXCollections.observableArrayList();
    public ObservableList<Publishing> getPublishingDataList() {
        return publishingDataList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddredssApp");

        initMainForm();

    }

    public void initMainForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../mainForm.fxml"));

            personOverview = (AnchorPane) loader.load();

            Scene scene = new Scene(personOverview);
            primaryStage.setScene(scene);

            MainFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.bindBooks();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBookDialog(Book book) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../showBook.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BookController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.bindCombo();
            controller.setBook(book);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGenreDialog(Stage dialogStageOwner, Genre genre) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../showGenre.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Genre");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(dialogStageOwner);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            GenreController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setGenre(genre);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPublishingDialog(Stage dialogStageOwner, Publishing publishing) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../showPublishing.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Publishing");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(dialogStageOwner);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PublishingController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setPublishing(publishing);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
