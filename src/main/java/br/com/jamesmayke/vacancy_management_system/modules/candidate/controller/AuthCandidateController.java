package br.com.jamesmayke.vacancy_management_system.modules.candidate.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.AuthCandidateDTO;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.useCases.AuthCandidateUseCase;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {
    
    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;


    @PostMapping("/auth")
    public ResponseEntity<Object> create(@RequestBody AuthCandidateDTO authCandidateDTO) {
        try {
            var result = this.authCandidateUseCase.execute(authCandidateDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        
    }
}
