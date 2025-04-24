package com.example.test_project_only_description.controller;

import com.example.test_project_only_description.domain.User;
import com.example.test_project_only_description.domain.port.UserCreationPort;
import com.example.test_project_only_description.dto.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserCreationPort userCreationPort;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
        var user = userCreationPort.createUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
} 