package br.com.vanguardasistemas.application.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.mocks.AddressMocks;
import br.com.vanguardasistemas.mocks.PersonMocks;

@ExtendWith(MockitoExtension.class)
class PersonDTOMapperTest {

  @Mock
  private AddressDTOMapper addressDTOMapper;

  private PersonDTOMapper personDTOMapper;

  @BeforeEach
  void setUp() {
    personDTOMapper = new PersonDTOMapper(addressDTOMapper);
  }

  @Test
  void shouldMapPersonInsertInDTOToPersonWithAddress() {
    AddressInsertInDTO addressDTO = AddressMocks.defaultAddressInsertInDTO();
    PersonInsertInDTO dto = PersonMocks.defaultPersonInsertInDTO(addressDTO);
    Address expectedAddress = AddressMocks.defaultAddress();

    when(addressDTOMapper.toDomain(addressDTO)).thenReturn(expectedAddress);

    Person result = personDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(PersonMocks.PERSON_TYPE, result.getPersonType());
    assertEquals(PersonMocks.NATIONAL_IDENTIFIER_CODE, result.getNationalIdentifierCode());
    assertEquals(PersonMocks.REGIONAL_IDENTIFIER_CODE, result.getRegionalIdentifierCode());
    assertEquals(expectedAddress, result.getMainAddress());
    verify(addressDTOMapper).toDomain(addressDTO);
  }

  @Test
  void shouldMapPersonInsertInDTOToPersonWithoutAddress() {
    PersonInsertInDTO dto = new PersonInsertInDTO(
      PersonMocks.PERSON_TYPE,
      PersonMocks.NATIONAL_IDENTIFIER_CODE,
      PersonMocks.REGIONAL_IDENTIFIER_CODE,
      null
    );

    Person result = personDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(PersonMocks.PERSON_TYPE, result.getPersonType());
    assertEquals(PersonMocks.NATIONAL_IDENTIFIER_CODE, result.getNationalIdentifierCode());
    assertEquals(PersonMocks.REGIONAL_IDENTIFIER_CODE, result.getRegionalIdentifierCode());
    assertNull(result.getMainAddress());
  }
} 