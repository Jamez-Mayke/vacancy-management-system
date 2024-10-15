package br.com.jamesmayke.vacancy_management_system.modules.company.dto;

public record AuthCompanyResponseDTO(
    String access_token,
    Long expiresIn
) {
    
}
