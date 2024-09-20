package br.com.jamesmayke.vacancy_management_system.modules.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateRequest;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateResponse;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.useCases.CandidateUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired CandidateUseCase candidateUseCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateRequest payload) {

        try {
            CandidateResponse candidate = this.candidateUseCase.execute(payload);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
        }
       
    }
}
