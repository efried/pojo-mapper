package com.friedenberg;

import java.util.Objects;

public class InvalidTestPojo {
    private int field1;
    private String field2;

    public int getField1() {
        return field1;
    }

    public void setField1(int field1, boolean extraParam) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvalidTestPojo that = (InvalidTestPojo) o;
        return field1 == that.field1 &&
                Objects.equals(field2, that.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }

    @Override
    public String toString() {
        return "InvalidTestPojo{" +
                "field1=" + field1 +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
