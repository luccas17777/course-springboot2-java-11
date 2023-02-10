package com.ibm.course.services;

import com.ibm.course.entities.User;
import com.ibm.course.repositories.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositroy userRepositroy;

    public List<User> findAll(){
        return userRepositroy.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepositroy.findById(id);
        return obj.get();
    }
}
