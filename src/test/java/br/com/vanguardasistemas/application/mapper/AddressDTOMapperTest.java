package br.com.vanguardasistemas.application.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.mocks.AddressMocks;

class AddressDTOMapperTest {

  private AddressDTOMapper addressDTOMapper;

  @BeforeEach
  void setUp() {
    addressDTOMapper = new AddressDTOMapper();
  }

  @Test
  void shouldMapAddressInsertInDTOToAddress() {
    AddressInsertInDTO dto = AddressMocks.defaultAddressInsertInDTO();

    Address result = addressDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(AddressMocks.ADDRESS_DESCRIPTION, result.getAddressDescription());
    assertEquals(AddressMocks.ADDRESS_NUMBER, result.getAddressNumber());
    assertEquals(AddressMocks.NEIGHBORHOOD_NAME, result.getNeighborhoodName());
    assertEquals(AddressMocks.CITY_NAME, result.getCityName());
    assertEquals(AddressMocks.POSTAL_CODE, result.getPostalCode());
  }

  @Test
  void shouldMapAddressInsertInDTOWithNullValues() {
    AddressInsertInDTO dto = new AddressInsertInDTO(
      AddressMocks.ADDRESS_DESCRIPTION,
      null,
      null,
      AddressMocks.CITY_NAME,
      null
    );

    Address result = addressDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(AddressMocks.ADDRESS_DESCRIPTION, result.getAddressDescription());
    assertNull(result.getAddressNumber());
    assertNull(result.getNeighborhoodName());
    assertEquals(AddressMocks.CITY_NAME, result.getCityName());
    assertNull(result.getPostalCode());
  }
} 