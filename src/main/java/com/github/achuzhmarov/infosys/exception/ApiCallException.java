package com.github.achuzhmarov.infosys.exception;

/**
 * Application exception for API calls.
 */
public class ApiCallException extends ApplicationException {
    private String response;

    public ApiCallException(String message) {
        super(message);
    }

    public ApiCallException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiCallException(String message, String response, Throwable cause) {
        super(message + ", response: " + response, cause);
        this.response = response;
    }
}