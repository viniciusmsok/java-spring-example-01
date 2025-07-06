package br.com.vanguardasistemas.application.dto.person.out;

import java.util.UUID;

import br.com.vanguardasistemas.application.dto.address.out.AddressOutDTO;

public record PersonOutDTO(
  UUID personId,
  String personType,
  String nationalIdentifierCode,
  String regionalIdentifierCode,
  AddressOutDTO mainAddress
) {} 