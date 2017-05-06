package task.three;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import task.MainApp;
import task.errors.ErrorControls;

import java.util.Observable;

/**
 * Created by AMakas on 25.01.2017.
 */
public class ThreeController {
    @FXML
    private Button btnOk;
    @FXML
    private Button btnClose;
    @FXML
    private ComboBox cmbWork;
    @FXML
    private ChoiceBox chRegion;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSurname;
    @FXML
    private TextField tfLastname;
    @FXML
    private TextField tfCourse;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfCompany;
    @FXML
    private TextField tfPosition;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfHobby;
    @FXML
    private CheckBox cbDriveLicense;
    @FXML
    private CheckBox cbChildren;
    @FXML
    private RadioButton rbKnow1;
    @FXML
    private RadioButton rbKnow2;
    @FXML
    private RadioButton rbKnow3;
    @FXML
    private RadioButton rbKnow4;
    @FXML
    private TextField tfKnowOther;

    private MainApp mainApp;

    private ObservableList<String> listRegions = FXCollections.observableArrayList(
        "Минская область",
        "Гроденская область",
        "Витебская область",
        "Могилевская область",
        "Брестская область",
        "Гомельская область",
        "г. Минск"
    );
    private ObservableList<String> listworks = FXCollections.observableArrayList(
        "Курсовая работа",
        "Дипломная работа",
        "Интеллектуальная работа"
    );
    @FXML
    private void handleOk() {
        int res = CheckData();
        if ( res == 0 ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Все заполнено верно");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Ошибки: " + Integer.toString(res));
            alert.showAndWait();
        }
    }

    private int CheckData() {
        ErrorControls.notEmptyTextField(tfName);
        ErrorControls.notEmptyTextField(tfSurname);
        ErrorControls.notEmptyTextField(tfLastname);
        ErrorControls.notEmptyTextField(tfCourse);
        ErrorControls.notEmptyTextField(tfCity);
        ErrorControls.notEmptyTextField(tfCompany);
        ErrorControls.notEmptyTextField(tfPosition);
        ErrorControls.notEmptyTextField(tfPhone);
        if (!ErrorControls.notEmptyTextField(tfEmail)) {
            String err = "first";
        } else if (!ErrorControls.RegexTextBox(tfEmail, "^[0-9a-z_\\.-]+@[0-9a-z_\\.-]+\\.[a-z]{2,}?$")) {
            String err = "second";
        }

        ErrorControls.notEmptyTextField(tfHobby);
        if (cbChildren.isSelected()) {

        }
        if (rbKnow4.isSelected()) {
            ErrorControls.notEmptyTextField(tfKnowOther);
        }


        return ErrorControls.getTotalCount();
    }

    @FXML
    private void handleClose() {
        mainApp.getPrimaryStage().close();
    }

    @FXML
    private void handleKnow() {
        if (rbKnow4.isSelected()) {
            tfKnowOther.setDisable(false);
            //tfKnowOther.setText("222");
        } else {
            tfKnowOther.setDisable(true);
            tfKnowOther.setText("");

        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        cmbWork.setItems(listworks);
        cmbWork.getSelectionModel().select(0);
        chRegion.setItems(listRegions);
        chRegion.getSelectionModel().select(0);
    }




}
