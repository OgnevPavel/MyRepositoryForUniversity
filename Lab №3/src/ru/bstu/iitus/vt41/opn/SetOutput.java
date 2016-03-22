package ru.bstu.iitus.vt41.opn;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.function.Function;

/**
 * Created by KASPER on 19.03.2016.
 */
public class SetOutput extends Thread {

    public SortedSet<String> sortedSet;

    public SetOutput(SortedSet<String> sortedSet) {
        this.sortedSet = sortedSet;
    }

    //Method displays the elements of the console
    @Override
    public void run() {
        sortedSet.forEach(System.out::println);
    }
}
