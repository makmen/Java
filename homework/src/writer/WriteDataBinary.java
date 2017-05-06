package writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by AMakas on 21.01.2017.
 */
public class WriteDataBinary extends WriteData {

    public WriteDataBinary() {
        super();
    }

    public<T> void writeObject(ArrayList<T> lists, boolean append) {
        try(FileOutputStream fos=new FileOutputStream(workDir + File.separator + fileName, append)) {
            byte[] buffer;
            for (T item : lists) {
                buffer = (item.toString() + "\r\n").getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void writeString(String text) {
        text += "\r\n";
        try(FileOutputStream fos=new FileOutputStream(workDir + File.separator + fileName, true)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
