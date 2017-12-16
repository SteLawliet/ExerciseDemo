package cc.practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Stelawliet on 17/12/15.
 */
public class MyPrintWriter extends PrintWriter {

    public MyPrintWriter(File file) throws FileNotFoundException {
        super(file);
    }

    public MyPrintWriter(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public void print(String s) {
        super.print(s);
        super.flush();
        super.close();
    }
}
