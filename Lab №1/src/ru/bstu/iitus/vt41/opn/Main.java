package ru.bstu.iitus.vt41.opn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by KASPER on 07.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        /** Count Of Construction */
        int countOfConstruction = 0;
        /** Array Of Construction */
        ArrayList<Construction> arrayOfConstruction = new ArrayList<>();
        System.out.println("Enter the number of buildings");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            countOfConstruction = scanner.nextInt();
        }
        else {
            scanner.close();
            System.out.println("You have not entered the number of facilities");
            return;
        }
        for (int i = 0; i < countOfConstruction; i++) {
            System.out.println("Enter the type of construction");
            if (scanner.hasNext()) {
                Construction build = null;
                switch (scanner.next()) {
                    case ("Building"): {
                        build = new Building();
                        break;
                    }
                    case ("Cottage"): {
                        build = new Cottage();
                        break;
                    }
                    case ("Supermarket"): {
                        build = new Supermarket();
                        break;
                    }
                    case ("ApartmentHouse"): {
                        build = new ApartmentHouse();
                        break;
                    }
                    case ("ViaductConstruction"): {
                        build = new ViaductConstruction();
                        break;
                    }
                    case ("Bridge"): {
                        build = new Bridge();
                        break;
                    }
                    case ("Tunnel"): {
                        build = new Tunnel();
                        break;
                    }
                    default: {
                        System.out.println("Such structures do not have");
                        break;
                    }
                }
                if (build != null) {
                    build.init(scanner);
                    arrayOfConstruction.add(build);
                }
            }
        }
        scanner.close();
        Construction lowestPeriod = null;
        for (Construction construction: arrayOfConstruction){
            if (lowestPeriod == null){
                lowestPeriod = construction;
            }
            else {
                if (lowestPeriod.getExploitationPeriod() > construction.getExploitationPeriod()){
                    lowestPeriod = construction;
                }
            }
        }
        System.out.println("Information about the building with the lowest period of operation:\n" + lowestPeriod.toString());
    }
}
