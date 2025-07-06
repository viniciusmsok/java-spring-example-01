--liquibase formatted sql

--changeset VanguardaSistemas:00007
--comment: Creation of table addresses
CREATE TABLE addresses (
  address_id           CHAR(36) NOT NULL DEFAULT (UUID()),
  address_description  VARCHAR(50) NOT NULL,
  address_number       VARCHAR(7),
  neighborhood_name    VARCHAR(50),
  city_name            VARCHAR(50),
  postal_code          VARCHAR(10)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--changeset VanguardaSistemas:00008
--comment: Add primary key to addresses table
ALTER TABLE addresses
ADD CONSTRAINT pk_addresses
PRIMARY KEY (address_id);