package com.apsrtc.busmanagement.dao;

import com.apsrtc.busmanagement.model.Role;
import com.apsrtc.busmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDao implements RoleDaoInterface {

    @Autowired
    private RoleRepository roleRepository;


    public Role getRole(String roleName)
    {
        Role role = roleRepository.findByName(roleName).get();
        return role;
    }
}
