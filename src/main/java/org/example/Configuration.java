package org.example;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

    private final String outputFilePath;
    private final List<String> inputFilesPaths;
    private final SortingDirection sortingDirection;
    private final ReadingMode readingMode;


    private Configuration(String outputFilePath, List<String>  inputFilesPaths, SortingDirection sortingDirection, ReadingMode readingMode) {
        this.outputFilePath = outputFilePath;
        this.inputFilesPaths = inputFilesPaths;
        this.sortingDirection = sortingDirection;
        this.readingMode = readingMode;
    }

    public List<String> getInputFilesPaths() {
        return inputFilesPaths;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public static class Builder {

        private String outputFilePath;
        private List<String> inputFilesPaths;

        private SortingDirection sortingDirection;
        private ReadingMode readingMode;
        private  ArrayList<String> filesPaths;


        public Configuration build () {
            return new Configuration(this.outputFilePath, this.inputFilesPaths, this.sortingDirection, this.readingMode);
        }
        public Builder useAscendingDirection () {
            this.sortingDirection = SortingDirection.ASC;
            return this;
        }
        public Builder useDescendingDirection () {
            this.sortingDirection = SortingDirection.DESC;
            return this;
        }
        public Builder useIntegerReadingMode () {
            this.readingMode = ReadingMode.INTEGER;
            return this;
        }

        public Builder useStringReadingMode () {
            this.readingMode = ReadingMode.STRING;
            return this;

        }

        public Builder setInputPaths(List<String> inputFilePaths) {
            this.inputFilesPaths = inputFilePaths;
            return this;
        }

        public Builder setOutputPath (String outputFilePath) {
            this.outputFilePath = outputFilePath;
            return this;
        }

    }

    public enum SortingDirection {
        ASC, DESC

    }
    public enum ReadingMode {
        INTEGER, STRING

    }

    public SortingDirection getSortingDirection() {
        return sortingDirection;
    }

    public ReadingMode getReadingMode() {
        return readingMode;
    }
}
