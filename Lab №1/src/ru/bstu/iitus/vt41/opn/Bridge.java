package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the bridge
 * Created by KASPER on 07.02.2016.
 */
public class Bridge extends ViaductConstruction {
    /** Field count of poles */
    private int numberOfPoles;

    public void setNumberOfPoles(int numberOfPoles) {
        this.numberOfPoles = numberOfPoles;
    }

    /**
     * Method returns count of poles
     */
    public int getNumberOfPoles() {
        return numberOfPoles;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    @Override
    public void init(Scanner scanner) {
        super.init(scanner);
        System.out.println("NumberOfPoles");
        try{
            setNumberOfPoles(scanner.nextInt());
        } catch(InputMismatchException e){
            e.getMessage();
        }
    }

    /**
     * Method returns an instance of the class as a string
     */
    @Override
    public String toString() { // возвращается состояние объекта в виде строки
        return ("Type of construction: Bridge, Material: " + getMaterial() + ", Length: " + getLength() + ", Period of operation: "
                + getExploitationPeriod() + ", Number of poles: " + getNumberOfPoles());
    }
}
