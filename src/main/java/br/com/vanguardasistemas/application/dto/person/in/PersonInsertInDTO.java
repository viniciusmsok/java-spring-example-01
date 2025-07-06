package br.com.vanguardasistemas.application.dto.person.in;

import org.springframework.lang.Nullable;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import jakarta.validation.Valid;

public record PersonInsertInDTO(
  @RequiredString(attributeName = "personType", max = 10)
  String personType,

  @RequiredString(attributeName = "nationalIdentifierCode", max = 50)
  String nationalIdentifierCode,

  @OptionalString(attributeName = "regionalIdentifierCode", max = 50)
  String regionalIdentifierCode,

  @Nullable
  @Valid
  AddressInsertInDTO mainAddress
) {} 