package ru.bstu.iitus.vt41.opn;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        try {
            countOfConstruction = scanner.nextInt();
        } catch(InputMismatchException e){
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < countOfConstruction; i++) {
            System.out.println("Enter the type of construction");
            try {
                Construction build = null;
                Construction.Constr constr = Construction.Constr.constrEqualsString(scanner.next());
                if (constr == null){
                    throw new IllegalNameOfConstructionException();
                }
                switch (constr) {
                    case BUILDING: {
                        build = new Building();
                        break;
                    }
                    case COTTAGE: {
                        build = new Cottage();
                        break;
                    }
                    case SUPERMARKET: {
                        build = new Supermarket();
                        break;
                    }
                    case APARTMENTHOUSE: {
                        build = new ApartmentHouse();
                        break;
                    }
                    case VIADUCTCONSTRUCTION: {
                        build = new ViaductConstruction();
                        break;
                    }
                    case BRIDGE: {
                        build = new Bridge();
                        break;
                    }
                    case TUNNEL: {
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
            } catch(InputMismatchException e) {
                e.printStackTrace();
                return;
            } catch(IllegalNameOfConstructionException e){
                System.out.println(e.getMessageError());
                return;
            }
        }
        scanner.close();
        Construction lowestPeriod = null;
        try {
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
        } catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
}
