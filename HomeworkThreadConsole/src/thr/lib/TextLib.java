package thr.lib;

/**
 * Created by AMakas on 30.01.2017.
 */
public class TextLib {
    static public String generateNumCar() {
        StringBuilder output = new StringBuilder();
        output.append( TextLib.generateNumber(4) );
        output.append( " " );
        output.append( TextLib.generateLetters(2).toUpperCase() );
        output.append( "-" );
        output.append( TextLib.generateNumber(1) );

        return output.toString();
    }

    static public String generateLetters(int length) {
        StringBuilder output = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0, rnd = 0; i < length; i++) {
            rnd = (int)( Math.random()*letters.length() );
            output.append( letters.substring( rnd, rnd + 1 ) );
        }

        return output.toString();
    }

    static public String generateNumber(int length) {
        StringBuilder output = new StringBuilder();
        String numbers = "1234567890";
        for (int i = 0, rnd = 0; i < length; i++) {
            rnd = (int)( Math.random()*numbers.length() );
            output.append( numbers.substring( rnd, rnd + 1 ) );
        }

        return output.toString();
    }
}
