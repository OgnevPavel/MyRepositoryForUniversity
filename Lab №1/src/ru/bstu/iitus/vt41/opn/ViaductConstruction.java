package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the viaduct construction
 * Created by KASPER on 07.02.2016.
 */
public class ViaductConstruction extends Construction {
    /** Field length*/
    private int length;

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Method returns length of viaduct construction
     * @return - field length
     */
    public int getLength() {
        return length;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    public void init(Scanner scanner) {
        System.out.println("Material, exploitationPeriod, length");
        try {
            setMaterial(scanner.next());
        } catch(InputMismatchException e){
            e.printStackTrace();
            return;
        }
        try {
            setExploitationPeriod(scanner.nextInt());
        } catch(InputMismatchException e){
            e.printStackTrace();
            return;
        }
        try {
            setLength(scanner.nextInt());
        } catch(InputMismatchException e){
            e.printStackTrace();
            return;
        };
    }

    /**
     * Method returns an instance of the class as a string
     * @return - string
     */
    @Override
    public String toString() { // возвращается состояние объекта в виде строки
        return ("Type of construction: ViaductConstruction, Material: " + getMaterial() + ", Length: " + length +
                ", Period of operation: " + getExploitationPeriod());
    }
}
