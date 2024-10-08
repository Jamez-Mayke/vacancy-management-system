package br.com.jamesmayke.vacancy_management_system.modules.candidate.dto;

public record AuthCandidateResponseDTO(
    String access_token,
    Long expiresIn
) {
    
}
