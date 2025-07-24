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
@Table(name = "addresses")
public class AddressEntity {
  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "address_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID addressId;

  @Column(name = "address_description", nullable = false, length = 50)
  private String addressDescription;

  @Column(name = "address_number", length = 7)
  private String addressNumber;

  @Column(name = "neighborhood_name", length = 50)
  private String neighborhoodName;

  @Column(name = "city_name", length = 50)
  private String cityName;

  @Column(name = "postal_code", length = 10)
  private String postalCode;
} 