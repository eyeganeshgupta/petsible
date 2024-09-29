package com.petsible.exception;

import java.io.Serial;

/**
 * Exception for owner not found.
 *
 * @author Ganesh Gupta
 */
public class OwnerNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
