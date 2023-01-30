package org.example;
import java.io.*;
import java.util.*;
public class MergeSort {
    private static Comparator<String> comparator;

    public static void mergeSortFiles(Configuration configuration) throws IOException {
        List<String> inputFiles = configuration.getInputFilesPaths();
        FileLineReader[] readers = getReaders(configuration);
        BufferedWriter writer = new BufferedWriter(new FileWriter(configuration.getOutputFilePath()));
        comparator = getComparator(configuration);
        PriorityQueue<String> queue = new PriorityQueue<>(comparator);
        String[] currentLines = new String[readers.length];
        for (int i = 0; i < readers.length; i++) {
            String line = readers[i].readLine();
            if (line != null) {
                queue.add(line);
                currentLines[i] = line;
            }
        }

        while (!queue.isEmpty()) {

            String min = queue.poll();

            writer.write(min);
            writer.newLine();
            int minFileIndex = -1;
            for (int i = 0; i < readers.length; i++) {
                if (currentLines[i] != null && currentLines[i].equals(min)) {
                    minFileIndex = i;
                    break;
                }
            }
            currentLines[minFileIndex] = readers[minFileIndex].readLine();
            if (currentLines[minFileIndex] != null) {
                queue.add(currentLines[minFileIndex]);
            }
        }

        for (int i = 0; i < readers.length; i++) {
            readers[i].close();
        }
        writer.close();
    }

    private static Comparator<String> getComparator(Configuration configuration) {

        if (configuration.getSortingDirection() == Configuration.SortingDirection.DESC) {
            if (configuration.getReadingMode() == Configuration.ReadingMode.STRING) {
                return Comparator.reverseOrder();
            } else if (configuration.getReadingMode() == Configuration.ReadingMode.INTEGER) {
                return (o1, o2) -> {
                    final var i1 = Integer.valueOf(o1);
                    final var i2 = Integer.valueOf(o2);
                    return i2.compareTo(i1);
                };
            }
        } else {
            if (configuration.getReadingMode() == Configuration.ReadingMode.STRING) {
                return Comparator.comparing(String::valueOf);
            } else if (configuration.getReadingMode() == Configuration.ReadingMode.INTEGER) {
                return Comparator.comparing(i1 -> Integer.parseInt((String) i1));
            }
        }
        return (Comparator<String>) (s, anotherString) -> anotherString.compareTo(s);
    }

    private static FileLineReader[] getReaders(Configuration configuration) {
        FileLineReader[] readers = new FileLineReader[configuration.getInputFilesPaths().size()];
        if (configuration.getSortingDirection() == Configuration.SortingDirection.DESC) {
            for (int i = 0; i < configuration.getInputFilesPaths().size(); i++) {
                readers[i] = new ReversedLinesFileReaderAdapter(configuration.getInputFilesPaths().get(i));
            }
        }
        if (configuration.getSortingDirection() == Configuration.SortingDirection.ASC) {
            for (int i = 0; i < configuration.getInputFilesPaths().size(); i++) {
                readers[i] = new BufferedReaderAdapter(configuration.getInputFilesPaths().get(i));
            }
        }
        return readers;
    }
}
