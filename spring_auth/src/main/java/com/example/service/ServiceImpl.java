package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.example.dto.*;
import com.example.dto.SignUpDto;
import com.example.model.ERole;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.security.JwtUtils;

@Service
public class ServiceImpl {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private  PasswordEncoder encoder;

	@Autowired
	private RoleRepository roleRepo;
	public ResponseEntity<?> create(@RequestBody SignUpDto data){
		if (userRepo.existsByUsername(data.getUsername())) {
		      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		    }

		    if (userRepo.existsByEmail(data.getEmail())) {
		      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		    }
		User newUser=new User(data.getUsername(),data.getEmail(), encoder.encode(data.getPassword()));
		HashSet<Role> roles=new HashSet<>();
		Set<String> fromdto=data.getRole();
		 if (fromdto == null) {
		      Role userRole = roleRepo.findByName(ERole.ROLE_USER)
		          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		      roles.add(userRole);
		    }
		 else {
		fromdto.forEach(a->{
			switch(a) {
			case "admin":
				Role admin=roleRepo.findByName(ERole.ROLE_ADMIN).orElseThrow(
						() -> new RuntimeException("Error: Role is not found."));
		          roles.add(admin);

		          break;
			case "moderator":
				Role mode=roleRepo.findByName(ERole.ROLE_MODERATOR).orElseThrow(
						() -> new RuntimeException("Error: Role is not found."));
		          roles.add(mode);

		          break;
			default:
		          Role userRole = roleRepo.findByName(ERole.ROLE_USER)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(userRole);
			}
				
		});}
		   newUser.setRoles(roles);
		    userRepo.save(newUser);
		    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	public ResponseEntity<?> auth(@RequestBody LoginRequest data){
		Authentication authentication = authenticationManager
		        .authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),
	                                   userDetails.getEmail(),
	                                   roles));
	
	}
	public ResponseEntity<?> logout() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
}
