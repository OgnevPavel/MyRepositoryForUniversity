package ru.bstu.iitus.vt41.opn;

import com.sun.istack.internal.NotNull;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

import static com.sun.deploy.util.StringUtils.*;
import static java.util.Arrays.asList;

/**
 * Created by KASPER on 19.03.2016.
 */
class ProcessFile implements Callable<SortedSet<String>> {

    public static Charset ENCODING = StandardCharsets.UTF_8;

    public List<String> fileContent;

    public ProcessFile(@NotNull List<String> fileContent) {
        this.fileContent = fileContent;
    }

    //Reads a text file and builds a string of its content. Returns sorted set of string contents.
    public SortedSet<String> call() {
        SortedSet<String> result = new TreeSet<>();
        fileContent.stream().map(line -> result.addAll(asList(splitString(line, " "))));
        return result;
    }
}
