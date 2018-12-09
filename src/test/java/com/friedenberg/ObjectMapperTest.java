package com.friedenberg;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ObjectMapperTest {
    private int intField = 25;
    private String stringField = "Field";
    private Date date = Date.from(Instant.now());

    @Test
    public void shouldReturnDefaultValuesForFailedMapping() throws Exception{
        Map<String, Object> inputs = new HashMap<>(0);

        MyTestPojo expected = new MyTestPojo();

        MyTestPojo res = ObjectMapper.map(inputs, MyTestPojo.class);

        assertEquals(expected, res);
    }

    @Test
    public void shouldIgnoreInvalidFieldName() throws Exception {
        Map<String, Object> inputs = new HashMap<>(1);
        inputs.put("invalidField", 1);

        MyTestPojo expected = new MyTestPojo();

        MyTestPojo res = ObjectMapper.map(inputs, MyTestPojo.class);

        assertEquals(expected, res);
    }

    @Test
    public void shouldMapMatchingFields() throws Exception {
        Map<String, Object> inputs = new HashMap<>(3);
        inputs.put("field1", this.intField);
        inputs.put("field2", this.stringField);
        inputs.put("field3", this.date);
        inputs.put("field4", true);

        MyTestPojo expected = new MyTestPojo();
        expected.setField1(this.intField);
        expected.setField2(this.stringField);
        expected.setField3(this.date);
        expected.setField4(true);

        MyTestPojo res = ObjectMapper.map(inputs, MyTestPojo.class);

        assertEquals(expected, res);
    }

    @Test(expected = ObjectMappingException.class)
    public void shouldThrowForInvalidPojoSetter() throws Exception {
        Map<String, Object> inputs = new HashMap<>(2);
        inputs.put("field1", this.intField);
        inputs.put("field2", this.stringField);

        ObjectMapper.map(inputs, InvalidTestPojo.class);
    }
}
