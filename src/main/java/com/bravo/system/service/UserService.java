package com.bravo.system.service;

import com.bravo.system.entity.DefaultUserEntity;
import com.bravo.system.entity.UserEntity;
import com.bravo.system.model.*;
import com.bravo.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


class TempUser{
    String id = "";
    String fName = "";
    String lName = "";
    String email = "";
    String password = "";
    String role = "";
    String company = "";
    String site = "";
}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Post Methods
    public DefaultUserEntity NewSeniorManager(SeniorManager seniorManager){

        TempUser tempUser = new TempUser();

        tempUser.id = seniorManager.getId();
        tempUser.fName = seniorManager.getfName();
        tempUser.lName = seniorManager.getlName();
        tempUser.email = seniorManager.getEmail();
        tempUser.password = seniorManager.getPassword();
        tempUser.role = seniorManager.getRole();
        tempUser.company = "";
        tempUser.site = "";

        DefaultUserEntity defaultUserEntity = new DefaultUserEntity(tempUser.id,tempUser.fName,tempUser.lName,tempUser.email,tempUser.password,tempUser.role,tempUser.company,tempUser.site);
        return userRepository.save(defaultUserEntity);

    }

    public DefaultUserEntity NewProcumentStaff(ProcumentStaff procumentStaff){

        TempUser tempUser = new TempUser();

        tempUser.id = procumentStaff.getId();
        tempUser.fName = procumentStaff.getfName();
        tempUser.lName = procumentStaff.getlName();
        tempUser.email = procumentStaff.getEmail();
        tempUser.password = procumentStaff.getPassword();
        tempUser.role = procumentStaff.getRole();
        tempUser.company = "";
        tempUser.site = "";

        DefaultUserEntity defaultUserEntity = new DefaultUserEntity(tempUser.id,tempUser.fName,tempUser.lName,tempUser.email,tempUser.password,tempUser.role,tempUser.company,tempUser.site);
        return userRepository.save(defaultUserEntity);

    }

    public DefaultUserEntity NewSupplier(Supplier supplier){

        TempUser tempUser = new TempUser();

        tempUser.id = supplier.getId();
        tempUser.fName = supplier.getfName();
        tempUser.lName = supplier.getlName();
        tempUser.email = supplier.getEmail();
        tempUser.password = supplier.getPassword();
        tempUser.role = supplier.getRole();
        tempUser.company = supplier.getCompany();
        tempUser.site = "";

        DefaultUserEntity defaultUserEntity = new DefaultUserEntity(tempUser.id,tempUser.fName,tempUser.lName,tempUser.email,tempUser.password,tempUser.role,tempUser.company,tempUser.site);
        return userRepository.save(defaultUserEntity);

    }

    public DefaultUserEntity NewSiteManager(SiteManager siteManager){
        TempUser tempUser = new TempUser();

        tempUser.id = siteManager.getId();
        tempUser.fName = siteManager.getfName();
        tempUser.lName = siteManager.getlName();
        tempUser.email = siteManager.getEmail();
        tempUser.password = siteManager.getPassword();
        tempUser.role = siteManager.getRole();
        tempUser.company = "";
        tempUser.site = siteManager.getSite();

        DefaultUserEntity defaultUserEntity = new DefaultUserEntity(tempUser.id,tempUser.fName,tempUser.lName,tempUser.email,tempUser.password,tempUser.role,tempUser.company,tempUser.site);
        return userRepository.save(defaultUserEntity);

    }

    //Post Methods

    //GET all user
    public List<DefaultUserEntity> GetAllUsers(){
        return userRepository.findAll();
    }
    public List<DefaultUserEntity> GetAllSuppliers(){
        return userRepository.findByrole("Supplier");
    }
    public List<DefaultUserEntity> GetAllSiteManagers(){
        return userRepository.findByrole("SiteManager");
    }
    //GET all user

    //Validate User
    public boolean ValidateUser(UserValidity userValidity) {

        DefaultUserEntity defaultUserEntity;
        defaultUserEntity = userRepository.findByemail(userValidity.getUsername());

        if (defaultUserEntity != null && defaultUserEntity.getPassword().equals(userValidity.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
