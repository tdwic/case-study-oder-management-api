package com.bravo.system.service;

import com.bravo.system.entity.UserEntity;
import com.bravo.system.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public UserEntity NewUser(UserEntity userEntity) {
        return testRepository.save(userEntity);
    }

    public List<UserEntity> gettAll(){
        return testRepository.findAll();
    }

}
