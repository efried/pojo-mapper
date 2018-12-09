package com.friedenberg;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Methods to map various objects to destination POJOs
 * @author Evan Friedenberg
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class ObjectMapper {

    /**
     * Returns an object T with all matching String values found as a key in inputs.
     * <br><br>
     * Any values not found in the map will default to Java defaults: null, 0, false, etc.
     *
     * @param inputs Map of field names as String to desired field values
     * @param destinationType POJO to map inputs for
     * @return Object of type destinationType with matching values set
     * @throws ObjectMappingException if a setter cannot be found for a field or if there are problems accessing
     * methods on the object.
     */
    public static <T> T map(Map<String, Object> inputs, Class<T> destinationType) throws ObjectMappingException {
        T result;
        try {
            result = destinationType.newInstance();
            Field[] fields = result.getClass().getDeclaredFields();

            for (Field destField : fields) {
                for (Map.Entry<String, Object> inputEntry : inputs.entrySet()) {
                    if (inputEntry.getKey().equals(destField.getName())) {
                        try {
                            Method setter = AccessorUtils.getAccessor(destField, destinationType);
                            setter.invoke(result, inputEntry.getValue());
                        } catch (NoSuchMethodException nsme) {
                            throw new ObjectMappingException(nsme);
                        } catch (InvocationTargetException ite) {
                            String errorMsg = "Setter should not throw an exception";
                            throw new ObjectMappingException(errorMsg, ite);
                        }
                        break;
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ObjectMappingException(e);
        }

        return result;
    }

}
