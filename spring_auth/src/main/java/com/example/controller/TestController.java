package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

  @GetMapping("/all")
  public String allAccess() {
    return "Public School Portal.";
  }

  @GetMapping("/student")
  @PreAuthorize("hasRole('STUDENT') or hasRole('PRINCIPAL') or hasRole('TEACHER')")
  public String studentAccess() {
    return "Student Content.";
  }

  @GetMapping("/principal")
  @PreAuthorize("hasRole('PRINCIPAL') or hasRole('TEACHER')")
  public String principalAccess() {
    return "Principal Board.";
  }

  @GetMapping("/teacher")
  @PreAuthorize("hasRole('TEACHER')")
  public String teacherAccess() {
    return "Teacher Board (Admin).";
  }
}
