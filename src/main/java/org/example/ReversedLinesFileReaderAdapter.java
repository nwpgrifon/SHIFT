package org.example;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class ReversedLinesFileReaderAdapter implements FileLineReader {

    private final ReversedLinesFileReader reversedLinesFileReader;

    public ReversedLinesFileReaderAdapter(String inputFilePath) {
        try {
            this.reversedLinesFileReader = new ReversedLinesFileReader(new File(inputFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readLine() {
        try {
            return reversedLinesFileReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            reversedLinesFileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
