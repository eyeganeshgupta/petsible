package com.petsible.exception;

import java.io.Serial;

/**
 * Exception for pet not found.
 *
 * @author Ganesh Gupta
 */
public class PetNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public PetNotFoundException(String message) {
        super(message);
    }
}
