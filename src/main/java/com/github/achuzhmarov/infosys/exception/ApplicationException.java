package com.github.achuzhmarov.infosys.exception;

/**
 * Root application exception. Any other application exceptions should extend this one.
 */
public abstract class ApplicationException extends RuntimeException {
    ApplicationException(String message) {
        super(message);
    }

    ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
