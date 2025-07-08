package br.com.vanguardasistemas.mocks;

import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;

public class AddressMocks {
  public static final String ADDRESS_DESCRIPTION = "Rua das Flores";
  public static final String ADDRESS_NUMBER = "123";
  public static final String NEIGHBORHOOD_NAME = "Centro";
  public static final String CITY_NAME = "São Paulo";
  public static final String POSTAL_CODE = "01234-567";

  public static AddressInsertInDTO defaultAddressInsertInDTO() {
    return new AddressInsertInDTO(
      ADDRESS_DESCRIPTION,
      ADDRESS_NUMBER,
      NEIGHBORHOOD_NAME,
      CITY_NAME,
      POSTAL_CODE
    );
  }

  public static Address defaultAddress() {
    return Address.builder()
      .addressDescription(ADDRESS_DESCRIPTION)
      .addressNumber(ADDRESS_NUMBER)
      .neighborhoodName(NEIGHBORHOOD_NAME)
      .cityName(CITY_NAME)
      .postalCode(POSTAL_CODE)
      .build();
  }
} 