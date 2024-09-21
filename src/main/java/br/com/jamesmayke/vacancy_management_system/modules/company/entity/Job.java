package br.com.jamesmayke.vacancy_management_system.modules.company.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(nullable=false)
    private String level;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private String benefits;

    @ManyToOne
    @JoinColumn(name="company_id", insertable=false, updatable=false)
    private Company company;

    @Column(name="company_id")
    private UUID companyId;

    @Column(nullable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
