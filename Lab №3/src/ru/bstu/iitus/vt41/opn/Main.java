package ru.bstu.iitus.vt41.opn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
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
            FutureTask<SortedSet<String>> processFile = buildFutureTask(readFile);
            SortedSet<String> setWord = processFile.get();

            ProcessWords processWords = new ProcessWords(setWord, subString);
            FutureTask<SortedSet<String>> getContains = buildFutureTask(processWords);
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

    private static List<String> readFileLines(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

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
}
