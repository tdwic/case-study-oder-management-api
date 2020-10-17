package com.bravo.system.service;

import com.bravo.system.entity.SiteEntity;
import com.bravo.system.model.Site;
import com.bravo.system.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public SiteEntity AddSite(Site site){
        SiteEntity siteEntity = new SiteEntity(site.getId(),site.getName(),site.getAddress(),site.getPhoneNo());

        return siteRepository.save(siteEntity);

    }


}
