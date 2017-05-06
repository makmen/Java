package library.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.MainApp;
import library.models.Genre;
import libs.ErrorControls;
import libs.ShowAlarm;

/**
 * Created by AMakas on 08.02.2017.
 */
public class GenreController {
    @FXML
    private TextField tfTitle;

    private MainApp mainApp;

    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private Genre editGenre;

    public void setGenre(Genre genre) {
        this.editGenre = genre;
        if (editGenre != null) {
            tfTitle.setText(editGenre.getTitle());
        }
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    @FXML
    private void handleOk() {
        int res = CheckData();
        if ( res == 0 ) {
            if (editGenre != null) {
                editGenre.setTitle(tfTitle.getText());
            } else {
                Genre genre = new Genre(tfTitle.getText());
                mainApp.getGenreDataList().add(genre);
            }
            dialogStage.close();
        } else {
            ShowAlarm.show("error", "error");
        }
    }

    private int CheckData() {
        ErrorControls.notEmptyTextField(tfTitle);

        return ErrorControls.getTotalCount();
    }

}
