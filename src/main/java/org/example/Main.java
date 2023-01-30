package org.example;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    static final String ASCENDING_FLAG = "-a";
    static final String DESCENDING_FLAG = "-d";
    static final String STRING_FLAG = "-s";
    static final String INTEGER_FLAG = "-i";


    public static void main(String[] args) {
        
        boolean isAscending = false;
        boolean isDescending = false;
        boolean isInteger = false;
        boolean isString = false;

        List<String> inputFilesPaths;
        String outputPath = "";

        Map<Boolean, List<String>> separatedArguments = Arrays.stream(args)
                .collect(groupingBy(l -> l.startsWith("-")));

        List<String> mandatory = separatedArguments.get(Boolean.FALSE);
        List<String> optional = separatedArguments.get(Boolean.TRUE);
        outputPath = mandatory.get(0);
        inputFilesPaths = mandatory.subList(1, mandatory.size());

        isAscending = optional.contains("-a");
        isDescending = optional.contains("-d");
        isInteger = optional.contains("-i");
        isString = optional.contains("-s");

        if (isAscending && isDescending) {
            throw new IllegalArgumentException("can not have both sorting directions on the same time");
        }
        if (isInteger && isString) {
            throw new IllegalArgumentException("can not have both read modes on the same time");
        }

        Configuration.Builder builder = new Configuration.Builder();
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath(outputPath);

        if (isAscending) {
            builder.useAscendingDirection();
        } else {
            builder.useDescendingDirection();
        }

        if (isInteger) {
            builder.useIntegerReadingMode();
        } else {
            builder.useStringReadingMode();
        }

        Configuration configuration = builder.build();
        try {
            MergeSort.mergeSortFiles(configuration);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}