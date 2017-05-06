package task.errors;

import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**
 * Created by AMakas on 25.01.2017.
 */
public class ErrorControls {
    static private int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ErrorControls.count = count;
    }

    static public boolean notEmptyTextField(TextField tf)
    {
        boolean check = true;
        if ( tf.getText().equals("") )
        {
            check = false;
        } else {

        }
        countErrors(check);

        return check;
    }

    static public boolean RegexTextBox(TextField tf, String pattern)
    {
        boolean check = Pattern.matches(pattern, tf.getText());
        if (!check)
        {

        }
        else
        {

        }
        countErrors(check);

        return check;
    }

    static public int getTotalCount()
    {
        int i = count;
        count = 0;

        return i;
    }

    static private void countErrors(boolean check)
    {
        if (!check)
        {
            ++count;
        }
    }


}

