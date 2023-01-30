package org.example;

import java.io.*;

public class BufferedReaderAdapter implements FileLineReader{

    private final BufferedReader bufferedReader;

    public BufferedReaderAdapter(String inputFilePath) {
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
