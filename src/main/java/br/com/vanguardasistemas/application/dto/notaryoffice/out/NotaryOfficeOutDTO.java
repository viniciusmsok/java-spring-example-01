package br.com.vanguardasistemas.application.dto.notaryoffice.out;

import java.util.UUID;

public record NotaryOfficeOutDTO(
  UUID notaryOfficeId,
  String name,
  String cityName,
  String stateName
) {} 