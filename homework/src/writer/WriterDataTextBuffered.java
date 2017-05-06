package writer;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by AMakas on 21.01.2017.
 */
public class WriterDataTextBuffered extends WriteData {

    public WriterDataTextBuffered() {
        super();
    }

    public<T> void writeObject(ArrayList<T> lists, boolean append) {
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(workDir + File.separator + fileName, append))) {
            for (T item : lists) {
                writer.write(item.toString() + "\r\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void writeString(String text, boolean append) {
        text += "\r\n";
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(workDir + File.separator + fileName, append))) {
            writer.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> readString() {
        ArrayList<String> output = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new FileReader(workDir + File.separator + fileName))) {
            String s;
            while((s=reader.readLine())!=null){
                output.add(s);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return output;
    }
}
