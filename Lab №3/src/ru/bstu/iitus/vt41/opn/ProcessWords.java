package ru.bstu.iitus.vt41.opn;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by KASPER on 19.03.2016.
 */
class ProcessWords implements Callable {

    public Set<String> sortedSet;
    public String strContain;
    public ProcessWords(SortedSet<String> sortedSet, String strContain){
        this.sortedSet = sortedSet;
        this.strContain = strContain;
    }

    //Method leaves a word with the key phrase
    public SortedSet<String> call() {
        Supplier<SortedSet<String>> supplier = TreeSet::new;
        String strContainLowerCase = strContain.toLowerCase();
        return sortedSet.stream()
                .filter(item -> item.toLowerCase().contains(strContainLowerCase))
                .collect(Collectors.toCollection(supplier));
    }
}
