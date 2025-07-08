package br.com.vanguardasistemas.mocks;

import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import java.util.UUID;

public class PersonMocks {
  public static final UUID PERSON_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");
  public static final String PERSON_TYPE = "FISICA";
  public static final String NATIONAL_IDENTIFIER_CODE = "12345678901";
  public static final String REGIONAL_IDENTIFIER_CODE = "SP123456";
  public static final UUID GRANTEE_ID = UUID.fromString("55555555-5555-5555-5555-555555555555");
  public static final UUID GRANTOR_ID = UUID.fromString("66666666-6666-6666-6666-666666666666");

  public static PersonInsertInDTO defaultPersonInsertInDTO(AddressInsertInDTO address) {
    return new PersonInsertInDTO(
      PERSON_TYPE,
      NATIONAL_IDENTIFIER_CODE,
      REGIONAL_IDENTIFIER_CODE,
      address
    );
  }

  public static Person defaultPerson(Address address) {
    return Person.builder()
      .personId(PERSON_ID)
      .personType(PERSON_TYPE)
      .nationalIdentifierCode(NATIONAL_IDENTIFIER_CODE)
      .regionalIdentifierCode(REGIONAL_IDENTIFIER_CODE)
      .mainAddress(address)
      .build();
  }

  public static Person defaultGrantee(Address address) {
    return Person.builder()
      .personId(GRANTEE_ID)
      .personType(PERSON_TYPE)
      .nationalIdentifierCode(NATIONAL_IDENTIFIER_CODE)
      .regionalIdentifierCode(REGIONAL_IDENTIFIER_CODE)
      .mainAddress(address)
      .build();
  }

  public static Person defaultGrantor(Address address) {
    return Person.builder()
      .personId(GRANTOR_ID)
      .personType(PERSON_TYPE)
      .nationalIdentifierCode(NATIONAL_IDENTIFIER_CODE)
      .regionalIdentifierCode(REGIONAL_IDENTIFIER_CODE)
      .mainAddress(address)
      .build();
  }
} 