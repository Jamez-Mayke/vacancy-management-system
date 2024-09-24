package br.com.jamesmayke.vacancy_management_system.modules.company.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findByUsernameOrEmail(String username, String email);
    Optional<Company> findByUsername(String username);
}
