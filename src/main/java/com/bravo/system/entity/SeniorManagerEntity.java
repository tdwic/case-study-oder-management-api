package com.bravo.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "SeniorManager")
public class SeniorManagerEntity extends UserEntity {

    public SeniorManagerEntity(String id, String fName, String lName, String email, String password, String role) {
        super(id, fName, lName, email, password, role);
    }

    public void Notify(){

    }

}
