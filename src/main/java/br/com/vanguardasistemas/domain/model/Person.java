package br.com.vanguardasistemas.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {

  private UUID personId;
  private String personType;
  private String nationalIdentifierCode;
  private String regionalIdentifierCode;
  private Address mainAddress;
}