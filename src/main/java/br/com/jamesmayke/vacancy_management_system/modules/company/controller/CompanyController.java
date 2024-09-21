package br.com.jamesmayke.vacancy_management_system.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Company;
import br.com.jamesmayke.vacancy_management_system.modules.company.useCase.CompanyUseCase;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyUseCase companyUseCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Company payload) {
        try {
            Company company = this.companyUseCase.execute(payload);
            return ResponseEntity.status(HttpStatus.CREATED).body(company);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
