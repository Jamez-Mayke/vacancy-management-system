package br.com.jamesmayke.vacancy_management_system.modules.company.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Job;

public interface JobRepository extends JpaRepository<Job, UUID>{
}
