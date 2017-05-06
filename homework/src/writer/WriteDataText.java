package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by AMakas on 21.01.2017.
 */
public class WriteDataText extends WriteData {

    public WriteDataText() {
        super();
    }

    public<T> void writeObject(ArrayList<T> lists, boolean append) {
        try(FileWriter writer=new FileWriter (workDir + File.separator + fileName, append)) {
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
        try(FileWriter writer=new FileWriter(workDir + File.separator + fileName, append)) {
            writer.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
