package lib;

/**
 * Created by AMakas on 15.02.2017.
 */
public class Number {
    public static double getDouble(String number, StringBuilder error) {
        double out = 0;
        try {
            out = Double.parseDouble(number);
        } catch (Exception ex) {
            error.append( ex.getMessage() );
        }

        return out;
    }

    public static int getInt(String number, StringBuilder error) {
        int out = 0;
        try {
            out = Integer.parseInt(number);
        } catch (Exception ex) {
            error.append( ex.getMessage() );
        }

        return out;
    }
}
