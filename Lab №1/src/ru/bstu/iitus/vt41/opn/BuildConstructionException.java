package ru.bstu.iitus.vt41.opn;

/**
 * Created by KASPER on 16.03.2016.
 */
public class BuildConstructionException extends Exception {

    public BuildConstructionException() {
        super("Ошибка создания персоны");
    }

    public BuildConstructionException(String message) {
        super(message);
    }
}
