--liquibase formatted sql

--changeset VanguardaSistemas:00003
--comment: Creation of table itbi_payment_slips
CREATE TABLE itbi_payment_slips (
    itbi_payment_slip_id   CHAR(36) NOT NULL DEFAULT (UUID()),
    tax_payer_id           CHAR(36) NOT NULL,
    real_estate_id         CHAR(36) NOT NULL,
    notary_office_id       CHAR(36) NOT NULL,
    record_office_id       CHAR(36) NOT NULL,
    real_estate_grantee_id  CHAR(36) NOT NULL,
    real_estate_grantor_id  CHAR(36) NOT NULL,
    transaction_type       VARCHAR(50) NOT NULL,
    official_record_code   VARCHAR(40)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--changeset VanguardaSistemas:00004
--comment: Add primary key to itbi_payment_slips table
ALTER TABLE itbi_payment_slips
ADD CONSTRAINT pk_itbi_payment_slips
PRIMARY KEY (itbi_payment_slip_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_tax_payer
FOREIGN KEY (tax_payer_id)
REFERENCES people(person_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_rl_est_grantee
FOREIGN KEY (real_estate_grantee_id)
REFERENCES real_estates(real_estate_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_rl_est_grantor
FOREIGN KEY (real_estate_grantor_id)
REFERENCES real_estates(real_estate_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_real_estate
FOREIGN KEY (real_estate_id)
REFERENCES real_estates(real_estate_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_notary_office
FOREIGN KEY (notary_office_id)
REFERENCES notary_offices(notary_office_id);

ALTER TABLE itbi_payment_slips
ADD CONSTRAINT fk_itbi_paym_sl_record_office
FOREIGN KEY (record_office_id)
REFERENCES notary_offices(notary_office_id);