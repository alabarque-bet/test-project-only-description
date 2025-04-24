package com.example.test_project_only_description.usecase.validation;

import com.example.test_project_only_description.infrastructure.DniValidatorClient;
import com.example.test_project_only_description.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class ValidateDniUseCase {
    private final DniValidatorClient dniValidatorClient;
    private final UserRepository userRepository;

    public void validate(String dni) {
        if (userRepository.existsByDni(dni)) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }

        var response = dniValidatorClient.validateDni(dni);
        
        if (response.isDeceased()) {
            throw new IllegalArgumentException("El DNI corresponde a una persona fallecida");
        }

        var age = Period.between(response.getFechaNacimiento(), LocalDate.now()).getYears();
        if (age < 18) {
            throw new IllegalArgumentException("El usuario debe ser mayor de 18 años");
        }
    }
} 