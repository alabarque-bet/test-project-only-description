package com.example.test_project_only_description.domain.port;

import java.time.LocalDate;

public interface DniValidatorPort {
    DniValidationResult validateDni(String dni);

    interface DniValidationResult {
        LocalDate getFechaNacimiento();
        boolean isDeceased();
    }
} 