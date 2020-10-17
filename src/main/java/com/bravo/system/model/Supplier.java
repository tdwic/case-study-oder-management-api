package com.bravo.system.model;

public class Supplier extends User {

    private String company;

    public Supplier(String id, String fName, String lName, String email, String password, String company) {
        super(id, fName, lName, email, password, "Supplier");
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void Notify(){

    }

}
