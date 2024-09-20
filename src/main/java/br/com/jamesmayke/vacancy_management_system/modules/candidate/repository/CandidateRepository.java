package br.com.jamesmayke.vacancy_management_system.modules.candidate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    
    Optional<CandidateEntity> findByUsername(String username);
}
