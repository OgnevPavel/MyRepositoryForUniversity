package ru.bstu.iitus.vt41.opn;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/**
 * Created by KASPER on 19.03.2016.
 */
class GetContains implements Callable {

    public SortedSet<String> sortedSet;
    public String strContain;
    public GetContains(SortedSet<String> sortedSet, String strContain){
        this.sortedSet = sortedSet;
        this.strContain = strContain;
    }

    //Method leaves a word with the key phrase
    public SortedSet<String> call() {
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
    }
}
