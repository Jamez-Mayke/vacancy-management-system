package br.com.jamesmayke.vacancy_management_system.modules.company.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Job;
import br.com.jamesmayke.vacancy_management_system.modules.company.useCase.JobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private JobUseCase JobUseCase;
    
    @PostMapping("/")
    public Job create(@Valid @RequestBody Job job, HttpServletRequest request) {
        
        var companyId = request.getAttribute("company_id");
        job.setCompanyId(UUID.fromString(companyId.toString()));
        return this.JobUseCase.execute(job);
    }
}
