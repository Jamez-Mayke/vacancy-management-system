package br.com.jamesmayke.vacancy_management_system.modules.candidate.useCases;

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

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.AuthCandidateDTO;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.AuthCandidateResponseDTO;
import br.com.jamesmayke.vacancy_management_system.modules.candidate.repository.CandidateRepository;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public AuthCandidateResponseDTO execute(AuthCandidateDTO authCandidateDTO) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidateDTO.username())
            .orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("username / password incorrect!");
                }
            );

        var password = this.passwordEncoder.matches(authCandidateDTO.password(), 
        candidate.getPassword());

        if (!password) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));
        var token = JWT.create()
            .withIssuer("javagas")
            .withClaim("roles", Arrays.asList("candidate"))
            .withExpiresAt(expiresIn)
            .withSubject(candidate.getId().toString())
            .sign(algorithm);
        
        return new AuthCandidateResponseDTO(token, expiresIn.toEpochMilli());
    }
}
