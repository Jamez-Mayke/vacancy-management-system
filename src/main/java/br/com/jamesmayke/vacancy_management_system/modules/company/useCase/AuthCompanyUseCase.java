package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.jamesmayke.vacancy_management_system.modules.company.dto.AuthCompanyDTO;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.username()).orElseThrow(
            () -> {
                return new UsernameNotFoundException("Company not found!");
            }
        );

        var passwordMatchers = this.passwordEncoder.matches(authCompanyDTO.password(), company.getPassword());

        if (!passwordMatchers) {
            throw new AuthenticationException();
        }
    }
}
