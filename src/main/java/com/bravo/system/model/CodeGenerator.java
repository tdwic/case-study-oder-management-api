package com.bravo.system.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CodeGenerator")
public class CodeGenerator {

     @Id
    private String id;
    private int value;

    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
