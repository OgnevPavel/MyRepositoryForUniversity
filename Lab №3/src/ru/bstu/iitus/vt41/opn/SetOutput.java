package ru.bstu.iitus.vt41.opn;

import java.util.Iterator;
import java.util.SortedSet;

/**
 * Created by KASPER on 19.03.2016.
 */
public class SetOutput extends Thread{

    public SortedSet<String> sortedSet;
    public SetOutput(SortedSet<String> sortedSet){
        this.sortedSet = sortedSet;
    }

    //Method displays the elements of the console
    @Override
    public void run(){
        Iterator<String> iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}
