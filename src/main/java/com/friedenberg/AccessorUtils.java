package com.friedenberg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Utility functions to work with Field accessors
 * @author Evan Friedenberg
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class AccessorUtils {

    /**
     * Return the setter for a given field in a class
     *
     * @param field field to retrieve setter for
     * @param clazz Class to look for setter in
     * @return {@link java.lang.reflect.Method Method} that is the accessor for field
     * @throws NoSuchMethodException if there is no valid setter for Field
     */
    public static Method getAccessor(Field field, Class<?> clazz) throws NoSuchMethodException {
        String expectedSetterName = getSetterName(field);
        Method setter = clazz.getMethod(expectedSetterName, field.getType());
        if (!isValidSetter(setter)) {
            String errorMsg = String.format("No matching setter for %s. Expected %s().",
                    field.getName(),
                    expectedSetterName);
            throw new NoSuchMethodException(errorMsg);
        }
        return setter;
    }

    private static String getSetterName(Field field) {
        Class<?> type = field.getType();
        String fieldName = field.getName();
        if (type.isAssignableFrom(Boolean.class)) {
            String prefix = "is";
            return fieldName.substring(fieldName.indexOf(prefix) + prefix.length()) + StringUtils.capitalizeWord(fieldName);
        } else {
            return "set" + StringUtils.capitalizeWord(fieldName);
        }
    }

    private static boolean isValidSetter(Method method) {
        return method.getParameterCount() == 1
                && method.getName().startsWith("set")
                && method.getReturnType() == void.class;
    }
}
