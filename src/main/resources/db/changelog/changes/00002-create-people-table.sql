--liquibase formatted sql

--changeset VanguardaSistemas:00003
--comment: Creation of table people
CREATE TABLE people (
  person_id                 CHAR(36) NOT NULL DEFAULT (UUID()),
  person_type               VARCHAR(10) NOT NULL,
  national_identifier_code  VARCHAR(50) NOT NULL,
  regional_identifier_code  VARCHAR(50),
  main_address_id           CHAR(36)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--changeset VanguardaSistemas:00004
--comment: Add primary key to people table
ALTER TABLE people
ADD CONSTRAINT pk_people
PRIMARY KEY (person_id);

ALTER TABLE people
ADD CONSTRAINT fk_people_addresses_main_addr
FOREIGN KEY (main_address_id)
REFERENCES addresses(address_id);