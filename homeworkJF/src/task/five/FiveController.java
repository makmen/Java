package task.five;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import task.MainApp;
import task.debug.ShowAlarm;


/**
 * Created by AMakas on 25.01.2017.
 */
public class FiveController {

    @FXML
    private TextArea taMain;

    private boolean changed = false;
    private StringBuilder buffer = new StringBuilder();

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleNew() {
        taMain.setText("");
    }
    @FXML
    private void handleOpen() {
        ShowAlarm.show("", "handleOpen");
    }
    @FXML
    private void handleSave() {
        ShowAlarm.show("", "handleSave");
    }
    @FXML
    private void handleSaveAs() {
        ShowAlarm.show("", "handleClose");
    }
    @FXML
    private void handleClose() {
        mainApp.getPrimaryStage().close();
    }
    @FXML
    private void handleUndo() {
        ShowAlarm.show("", "handleUndo");
    }
    @FXML
    private void handleRedo() {
        ShowAlarm.show("", "handleRedo");
    }
    @FXML
    private void handleCut() {
        if ( taMain.getSelectedText().length() > 0 ) {
            buffer.delete(0, buffer.length());
            buffer.append(taMain.getSelectedText());
        }
    }
    @FXML
    private void handleCopy() {
        if ( taMain.getSelectedText().length() > 0 ) {
            buffer.delete(0, buffer.length());
            buffer.append(taMain.getSelectedText());
        }
    }
    @FXML
    private void handlePaste() {
        ShowAlarm.show("", "handlePaste");
    }
    @FXML
    private void handleSelectAll() {
        taMain.selectAll();
    }
    @FXML
    private void handleAbout() {
        ShowAlarm.show("Makas Andrey Kazimirovich", "Cool Text Editor\r\nAll rights reserved");
    }

    @FXML
    private void handleChanged() {
        ShowAlarm.show("Makas Andrey Kazimirovich", "Cool Text Editor\r\nAll rights reserved");


    }



}
