package br.com.jamesmayke.vacancy_management_system.modules.company.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesmayke.vacancy_management_system.modules.company.dto.JobRequestDTO;
import br.com.jamesmayke.vacancy_management_system.modules.company.dto.JobResponseDTO;
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
    public JobResponseDTO create(@Valid @RequestBody JobRequestDTO jobRequestDTO, HttpServletRequest request) {

        var companyId = request.getAttribute("company_id");

        var job = Job.builder()
            .setLevel(jobRequestDTO.level())
            .setBenefits(jobRequestDTO.benefits())
            .setCompanyId(UUID.fromString(companyId.toString()))
            .setDescription(jobRequestDTO.description())
            .build();

        var jobResponse = this.JobUseCase.execute(job);

        return new JobResponseDTO(jobResponse.getId());
    };
}
