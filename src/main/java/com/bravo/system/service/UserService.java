package com.bravo.system.service;

import com.bravo.system.entity.SeniorManagerEntity;
import com.bravo.system.model.SeniorManager;
import com.bravo.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public SeniorManagerEntity NewSeniorManager(SeniorManager seniorManager){

        String id = seniorManager.getId();
        String fName = seniorManager.getfName();
        String lName = seniorManager.getlName();
        String email = seniorManager.getEmail();
        String password = seniorManager.getPassword();
        String role = seniorManager.getRole();

        SeniorManagerEntity seniorManagerEntity = new SeniorManagerEntity(id,fName,lName,email,password,role);

        return userRepository.save(seniorManagerEntity);
//        System.out.println("Senior Manger" + seniorManagerEntity);

    }

}
