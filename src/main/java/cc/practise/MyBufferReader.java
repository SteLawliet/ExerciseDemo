package cc.practise;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;

/**
 * Created by Stelawliet on 17/12/14.
 */
public class MyBufferReader extends BufferedReader {

    private BufferedReader in;

    private int count = 0;

    public MyBufferReader(BufferedReader in) {
        super(in);
        this.in = in;
    }

    @Override
    public String readLine() throws IOException {

        String s = in.readLine();

        if (s == null) {
            return null;
        }

        return String.valueOf(count++) + " : " + s;
    }


    public static void main(String[] args) {

        URL file = file = MyBufferReader.class.getClassLoader().getResource("a.txt");
        String file1 = file.getFile();
        try {

//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));

            MyBufferReader myBufferReader = new MyBufferReader
                    (new BufferedReader(new FileReader(file1)));
            String s;

            while ((s = myBufferReader.readLine()) != null) {

                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
