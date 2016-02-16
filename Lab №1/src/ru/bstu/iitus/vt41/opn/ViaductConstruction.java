package ru.bstu.iitus.vt41.opn;

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
        if (scanner.hasNext()) {
            setMaterial(scanner.next());
        }
        else return;
        if (scanner.hasNextInt()) {
            setExploitationPeriod(scanner.nextInt());
        }
        else return;
        if (scanner.hasNextInt()) {
            setLength(scanner.nextInt());
        }
        else return;
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
