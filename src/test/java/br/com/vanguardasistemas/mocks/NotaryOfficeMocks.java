package br.com.vanguardasistemas.mocks;

import br.com.vanguardasistemas.domain.model.NotaryOffice;
import java.util.UUID;

public class NotaryOfficeMocks {
  public static final UUID NOTARY_OFFICE_ID = UUID.fromString("33333333-3333-3333-3333-333333333333");
  public static final UUID RECORD_OFFICE_ID = UUID.fromString("44444444-4444-4444-4444-444444444444");
  public static final String NAME = "Cartório Central";
  public static final String CITY_NAME = "São Paulo";
  public static final String STATE_NAME = "SP";

  public static NotaryOffice defaultNotaryOffice() {
    return NotaryOffice.builder()
      .notaryOfficeId(NOTARY_OFFICE_ID)
      .name(NAME)
      .cityName(CITY_NAME)
      .stateName(STATE_NAME)
      .build();
  }

  public static NotaryOffice defaultRecordOffice() {
    return NotaryOffice.builder()
      .notaryOfficeId(RECORD_OFFICE_ID)
      .name(NAME + " - Registro")
      .cityName(CITY_NAME)
      .stateName(STATE_NAME)
      .build();
  }
} 