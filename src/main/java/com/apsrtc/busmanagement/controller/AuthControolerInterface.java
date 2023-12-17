package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AuthControolerInterface {

    ResponseEntity<Map<String,Object>> authenticateUser(@RequestBody Login login);
}
