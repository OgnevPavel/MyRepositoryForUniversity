package ru.bstu.iitus.vt41.opn;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/**
 * Created by KASPER on 19.03.2016.
 */
class ReadFile implements Callable {

    public static Charset ENCODING = StandardCharsets.UTF_8;

    public String fileName;
    public ReadFile(@NotNull String fileName) {
        this.fileName = fileName;
    }

    //Reads a text file and builds a string of its content. Returns sorted set of string contents.
    public SortedSet<String> call() {
        SortedSet<String> result = new TreeSet<String>();
        try{
            Path path = Paths.get(fileName);
            try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line);
                    while (st.hasMoreTokens()) {
                        result.add(st.nextToken());
                    }
                }
            }
        } catch (IOException e){
            System.out.println("Method trows exception: " + e.toString());
        }
        return result;
    }
}
