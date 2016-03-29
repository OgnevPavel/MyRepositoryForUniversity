package ru.bstu.iitus.vt41.opn;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.deploy.util.StringUtils.splitString;
import static java.nio.file.Files.readAllLines;
import static java.util.Arrays.asList;

/**
 * Created by KASPER on 18.03.2016.
 */
public class Main {
    // file name - test.txt
    public static void main(String[] args) {
        try {
            String inFilename = readString("Enter file name: ");
            String subString = readString("Enter sub string: ");

            ProcessFile readFile = new ProcessFile(readAllLines(Paths.get(inFilename)));
            FutureTask<SortedSet<String>> processFile = buildFutureTask(readFile);
            SortedSet<String> setWord = processFile.get();

            GetContains getContain = new GetContains(setWord, subString);
            FutureTask<SortedSet<String>> getContains = buildFutureTask(getContain);
            SortedSet<String> setWordWithSubString = getContains.get();

            SetOutput setOutput = new SetOutput(setWordWithSubString);
            setOutput.start();
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

    /**
     * Reads a text file and builds a string of its content. Returns sorted set of string contents.
     *
     * @param fileContent - filename to read from. Must be a UTF-8 coded text file.
     * @return - entire text file as sorted set of string
     * @throws - IOException
     */
    /*public static SortedSet<String> getTextFromFile(List<String> fileContent) {
        SortedSet<String> result = new TreeSet<>();

        //Эта строка нихера не робит!!!
        //fileContent.stream().map(line -> result.addAll(asList(splitString(line, " "))));

        Object[] objArr = fileContent.stream().map(line -> line.split(" ")).toArray();
        String[][] stringArray = Arrays.copyOf(objArr, objArr.length, String[][].class);
        for (String[] item : stringArray) {
            result.addAll(asList(item));
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
        Supplier<SortedSet<String>> supplier = TreeSet::new;
        String strContainLowerCase = strContain.toLowerCase();
        return sortedSet.stream()
                .filter(item -> item.toLowerCase().contains(strContainLowerCase))
                .collect(Collectors.toCollection(supplier));
    }*/

    /**
     * Method displays the elements of the console
     */
    /*private static void setOutput(SortedSet<String> sortedSet) {
        sortedSet.forEach(System.out::println);
    }*/
}
