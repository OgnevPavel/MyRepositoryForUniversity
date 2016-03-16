package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the cottage
 * Created by KASPER on 07.02.2016.
 */
public class Cottage extends Building {
    /** Field land area */
    private Double landArea;

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    /**
     * Method returns land area
     * @return - field land area
     */
    public Double getLandArea() {
        return landArea;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    @Override
    public void init(Scanner scanner) {
        Double aLandArea = 0.0;
        System.out.println("Material, ExploitationPeriod, NumberOfFloors, LandArea");
        super.init(scanner);
        try {
            String str = scanner.next();
            aLandArea = Double.parseDouble(str);
            setLandArea(aLandArea);
        } catch(InputMismatchException | NumberFormatException e){
            e.getMessage();
        }
    }

    /**
     * Method returns an instance of the class as a string
     * @return - string
     */
    @Override
    public String toString() {
        return ("Type of construction: Cottage, Material: " + getMaterial() + ", Number of floors: " + getNumberOfFloors() +
                ", Period of operation: " + getExploitationPeriod() + ", Land area: " + getLandArea());
    }
}
