package br.com.jamesmayke.vacancy_management_system.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.exceptions.UserFoundException;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateRequest;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateResponse;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.entity.CandidateEntity;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.repository.CandidateRepository;

@Service
public class CandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateResponse execute(CandidateRequest payload) {
        this.candidateRepository
            .findByUsername(payload.username())
            .ifPresent( candidate -> {
                throw new UserFoundException();
            });
        
        CandidateEntity candidate = new CandidateEntity(payload);
        this.candidateRepository.save(candidate);

        return new CandidateResponse(candidate.getId());
    }
}
