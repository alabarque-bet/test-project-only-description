package com.example.test_project_only_description.domain.port;

import com.example.test_project_only_description.domain.User;
import com.example.test_project_only_description.dto.CreateUserRequest;

public interface UserCreationPort {
    User createUser(CreateUserRequest request);
} 