package com.aston.afspapp.util.validation;

public class InputValidator {
    public boolean isValidSizeStr(String value) {
        int size;
        try {
            size = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return size > 0;
    }

}
