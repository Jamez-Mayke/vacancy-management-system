package br.com.jamesmayke.vacancy_management_system.modules.candidate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateRequest;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.entity.CandidateEntity;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @PostMapping("/")
    public CandidateEntity create(@RequestBody CandidateRequest payload) {
        return new CandidateEntity(payload);
    }
}
