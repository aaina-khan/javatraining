package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.dao.UserDao;
import com.apsrtc.busmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDao userDao;

    public Map<String,Object> userInfo(String username) {
        User user = userDao.getUser(username);
        return Map.of("username", user.getUsername(), "role", user.getRoles());
    }
}
