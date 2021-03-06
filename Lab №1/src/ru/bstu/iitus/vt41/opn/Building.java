package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the building
 * Created by KASPER on 07.02.2016.
 */
public class Building extends Construction {
    /**
     * Field count of floors
     */
    private int numberOfFloors;

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    /**
     * Method returns number of floors
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    public void init(Scanner scanner) {
        System.out.println("Material, exploitationPeriod, numberOfFloors");
        try {
            setMaterial(scanner.next());
            setExploitationPeriod(scanner.nextInt());
            setNumberOfFloors(scanner.nextInt());
        } catch(InputMismatchException e){
            e.getMessage();
        }
    }

    /**
     * Method returns an instance of the class as a string
     */
    @Override
    public String toString() {
        return ("Type of construction: Building, Material: " + getMaterial() + ", Number of floors: " + getNumberOfFloors() +
                ", Period of operation: " + getExploitationPeriod());
    }
}
