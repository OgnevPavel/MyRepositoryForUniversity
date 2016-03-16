package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the supermarket
 * Created by KASPER on 07.02.2016.
 */
public class Supermarket extends Building {
    /** Field supermarket title */
    private String titleOfSupermarket; //название супермаркета

    public void setTitleOfSupermarket(String titleOfSupermarket) {
        this.titleOfSupermarket = titleOfSupermarket;
    }

    /**
     * Method returns title of supermarket
     * @return - field title of supermarket
     */
    public String getTitleOfSupermarket() {
        return titleOfSupermarket;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    @Override
    public void init(Scanner scanner) {
        super.init(scanner);
        System.out.println("TitleOfSupermarket");
        try{
            setTitleOfSupermarket(scanner.next());
        } catch(InputMismatchException e){
            e.getMessage();
        }
    }

    /**
     * Method returns an instance of the class as a string
     */
    @Override
    public String toString() {
        return ("Type of construction: Supermarket, Material: " + getMaterial() + ", Number of floors: " + getNumberOfFloors()
                + ", Period of operation: " + getExploitationPeriod() + ", Title of supermarket: " + getTitleOfSupermarket());
    }
}
