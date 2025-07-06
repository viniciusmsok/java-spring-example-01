package br.com.vanguardasistemas.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
  private UUID addressId;
  private String addressDescription;
  private String addressNumber;
  private String neighborhoodName;
  private String cityName;
  private String postalCode;
}