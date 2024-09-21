package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.exceptions.UserFoundException;
import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Company;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.CompanyRepository;

@Service
public class CompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company execute(Company payload) {
        this.companyRepository
        .findByUsernameOrEmail(payload.getUsername(), payload.getEmail())
        .ifPresent(
            company -> {
                throw new UserFoundException();
            }
        );
        
        return this.companyRepository.save(payload);
    }
}
