package br.com.jamesmayke.vacancy_management_system.modules.company.useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.jamesmayke.vacancy_management_system.modules.company.dto.AuthCompanyDTO;
import br.com.jamesmayke.vacancy_management_system.modules.company.dto.AuthCompanyResponseDTO;
import br.com.jamesmayke.vacancy_management_system.modules.company.repository.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.username())
            .orElseThrow(
                () -> {
                    return new UsernameNotFoundException("username/password not found!");
                }
            );

        var passwordMatchers = this.passwordEncoder
            .matches(authCompanyDTO.password(), company.getPassword());

        if (!passwordMatchers) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));
        var token = JWT.create()
            .withIssuer("javagas")
            .withExpiresAt(expiresIn)
            .withClaim("roles", Arrays.asList("COMPANY"))
            .withSubject(company.getId().toString())
            .sign(algorithm);

        return new AuthCompanyResponseDTO(token, expiresIn.toEpochMilli());
    }
}
