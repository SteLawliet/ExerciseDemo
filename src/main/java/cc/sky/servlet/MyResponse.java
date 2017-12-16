package cc.sky.servlet;

import org.junit.Ignore;
import org.junit.Test;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import cc.practise.MyPrintWriter;

/**
 * Created by Stelawliet on 17/11/28.
 */
public class MyResponse extends HttpServletResponseWrapper {

    private HttpServletResponse httpServletResponse;

    private PrintWriter printWriter;

    private CharArrayWriter charArrayWriter;

    public MyResponse(HttpServletResponse response) {

        super(response);

        this.httpServletResponse = response;

        charArrayWriter = new CharArrayWriter();

    }

    @Override
    public PrintWriter getWriter() {

        System.out.println("MyResponse Start");

        return new PrintWriter(charArrayWriter, true);

    }

    public char[] getByteArray() {

        if (charArrayWriter != null) {
            charArrayWriter.close();
        }

        return charArrayWriter != null ? charArrayWriter.toCharArray() : new char[0];


    }


}
