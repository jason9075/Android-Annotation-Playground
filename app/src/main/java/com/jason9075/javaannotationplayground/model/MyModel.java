package com.jason9075.javaannotationplayground.model;

import com.jason9075.javaannotationplayground.annotation.MyAnnotation;

/**
 * Created by jason9075 on 2016/6/2.
 */

public class MyModel {

    private String field1;
    private String field2;
    private String field3;

    public MyModel(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @MyAnnotation
    public String method1() {
        return field1;
    }

    @MyAnnotation(value = "Assign Value")
    public String method2() {
        return field2;
    }

    public String method3() {
        return field3;
    }

}
