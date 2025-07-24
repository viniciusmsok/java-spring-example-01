package br.com.vanguardasistemas.adapter.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "notary_offices")
public class NotaryOfficeEntity {
  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "notary_office_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID notaryOfficeId;

  @Column(name = "notary_office_name", nullable = false, length = 100)
  private String notaryOfficeName;

  @Column(name = "city_name", nullable = false, length = 50)
  private String cityName;

  @Column(name = "state_name", nullable = false, length = 50)
  private String stateName;
} 