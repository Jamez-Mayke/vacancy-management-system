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

    @Column(name="company_id", nullable=false)
    private UUID companyId;

    @Column(nullable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Job() {
    }

    public Job(UUID id, String level, String description, String benefits, Company company, UUID companyId,
            LocalDateTime createdAt) {
        this.id = id;
        this.level = level;
        this.description = description;
        this.benefits = benefits;
        this.company = company;
        this.companyId = companyId;
        this.createdAt = createdAt;
    }

    private Job(Builder builder) {
        // this.id = builder.id;
        this.level = builder.level;
        this.description = builder.description;
        this.benefits = builder.benefits;
        // this.company = builder.company;
        this.companyId = builder.companyId;
        // this.createdAt = builder.createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    // Builder
    public static class Builder {
        private UUID id;
        private String level;
        private String description;
        private String benefits;
        private Company company;
        private UUID companyId;
        private LocalDateTime createdAt;

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setBenefits(String benefits) {
            this.benefits = benefits;
            return this;
        }

        public Builder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public Builder setCompanyId(UUID companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
        
    }
   
}
