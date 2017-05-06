package task.two;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import task.MainApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by AMakas on 25.01.2017.
 */
public class TwoController {
    @FXML
    private TextField tbIn;
    @FXML
    private TextField tbOut;
    @FXML
    private Button btnGo;
    @FXML
    private Label lbError;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleGo() {
        Locale local = new Locale("ru","RU");
        Date date = checkDate(tbIn.getText());
        if (date != null) {
            Calendar calender = Calendar.getInstance();
            calender.setTime(date);
            tbOut.setText(this.getDayOfWeek(calender.get(Calendar.DAY_OF_WEEK)));
            lbError.setVisible(false);
        } else {
            lbError.setVisible(true);
        }
    }

    private String getDayOfWeek(int day) {
        String output = null;
        switch(day) {
            case 1:
                output = "Вторник";
                break;
            case 2:
                output = "Среда";
                break;
            case 3:
                output = "Четверг";
                break;
            case 4:
                output = "Пятница";
                break;
            case 5:
                output = "Суббота";
                break;
            case 6:
                output = "Воскресенье";
                break;
            default:
                output = "Понедельник";
                break;
        }

        return output;
    }

    private Date checkDate(String text) {
        Date date = null;
        boolean found = Pattern.matches("^\\d\\d\\.\\d\\d.\\d\\d\\d\\d$", text);
        if (found) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                date = formatter.parse(text);
                if ( !formatter.format(formatter.parse(text)).equals(text) ) {
                    date = null;
                }
            } catch (ParseException ex) {
                date = null;
            }
        }

        return date;
    }


}
