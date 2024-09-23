CREATE TABLE job (
    id UUID DEFAULT gen_random_uuid() NOT NULL,
    level VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    benefits VARCHAR(255) NOT NULL,
    company_id UUID,
    created_at DATE NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);