package br.com.jamesmayke.vacancy_management_system.modules.candidate.entity;

import java.util.UUID;

import br.com.jamesmayke.vacancy_management_system.modules.candidate.dto.CandidateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String password;
    
    @Column(nullable=false)
    private String description;
    
    public CandidateEntity() {}

    public CandidateEntity(CandidateRequest candidate) {

        this.name = candidate.name();
        this.username = candidate.username();
        this.email = candidate.email();
        this.password = candidate.password();
        this.description = candidate.description();

    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
