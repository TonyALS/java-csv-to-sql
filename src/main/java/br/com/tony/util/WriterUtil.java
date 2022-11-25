package br.com.tony.util;

import java.io.*;

public class WriterUtil {
    public static BufferedWriter getWriter(String outputName) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(outputName);
        Writer writer = new OutputStreamWriter(outputStream);
        return new BufferedWriter(writer);
    }
}
