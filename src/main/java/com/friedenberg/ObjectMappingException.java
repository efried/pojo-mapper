package com.friedenberg;

/**
 * Generic exception to throw from {@link com.friedenberg.ObjectMapper ObjectMapper} mapping functions
 * @author Evan Friedenberg
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ObjectMappingException extends Exception {
    public ObjectMappingException(Throwable cause) {
        super(cause);
    }

    public ObjectMappingException(String message) {
        super(message);
    }

    public ObjectMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
