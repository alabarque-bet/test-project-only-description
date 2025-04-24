package com.example.test_project_only_description.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank(message = "El nombre completo es requerido")
    private String fullName;

    @NotBlank(message = "El DNI es requerido")
    private String dni;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El formato del email es inválido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
} 