package br.com.vanguardasistemas.application.dto.realestate.out;

import java.util.UUID;

import br.com.vanguardasistemas.application.dto.address.out.AddressOutDTO;

public record RealEstateOutDTO(
  UUID realEstateId,
  String propertyType,
  String propertyName,
  String description,
  AddressOutDTO address,
  String totalAreaDescription,
  String builtAreaDescription,
  String idealArea,
  String propertyRegistrationNumber,
  String additionalNotes
) {} 