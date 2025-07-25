package br.com.vanguardasistemas.adapter.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "itbi_payment_slips")
public class ItbiPaymentSlipEntity {

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "itbi_payment_slip_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID itbiPaymentSlipId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tax_payer_id")
  private PersonEntity taxPayer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "real_estate_id")
  private RealEstateEntity realEstate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "notary_office_id")
  private NotaryOfficeEntity notaryOffice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "record_office_id")
  private NotaryOfficeEntity recordOffice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "real_estate_grantee_id")
  private PersonEntity realEstateGrantee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "real_estate_grantor_id")
  private PersonEntity realEstateGrantor;

  @Column(name = "transaction_type", nullable = false, length = 50)
  private String transactionType;

  @Column(name = "official_record_code", length = 50)
  private String officialRecordCode;
} 