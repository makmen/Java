package lib;

import java.util.List;
import java.util.Map;

/**
 * Created by AMakas on 16.02.2017.
 */
public class Checker {

    public static double checkDoubleParam(String key, String value, List<String> outErrors, Map<String, String> outAttribute) {
        outAttribute.put(key, value);
        StringBuilder error = new StringBuilder("");
        double out = Number.getDouble(value, error);
        if (!error.toString().equals("")) {
            outErrors.add(error.toString());
        }

        return out;
    }


}
