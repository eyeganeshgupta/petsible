package com.petsible.exception;

import java.io.Serial;

/**
 * Exception for duplicate owner ID.
 *
 * @author Ganesh Gupta
 */
public class DuplicateOwnerIdException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateOwnerIdException(String message) {
        super(message);
    }
}
