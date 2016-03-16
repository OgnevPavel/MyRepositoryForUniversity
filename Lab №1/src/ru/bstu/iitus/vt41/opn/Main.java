package ru.bstu.iitus.vt41.opn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ru.bstu.iitus.vt41.opn.ConstrType.*;

/**
 * Created by KASPER on 07.02.2016.
 */
public class Main {
    public static void main(String[] args) throws CountConstructionExeption, BuildConstructionException {
        /** Count Of Construction */
        int countOfConstruction = 0;
        /** Array Of Construction */
        ArrayList<Construction> arrayOfConstruction = new ArrayList<>();
        System.out.println("Enter the number of buildings");
        Scanner scanner = new Scanner(System.in);
        countOfConstruction = getCountOfConstruction(scanner);
        for (int i = 0; i < countOfConstruction; i++) {
            System.out.println("Enter the type of construction");
            try {
                arrayOfConstruction.add(buildConstructions(scanner));
            } catch (IllegalConstructionNameException |
                    InputMismatchException |
                    InstantiationException |
                    IllegalAccessException e) {
                throw new BuildConstructionException(e.getMessage());
            }
        }
        scanner.close();
        if (arrayOfConstruction.size() > 0) {
            getConstructionWithMinPeriod(arrayOfConstruction);
        }
    }

    private static int getCountOfConstruction(Scanner scanner) throws CountConstructionExeption {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            e.getMessage();
            throw new CountConstructionExeption();
        }
    }

    private static Construction buildConstructions(Scanner scanner) throws IllegalConstructionNameException,
            IllegalAccessException, InstantiationException, BuildConstructionException {
        ConstrType type = valueOf(scanner.next());
        if (type == null) {
            throw new IllegalConstructionNameException();
        }
        Construction construction = type.getInstance();
        if (construction == null) {
            throw new BuildConstructionException();
        }
        construction.init(scanner);
        return construction;
    }

    private static void getConstructionWithMinPeriod(ArrayList<Construction> arrayOfConstruction) {
        Construction lowestPeriod = arrayOfConstruction.get(0);
        try {
            for (Construction construction : arrayOfConstruction) {
                if (lowestPeriod.getExploitationPeriod() > construction.getExploitationPeriod()) {
                    lowestPeriod = construction;
                }
            }
            System.out.println("Information about the building with the lowest period of operation:\n" + lowestPeriod.toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
