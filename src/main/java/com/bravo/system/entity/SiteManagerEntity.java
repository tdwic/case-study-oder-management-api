package com.bravo.system.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SiteManager")
public class SiteManagerEntity extends UserEntity {

    private String site;
    private String siteId;

    public SiteManagerEntity(String id, String fName, String lName, String email, String password, String role, String site, String siteId) {
        super(id, fName, lName, email, password, role);
        this.site = site;
        this.siteId = siteId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
}
