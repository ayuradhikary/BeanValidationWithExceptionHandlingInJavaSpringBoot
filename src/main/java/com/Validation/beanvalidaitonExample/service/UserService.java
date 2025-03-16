package com.Validation.beanvalidaitonExample.service;

import com.Validation.beanvalidaitonExample.dto.UserRequest;
import com.Validation.beanvalidaitonExample.entity.User;
import com.Validation.beanvalidaitonExample.exception.UserNotFoundException;
import com.Validation.beanvalidaitonExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = User.
                build(0,userRequest.getName(),userRequest.getEmail(),
                        userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());

        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {

        User user =  repository.findByuserId(id);
        if(user != null){
            return user;
        }else {
            throw new UserNotFoundException("user not found with id: "+id);
        }
    }

}
