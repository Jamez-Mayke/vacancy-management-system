package br.com.jamesmayke.vacancy_management_system.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Job;
import br.com.jamesmayke.vacancy_management_system.modules.company.useCase.JobUseCase;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private JobUseCase JobUseCase;
    
    @PostMapping("/")
    public Job create(@RequestBody Job job) {
        return this.JobUseCase.execute(job);
    }
}
