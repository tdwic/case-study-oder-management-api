package com.bravo.system.service;

import com.bravo.system.model.User;
import com.bravo.system.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public User NewUser(User user) {
        return testRepository.save(user);
    }

    public List<User> gettAll(){
        return testRepository.findAll();
    }

}
