package br.com.vanguardasistemas.adapter.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
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
@Table(name = "people")
public class PersonEntity {

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "person_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID personId;

  @Column(name = "person_type", nullable = false, length = 10)
  private String personType;

  @Column(name = "national_identifier_code", length = 50)
  private String nationalIdentifierCode;

  @Column(name = "regional_identifier_code", length = 50)
  private String regionalIdentifierCode;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "main_address_id")
  private AddressEntity mainAddress;
}