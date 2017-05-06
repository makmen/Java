package libs;

import javafx.scene.control.Alert;

/**
 * Created by AMakas on 27.01.2017.
 */
public class ShowAlarm {

    static public void show(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
