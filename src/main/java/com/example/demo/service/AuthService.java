package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.Userrepository;
import com.example.demo.security.JwtProvider;

import org.springframework.security.authentication.AuthenticationManager;
@Service
public class AuthService {
	
	@Autowired
	private Userrepository userrepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	 @Autowired
	    private AuthenticationManager authenticationManager;
	 
	 @Autowired
	    private JwtProvider jwtProvider;
	 
	public void signup(RegisterRequest registerRequest) {
        User user = new User();
        
        user.setUserName(registerRequest.getUserName());
        user.setEmailid(registerRequest.getEmailid());
         user.setPassword(encodePassword(registerRequest.getPassword()));
         user.setDob(registerRequest.getDob());
         user.setGender(registerRequest.getGender());
         user.setAddress(registerRequest.getAddress());
         user.setContactno(registerRequest.getContactno());
         user.setAccountno(registerRequest.getAccountno());
         user.setBranchname(registerRequest.getBranchname());
         user.setDepoamount(registerRequest.getDepoamount());
       
         userrepository.save(user);
         }
	private String encodePassword(String password) {
		// TODO Auto-generated method stub
		return passwordEncoder.encode(password);
	}
	public String login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        
        return jwtProvider.generateToken(authenticate);
    }
	
	
}