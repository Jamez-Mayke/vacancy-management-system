package br.com.jamesmayke.vacancy_management_system.modules.company.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Company;
import br.com.jamesmayke.vacancy_management_system.modules.company.useCase.CompanyUseCase;
import br.com.jamesmayke.vacancy_management_system.modules.company.useCase.JobUseCase;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyUseCase companyUseCase;

    @Autowired
    private JobUseCase jobUseCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Company payload) {
        try {
            Company company = this.companyUseCase.execute(payload);
            return ResponseEntity.status(HttpStatus.CREATED).body(company);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Object> getJob(@PathVariable UUID id) {
        
        try {
            var result = this.jobUseCase.getJob(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
    }
}
