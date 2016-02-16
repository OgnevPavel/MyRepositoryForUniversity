package ru.bstu.iitus.vt41.opn;

import java.util.Scanner;

/**
 * Class to store information about the tunnel
 * Created by KASPER on 07.02.2016.
 */
public class Tunnel extends ViaductConstruction {
    /** Field depth */
    private int depth;

    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Method returns depth of tunnel
     * @return - field depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Method reads the parameters from the console
     * @param scanner - for read
     */
    @Override
    public void init(Scanner scanner) {
        String aMaterial;
        int aNumberOfFloors, aExploitationPeriod, aDepth;
        System.out.println("Material, ExploitationPeriod, length, Depth");
        super.init(scanner);
        if (scanner.hasNextInt()){
            setDepth(scanner.nextInt());
        }
        else return;
    }

    /**
     * Method returns an instance of the class as a string
     * @return - string
     */
    @Override
    public String toString() {
        return ("Type of construction: Tunnel, Material: " + getMaterial() + ", Length: " + getLength() + ", Period of operation:: "
                + getExploitationPeriod() + ", Depth: " + getDepth());
    }
}
