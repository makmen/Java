package task.one;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import task.MainApp;

/**
 * Created by AMakas on 25.01.2017.
 */
public class OneController {
    @FXML
    private Label lbRun;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void onMouseMoved() {
        AnchorPane st =  mainApp.getPersonOverview();

        double x = (Math.random()*st.getWidth());
        double y = (Math.random()*st.getHeight());
        lbRun.setLayoutX(x);
        lbRun.setLayoutY(y);
    }


}
