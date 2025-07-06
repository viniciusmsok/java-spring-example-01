package br.com.vanguardasistemas.application.dto.address.in;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;

public record AddressInsertInDTO(
  @RequiredString(attributeName = "addressDescription", max = 50)
  String addressDescription,

  @OptionalString(attributeName = "addressNumber", max = 7)
  String addressNumber,

  @OptionalString(attributeName = "neighborhoodName", max = 50)
  String neighborhoodName,

  @OptionalString(attributeName = "cityName", max = 50)
  String cityName,

  @OptionalString(attributeName = "postalCode", max = 10)
  String postalCode
) {} 