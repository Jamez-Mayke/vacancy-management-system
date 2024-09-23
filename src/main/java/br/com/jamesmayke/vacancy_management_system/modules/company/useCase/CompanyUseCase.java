package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.exceptions.UserFoundException;
import br.com.jamesmayke.vacancy_management_system.modules.company.entity.Company;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.CompanyRepository;

@Service
public class CompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Company execute(Company payload) {
        this.companyRepository
        .findByUsernameOrEmail(payload.getUsername(), payload.getEmail())
        .ifPresent(
            company -> {
                throw new UserFoundException();
            }
        );

        var password = this.passwordEncoder.encode(payload.getPassword());
        payload.setPassword(password);
        
        return this.companyRepository.save(payload);
    }
}
