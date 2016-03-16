package ru.bstu.iitus.vt41.opn;

/**
 * Created by KASPER on 17.02.2016.
 * Self-made class error
 */
public class IllegalNameOfConstructionException extends Exception {
    /**
     * Field message about error
     */
    private String messageError = "Warning! This type of construction not found!";

    public IllegalNameOfConstructionException() {
    }
    /**
     * Method returns message about error
     */
    @Override
    public String getMessage() {
        return messageError;
    }
}
