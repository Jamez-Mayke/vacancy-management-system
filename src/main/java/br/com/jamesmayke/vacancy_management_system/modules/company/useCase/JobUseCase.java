package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Job;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.JobRepository;

@Service
public class JobUseCase {

    @Autowired
    private JobRepository jobRepository;
    
    public Job execute(Job payload) {
        return this.jobRepository.save(payload);
    }
}
