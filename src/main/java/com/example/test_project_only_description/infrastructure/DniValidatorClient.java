package com.example.test_project_only_description.infrastructure;

import com.example.test_project_only_description.domain.port.DniValidatorPort;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class DniValidatorClient implements DniValidatorPort {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public DniValidatorClient(
            @Value("${dni.validator.base-url}") String baseUrl
    ) {
        this.restTemplate = new RestTemplate();
        this.baseUrl = baseUrl;
    }

    @Override
    public DniValidationResult validateDni(String dni) {
        return restTemplate.getForObject(
                baseUrl + "?dni={dni}",
                DniValidationResponseImpl.class,
                dni
        );
    }

    @Data
    private static class DniValidationResponseImpl implements DniValidationResult {
        private LocalDate fechaNacimiento;
        private boolean isDeceased;
    }
} 