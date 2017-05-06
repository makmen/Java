package library.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.MainApp;
import library.models.Publishing;
import libs.ErrorControls;
import libs.ShowAlarm;

/**
 * Created by AMakas on 08.02.2017.
 */
public class PublishingController {
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfCountry;

    private MainApp mainApp;

    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private Publishing editPublishing;

    public void setPublishing(Publishing publishing) {
        this.editPublishing = publishing;
        if (editPublishing != null) {
            tfTitle.setText(editPublishing.getTitle());
            tfCountry.setText(editPublishing.getCountry());
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
            Publishing publishing = new Publishing();
            publishing.setTitle(tfTitle.getText());
            publishing.setCountry(tfCountry.getText());
            if (editPublishing != null) {
                publishing.setId(editPublishing.getId());
                editPublishing.setTitle(tfTitle.getText());
                editPublishing.setCountry(tfCountry.getText());
            } else {
                mainApp.getPublishingDataList().add(publishing);
            }
            mainApp.getPublishingRepository().set(publishing);
            dialogStage.close();
        } else {
            ShowAlarm.show("error", "error");
        }
    }

    private int CheckData() {
        ErrorControls.notEmptyTextField(tfTitle);
        ErrorControls.notEmptyTextField(tfCountry);

        return ErrorControls.getTotalCount();
    }
}
