package com.bravo.system.model;

import org.springframework.data.mongodb.core.mapping.Document;

public class SeniorManager extends User{

    public SeniorManager(String id, String fName, String lName, String email, String password, String role) {
        super(id, fName, lName, email, password, role);
    }

    public void Notify(){

    }

}
