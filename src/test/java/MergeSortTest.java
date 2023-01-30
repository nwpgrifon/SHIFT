import org.example.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.MergeSort.mergeSortFiles;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MergeSortTest {
    @Test
    void sortIntegersInAscendingOrder() throws IOException {
        Configuration.Builder builder = new Configuration.Builder();
        List<String> inputFilesPaths = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        String file1 = new File(classLoader.getResource("file1int.txt").getFile()).getAbsolutePath();
        String file2 = new File(classLoader.getResource("file2int.txt").getFile()).getAbsolutePath();
        String file3 = new File(classLoader.getResource("file3int.txt").getFile()).getAbsolutePath();
        inputFilesPaths.add(file1);
        inputFilesPaths.add(file2);
        inputFilesPaths.add(file3);
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath("out");
        builder.useAscendingDirection();
        builder.useIntegerReadingMode();
        Configuration configuration = builder.build();
        mergeSortFiles(configuration);
        FileReader fr= new FileReader("out");
        Scanner scan = new Scanner(fr);
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        List<String> expectedList = List.of("1", "2", "3", "5", "28", "30", "150", "151", "152");
        assertEquals(expectedList, list);
        scan.close();
    }

    @Test
    void sortIntegersInDescendingOrder() throws IOException {
        Configuration.Builder builder = new Configuration.Builder();
        List<String> inputFilesPaths = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        String file1 = new File(classLoader.getResource("file1int.txt").getFile()).getAbsolutePath();
        String file2 = new File(classLoader.getResource("file2int.txt").getFile()).getAbsolutePath();
        String file3 = new File(classLoader.getResource("file3int.txt").getFile()).getAbsolutePath();
        inputFilesPaths.add(file1);
        inputFilesPaths.add(file2);
        inputFilesPaths.add(file3);
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath("out");
        builder.useDescendingDirection();
        builder.useIntegerReadingMode();
        Configuration configuration = builder.build();
        mergeSortFiles(configuration);
        FileReader fr= new FileReader("out");
        Scanner scan = new Scanner(fr);
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        List<String> expectedList = List.of("152", "151", "150", "30", "28", "5", "3", "2", "1");
        assertEquals(expectedList, list);
        scan.close();
    }

    @Test
    void sortStringsInDescendingOrder() throws IOException {
        Configuration.Builder builder = new Configuration.Builder();
        List<String> inputFilesPaths = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        String file1 = new File(classLoader.getResource("file1.txt").getFile()).getAbsolutePath();
        String file2 = new File(classLoader.getResource("file2.txt").getFile()).getAbsolutePath();
        String file3 = new File(classLoader.getResource("file3.txt").getFile()).getAbsolutePath();
        inputFilesPaths.add(file1);
        inputFilesPaths.add(file2);
        inputFilesPaths.add(file3);
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath("out");
        builder.useDescendingDirection();
        builder.useStringReadingMode();
        Configuration configuration = builder.build();
        mergeSortFiles(configuration);
        FileReader fr= new FileReader("out");
        Scanner scan = new Scanner(fr);
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        List<String> expectedList = List.of("5", "30", "3", "28", "2", "152", "151", "150", "1");
        assertEquals(expectedList, list);
        scan.close();
    }
    @Test
    void sortStringsInAscendingOrder() throws IOException {
        Configuration.Builder builder = new Configuration.Builder();
        List<String> inputFilesPaths = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        String file1 = new File(classLoader.getResource("file1.txt").getFile()).getAbsolutePath();
        String file2 = new File(classLoader.getResource("file2.txt").getFile()).getAbsolutePath();
        String file3 = new File(classLoader.getResource("file3.txt").getFile()).getAbsolutePath();
        inputFilesPaths.add(file1);
        inputFilesPaths.add(file2);
        inputFilesPaths.add(file3);
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath("out");
        builder.useAscendingDirection();
        builder.useStringReadingMode();
        Configuration configuration = builder.build();
        mergeSortFiles(configuration);
        FileReader fr= new FileReader("out");
        Scanner scan = new Scanner(fr);
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        List<String> expectedList = List.of("1", "150", "151", "152", "2", "28", "3", "30", "5");
        assertEquals(expectedList, list);
        scan.close();
    }


    @Test
    @Disabled
    void sortStringsInDescendingOrderWithUnsortedInputs() throws IOException {
        Configuration.Builder builder = new Configuration.Builder();
        List<String> inputFilesPaths = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        String file1 = new File(classLoader.getResource("file1unsortstr.txt").getFile()).getAbsolutePath();
        String file2 = new File(classLoader.getResource("file2unsortstr.txt").getFile()).getAbsolutePath();
        String file3 = new File(classLoader.getResource("file3unsortstr.txt").getFile()).getAbsolutePath();
        inputFilesPaths.add(file1);
        inputFilesPaths.add(file2);
        inputFilesPaths.add(file3);
        builder.setInputPaths(inputFilesPaths);
        builder.setOutputPath("out");
        builder.useDescendingDirection();
        builder.useStringReadingMode();
        Configuration configuration = builder.build();
        mergeSortFiles(configuration);
        FileReader fr= new FileReader("out");
        Scanner scan = new Scanner(fr);
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()) {
            list.add(scan.nextLine());
        }
        List<String> expectedList = List.of("30", "3", "28", "2", "152", "151", "150", "1");
        assertEquals(expectedList, list);
        scan.close();
    }
}
