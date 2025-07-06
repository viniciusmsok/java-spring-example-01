package br.com.vanguardasistemas.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotaryOffice {

  private UUID notaryOfficeId;
  private String name;
  private String cityName;
  private String stateName;
}