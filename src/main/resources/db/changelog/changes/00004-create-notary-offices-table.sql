--liquibase formatted sql

--changeset VanguardaSistemas:00009
--comment: Creation of table notary_offices
CREATE TABLE notary_offices (
  notary_office_id    CHAR(36) NOT NULL DEFAULT (UUID()),
  notary_office_name  VARCHAR(100) NOT NULL,
  city_name           VARCHAR(50) NOT NULL,
  state_name          VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--changeset VanguardaSistemas:00010
--comment: Add primary key to notary_offices table
ALTER TABLE notary_offices
ADD CONSTRAINT pk_notary_offices
PRIMARY KEY (notary_office_id);