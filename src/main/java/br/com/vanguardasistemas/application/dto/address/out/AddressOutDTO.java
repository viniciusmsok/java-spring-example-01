package br.com.vanguardasistemas.application.dto.address.out;

import java.util.UUID;

public record AddressOutDTO(
  UUID addressId,
  String addressDescription,
  String addressNumber,
  String neighborhoodName,
  String cityName,
  String postalCode
) {} 