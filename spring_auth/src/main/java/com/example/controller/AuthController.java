package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.dto.SignUpDto;
import com.example.service.ServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private ServiceImpl service;

	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody SignUpDto data) {
		return service.create(data);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
		return service.auth(loginRequest);
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
	   return service.logout();
	}
}
