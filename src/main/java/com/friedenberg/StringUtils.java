package com.friedenberg;

/**
 * Utility functions to work with {@link java.lang.String String}
 * @author Evan Friedenberg
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class StringUtils {
    public static String capitalizeWord(String in) {
        char firstChar = in.charAt(0);
        return in.replace(firstChar, Character.toUpperCase(firstChar));
    }
}
