package br.com.jamesmayke.vacancy_management_system.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.repository.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID candidateId) {

        var candidate = this.candidateRepository.findById(candidateId)
            .orElseThrow( () -> {
                throw new UsernameNotFoundException("User not found!");
            });
        
        return new ProfileCandidateResponseDTO(
            candidate.getId(),
            candidate.getName(),
            candidate.getUsername(),
            candidate.getEmail(),
            candidate.getDescription());

    }
}
