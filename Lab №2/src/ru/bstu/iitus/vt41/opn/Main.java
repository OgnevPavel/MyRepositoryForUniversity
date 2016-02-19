package ru.bstu.iitus.vt41.opn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// file name - test.txt

/**
 * Created by KASPER on 19.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * read filename (with path)
         */
        String inFilename;
        System.out.print("Enter file name: ");
        Scanner scanner = new Scanner(System.in);
        inFilename = scanner.next();
        /**
         * get file content
         */
        String fileContent = "";
        try {
            fileContent = HtmlReader.getTextFromFile(inFilename);
        } catch (Exception e) {
            System.out.println("Method trows exception: " + e.toString());
        }
        Pattern htmlPattern = Pattern.compile(HtmlReader.REGEX_HTML_READER, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = htmlPattern.matcher(fileContent);
        while (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
