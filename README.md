# POJO mapping made easy

#### Example Usage
```
public static void main(String[] args) {
    Map<String, Object> properties = new HashMap<>();
    properties.put("field1", "Hello");
    properties.put("field2", 1);
    properties.put("field3", Date.from(Instant.now());

    MyPojo result = ObjectMapper.map(properties, MyPojo.class);
}

public class MyPojo {
    private String field1;
    private int field2;
    private Date field3;

    // getters and setters
}
```