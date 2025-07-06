--liquibase formatted sql

--changeset VanguardaSistemas:00005
--comment: Creation of table real_estates
CREATE TABLE real_estates (
    real_estate_id               CHAR(36) NOT NULL DEFAULT (UUID()),
    property_type                VARCHAR(40) NOT NULL,
    property_name                VARCHAR(40),
    real_estate_description      VARCHAR(40),
    address_id                   CHAR(36),
    total_area_description       VARCHAR(15),
    built_area_description       VARCHAR(15),
    ideal_area                   VARCHAR(15),
    property_registration_number VARCHAR(40),
    additional_notes             VARCHAR(250)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--changeset VanguardaSistemas:00006
--comment: Add primary key and foreign key to real_estates table
ALTER TABLE real_estates
ADD CONSTRAINT pk_real_estates
PRIMARY KEY (real_estate_id);

ALTER TABLE real_estates
ADD CONSTRAINT fk_real_estates_addresses
FOREIGN KEY (address_id)
REFERENCES addresses(address_id);