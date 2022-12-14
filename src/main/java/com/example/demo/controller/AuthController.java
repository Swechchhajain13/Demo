package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        log.info("Inside Signup : ");
        return new ResponseEntity(HttpStatus.OK);
    }
	
	@PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
		log.info("Inside Login : ");
        return authService.login(loginRequest);
    }

	}
