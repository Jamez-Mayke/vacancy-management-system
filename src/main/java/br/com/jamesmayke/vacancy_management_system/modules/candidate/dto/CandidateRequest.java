package br.com.jamesmayke.vacancy_management_system.modules.candidate.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record CandidateRequest(
    String name,

    @Pattern(regexp="\\S+", message="Não pode conter espaços em branco")
    String username,

    @Email(message="O campo Email precisa conter um email válido")
    String email,

    @Length(min=9, message="Sua senha deve conter pelo menos 9 carácteres")
    @Pattern(regexp="\\S+", message="Não pode conter espaços em branco")
    String password,

    String description
) {
    
}
