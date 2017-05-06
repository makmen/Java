package writer;

import java.io.File;

/**
 * Created by AMakas on 21.01.2017.
 */
public class WriteData {
    protected String fileName = "figures.txt";
    protected File workDir;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public WriteData() {
        workDir = new File("data");
        if(!workDir.exists() || !workDir.isDirectory()) {
            workDir.mkdir();
        }
    }

}
