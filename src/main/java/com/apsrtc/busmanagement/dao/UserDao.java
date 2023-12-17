package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.User;
import com.apsrtc.busmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements UserDaoInterface {
    @Autowired
    private UserRepository userRepository;


    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }



}
