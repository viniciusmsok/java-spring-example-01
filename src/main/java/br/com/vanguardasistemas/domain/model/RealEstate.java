package br.com.vanguardasistemas.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RealEstate {

  private UUID realEstateId;
  private String propertyType;
  private String propertyName;
  private String description;
  private Address address;
  private String totalAreaDescription;
  private String builtAreaDescription;
  private String idealArea;
  private String propertyRegistrationNumber;
  private String additionalNotes;
}