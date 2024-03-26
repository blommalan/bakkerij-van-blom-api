package com.bakkerij_van_blom.exceptions;

public class CannotSaveOrderException extends RuntimeException {
    public CannotSaveOrderException(String message) {
        super("Cannot save order: " + message);
    }
}
