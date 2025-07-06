package br.com.vanguardasistemas.application.dto.notaryoffice.in;

import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;

public record NotaryOfficeInsertInDTO(
  @RequiredString(attributeName = "notaryOfficeName", max = 100)
  String notaryOfficeName,

  @RequiredString(attributeName = "cityName", max = 50)
  String cityName,

  @RequiredString(attributeName = "stateName", max = 50)
  String stateName
) {} 