package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.modules.company.dto.JobRequestDTO;
import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Job;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.JobRepository;

@Service
public class JobUseCase {

    @Autowired
    private JobRepository jobRepository;
    
    public Job createAndSaveJob(JobRequestDTO jobRequestDTO, UUID companyId) {
        return this.jobRepository.save(createJob(jobRequestDTO, companyId));
    }

    private Job createJob(JobRequestDTO jobRequestDTO, UUID companyId) {
        return Job.builder()
        .setLevel(jobRequestDTO.level())
        .setBenefits(jobRequestDTO.benefits())
        .setCompanyId(companyId)
        .setDescription(jobRequestDTO.description())
        .build();
    }

    public Optional<Job> getJob(UUID id) {
        return this.jobRepository.findById(id);
    }
}
