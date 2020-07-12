package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class Test {


    @JsonbProperty
    private String name;


    public Test() {
    }

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
