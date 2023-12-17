package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.dao.RoleDao;
import com.apsrtc.busmanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role getRole(String role){
        return roleDao.getRole(role);
    }
}
