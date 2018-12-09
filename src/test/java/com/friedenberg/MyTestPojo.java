package com.friedenberg;

import java.util.Date;
import java.util.Objects;

public class MyTestPojo {
    private int field1;
    private String field2;
    private Date field3;
    private boolean field4;

    public MyTestPojo() {
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public Date getField3() {
        return field3;
    }

    public void setField3(Date field3) {
        this.field3 = field3;
    }

    public boolean isField4() {
        return field4;
    }

    public void setField4(boolean field4) {
        this.field4 = field4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestPojo that = (MyTestPojo) o;
        return field1 == that.field1 &&
                field4 == that.field4 &&
                Objects.equals(field2, that.field2) &&
                Objects.equals(field3, that.field3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3, field4);
    }

    @Override
    public String toString() {
        return "MyTestPojo{" +
                "field1=" + field1 +
                ", field2='" + field2 + '\'' +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }
}
