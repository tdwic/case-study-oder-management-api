package com.bravo.system.model;

public class SiteManager extends User {

    private String site;
    private Site siteObj;

    public SiteManager(String id, String fName, String lName, String email, String password, String site) {
        super(id, fName, lName, email, password, "SiteManager");
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
