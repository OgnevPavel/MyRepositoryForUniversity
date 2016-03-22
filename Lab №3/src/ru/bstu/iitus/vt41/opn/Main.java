package ru.bstu.iitus.vt41.opn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by KASPER on 18.03.2016.
 */
public class Main {
    // file name - test.txt
    public static void main(String[] args) {
        try {
            String inFilename = readString("Enter file name: ");
            String subString = readString("Enter sub string: ");

            ProcessFile readFile = new ProcessFile(readFileLines(inFilename));
            FutureTask<SortedSet<String>> task = buildFutureTask(readFile);
            SortedSet<String> setWord = task.get();
            GetContains getContain = new GetContains(setWord, subString);
            FutureTask<SortedSet<String>> task2 = buildFutureTask(getContain);
            SortedSet<String> setWordWithSubString = task2.get();

            SetOutput task3 = new SetOutput(setWordWithSubString);
            task3.start();

            //SortedSet<String> setWord = getTextFromFile(inFilename);
            //SortedSet<String> setWordWithSubString = getContains(setWord, subString);
            //setOutput(setWordWithSubString);
        } catch (Exception e) {
            System.out.println("Method trows exception: " + e.toString());
        }
    }

    private static FutureTask<SortedSet<String>> buildFutureTask(Callable<SortedSet<String>> readFile) throws InterruptedException {
        FutureTask<SortedSet<String>> task = new FutureTask<>(readFile);
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        return task;
    }

    private static List<String> readFileLines(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

    //public static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Reads a text file and builds a string of its content. Returns sorted set of string contents.
     *
     * @param fileName - filename to read from. Must be a UTF-8 coded text file.
     * @return - entire text file as sorted set of string
     * @throws - IOException
     */
    /*public static SortedSet<String> getTextFromFile(@NotNull String fileName) throws IOException {
        Path path = Paths.get(fileName);
        SortedSet<String> result = new TreeSet<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    result.add(st.nextToken());
                }
            }
        }
        return result;
    }*/

    /**
     * Reads string from console
     */
    private static String readString(String enteredStr) {
        String inString;
        System.out.print(enteredStr);
        Scanner scanner = new Scanner(System.in);
        inString = scanner.next();
        return inString;
    }

    /**
     * Method leaves a word with the key phrase
     */
    /*public static SortedSet<String> getContains(SortedSet<String> sortedSet, String strContain) {
        String strContainLowerCase = strContain.toLowerCase();
        SortedSet<String> result = new TreeSet<String>();
        Iterator<String> iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.toLowerCase().contains(strContain)) {
                result.add(item);
            }
        }
        return result;
    }*/

    /**
     * Method displays the elements of the console
     */
    /*private static void setOutput(SortedSet<String> sortedSet) {
        Iterator<String> iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }*/
}
