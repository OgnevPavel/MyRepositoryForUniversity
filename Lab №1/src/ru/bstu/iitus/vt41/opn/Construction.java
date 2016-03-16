package ru.bstu.iitus.vt41.opn;

import java.util.Scanner;

/**
 * Class to store information about the construction
 * Created by KASPER on 07.02.2016.
 */
public abstract class Construction {
    /** Field material from which the building is constructed */
    private String material;
    /** Field operation period */
    private int exploitationPeriod;

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    public abstract void init(Scanner scanner);

    /**
     * Method returns lifetime of construction
     */
    public int getExploitationPeriod() {
        return exploitationPeriod;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * Method returns material of construction
     */
    public String getMaterial() {
        return material;
    }

    public void setExploitationPeriod(int exploitationPeriod) {
        this.exploitationPeriod = exploitationPeriod;
    }
}
