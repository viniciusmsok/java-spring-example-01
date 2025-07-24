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
@Table(name = "real_estates")
public class RealEstateEntity {

  @Id
  @GeneratedValue
  @UuidGenerator
  @Column(name = "real_estate_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
  @JdbcTypeCode(SqlTypes.CHAR)
  private UUID realEstateId;

  @Column(name = "property_type", nullable = false, length = 40)
  private String propertyType;

  @Column(name = "property_name", length = 40)
  private String propertyName;

  @Column(name = "real_estate_description", length = 40)
  private String realEstateDescription;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "address_id")
  private AddressEntity address;

  @Column(name = "total_area_description", length = 15)
  private String totalAreaDescription;

  @Column(name = "built_area_description", length = 15)
  private String builtAreaDescription;

  @Column(name = "ideal_area", length = 15)
  private String idealArea;

  @Column(name = "property_registration_number", length = 40)
  private String propertyRegistrationNumber;

  @Column(name = "additional_notes", length = 250)
  private String additionalNotes;
}