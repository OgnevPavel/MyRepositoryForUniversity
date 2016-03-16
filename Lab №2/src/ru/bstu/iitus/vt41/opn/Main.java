package ru.bstu.iitus.vt41.opn;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// file name - test.txt

/**
 * Created by KASPER on 19.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        String inFilename = readFileName();
        List<String> attributes;
        try {
            attributes = HtmlReader.getTextFromFile(inFilename);
            for (String attribute: attributes) {
                System.out.println(attribute);
            }
        } catch (Exception e) {
            System.out.println("Method trows exception: " + e.toString());
        }
    }

    private static String readFileName() {
        String inFilename;
        System.out.print("Enter file name: ");
        Scanner scanner = new Scanner(System.in);
        inFilename = scanner.next();
        return inFilename;
    }
}
