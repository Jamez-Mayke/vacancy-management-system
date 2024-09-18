package br.com.jamesmayke.vacancy_management_system.modules.candidate.dto;

public record CandidateRequest(
    String name,
    String username,
    String email,
    String password,
    String description
) {
    
}
