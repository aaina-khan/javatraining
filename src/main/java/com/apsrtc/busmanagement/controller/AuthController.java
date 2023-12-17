package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Login;
import com.apsrtc.busmanagement.service.RoleService;
import com.apsrtc.busmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> authenticateUser(@RequestBody Login login){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String,Object> user = userService.userInfo(login.getUsername().toString());

        Map<String, Object> response = Map.of("userInfo", user, "statusCode", HttpStatus.OK);

        return ResponseEntity.ok(response);


    }

}