package com.bravo.system.controller;

import com.bravo.system.entity.SiteEntity;
import com.bravo.system.model.Product;
import com.bravo.system.model.Site;
import com.bravo.system.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "addSite", method = RequestMethod.POST)
    public SiteEntity AddSite(@RequestBody Site site) {
        return siteService.AddSite(site);
    }

}
