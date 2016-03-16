package ru.bstu.iitus.vt41.opn;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to store information about the apartment house
 * Created by KASPER on 07.02.2016.
 */
public class ApartmentHouse extends Building{
    /** Field count of apartment */
    public int numberOfApartment;

    public void setNumberOfApartment(int numberOfApartment) {
        this.numberOfApartment = numberOfApartment;
    }

    /**
     * Method returns number of apartment
     */
    public int getNumberOfApartment() {
        return numberOfApartment;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    @Override
    public void init(Scanner scanner) {
        System.out.println("Material, ExploitationPeriod, NumberOfFloors, NumberOfApartment");
        super.init(scanner);
        try{
            setNumberOfApartment(scanner.nextInt());
        } catch(InputMismatchException e){
            e.getMessage();
        }
    }

    /**
     * Method returns an instance of the class as a string
     */
    @Override
    public String toString() {
        return ("Type of construction: ApartmentHouse, Material: " + getMaterial() + ", Number of floors: " + getNumberOfFloors() +
                ", Period of operation: " + getExploitationPeriod() + ", Number of apartments: " + getNumberOfApartment());
    }
}
