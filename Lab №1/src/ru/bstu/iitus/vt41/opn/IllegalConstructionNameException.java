package ru.bstu.iitus.vt41.opn;

/**
 * Created by KASPER on 16.03.2016.
 */
public class IllegalConstructionNameException extends Exception {
    private String messageError = "Данная конструкция не обнаружена";

    @Override
    public String getMessage() {
        return messageError;
    }
}
