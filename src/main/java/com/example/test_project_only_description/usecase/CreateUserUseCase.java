package com.example.test_project_only_description.usecase;

import com.example.test_project_only_description.domain.User;
import com.example.test_project_only_description.domain.port.UserCreationPort;
import com.example.test_project_only_description.dto.CreateUserRequest;
import com.example.test_project_only_description.repository.UserRepository;
import com.example.test_project_only_description.usecase.validation.ValidateDniUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements UserCreationPort {
    private final UserRepository userRepository;
    private final ValidateDniUseCase validateDniUseCase;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(CreateUserRequest request) {
        // Validate DNI
        validateDniUseCase.validate(request.getDni());

        // Validate unique email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        // Create and save user
        var user = User.builder()
                .fullName(request.getFullName())
                .dni(request.getDni())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        return userRepository.save(user);
    }
} 