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
     * @return - field operation period
     */
    public int getExploitationPeriod() {
        return exploitationPeriod;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * Method returns material of construction
     * @return - field material
     */
    public String getMaterial() {
        return material;
    }

    public void setExploitationPeriod(int exploitationPeriod) {
        this.exploitationPeriod = exploitationPeriod;
    }

    /**
     * Enumerate of construction
     */
    public enum Constr{
        APARTMENTHOUSE,
        BRIDGE,
        BUILDING,
        COTTAGE,
        SUPERMARKET,
        TUNNEL,
        VIADUCTCONSTRUCTION;

        /**
         * Method comparison enumerated types and strings
         * @param string - comparison string
         * @return - value of an enumerated type, if equals, and null otherwise
         */
        public static Constr constrEqualsString(String string){
            Constr constr[] = Constr.values();
            for (Constr s : constr) {
                if (string.equalsIgnoreCase(s.name()))
                    return s;
            }
            return null;
        }
    }
}
