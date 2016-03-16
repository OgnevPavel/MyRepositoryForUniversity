package ru.bstu.iitus.vt41.opn;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KASPER on 19.02.2016.
 */
public class HtmlReader {
    public static Charset ENCODING = StandardCharsets.UTF_8;
    public static String REGEX_HTML_READER = "<(span|div)(.*?)>.+</(span|div)>";
    /**
     * Reads a text file and builds a string of its content. Returns single-string contents.
     *
     * @param fileName - filename to read from. Must be a UTF-8 coded text file.
     * @return - entire text file as list of string
     * @throws - IOException
     */
    public static List<String> getTextFromFile(@NotNull String fileName) throws IOException {
        Path path = Paths.get(fileName);
        StringBuilder sBuild = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sBuild.append(line).append(System.lineSeparator());
            }
        }
        Pattern htmlPattern = Pattern.compile(HtmlReader.REGEX_HTML_READER, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = htmlPattern.matcher(sBuild);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group(2));
        }
        return result;
    }
}
