package br.com.vanguardasistemas.application.dto.realestate.in;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import jakarta.validation.Valid;

public record RealEstateInsertInDTO(
  @RequiredString(attributeName = "propertyType", max = 40)
  String propertyType,

  @OptionalString(attributeName = "propertyName", max = 40)
  String propertyName,

  @OptionalString(attributeName = "realEstateDescription", max = 40)
  String realEstateDescription,

  @Valid
  AddressInsertInDTO address,

  @OptionalString(attributeName = "totalAreaDescription", max = 15)
  String totalAreaDescription,

  @OptionalString(attributeName = "builtAreaDescription", max = 15)
  String builtAreaDescription,

  @OptionalString(attributeName = "idealArea", max = 15)
  String idealArea,

  @OptionalString(attributeName = "propertyRegistrationNumber", max = 40)
  String propertyRegistrationNumber,

  @OptionalString(attributeName = "additionalNotes", max = 250)
  String additionalNotes
) {} 