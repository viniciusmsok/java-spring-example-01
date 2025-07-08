package br.com.vanguardasistemas.application.mapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.mocks.AddressMocks;
import br.com.vanguardasistemas.mocks.RealEstateMocks;

@ExtendWith(MockitoExtension.class)
class RealEstateDTOMapperTest {

  @Mock
  private AddressDTOMapper addressDTOMapper;

  private RealEstateDTOMapper realEstateDTOMapper;

  @BeforeEach
  void setUp() {
    realEstateDTOMapper = new RealEstateDTOMapper(addressDTOMapper);
  }

  @Test
  void shouldMapRealEstateInsertInDTOToRealEstateWithAddress() {
    AddressInsertInDTO addressDTO = AddressMocks.defaultAddressInsertInDTO();
    RealEstateInsertInDTO dto = RealEstateMocks.defaultRealEstateInsertInDTO(addressDTO);
    Address expectedAddress = AddressMocks.defaultAddress();

    when(addressDTOMapper.toDomain(addressDTO)).thenReturn(expectedAddress);

    RealEstate result = realEstateDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(RealEstateMocks.PROPERTY_TYPE, result.getPropertyType());
    assertEquals(RealEstateMocks.PROPERTY_NAME, result.getPropertyName());
    assertEquals(RealEstateMocks.DESCRIPTION, result.getDescription());
    assertEquals(expectedAddress, result.getAddress());
    assertEquals(RealEstateMocks.TOTAL_AREA_DESCRIPTION, result.getTotalAreaDescription());
    assertEquals(RealEstateMocks.BUILT_AREA_DESCRIPTION, result.getBuiltAreaDescription());
    assertEquals(RealEstateMocks.IDEAL_AREA, result.getIdealArea());
    assertEquals(RealEstateMocks.PROPERTY_REGISTRATION_NUMBER, result.getPropertyRegistrationNumber());
    assertEquals(RealEstateMocks.ADDITIONAL_NOTES, result.getAdditionalNotes());
    verify(addressDTOMapper).toDomain(addressDTO);
  }

  @Test
  void shouldMapRealEstateInsertInDTOToRealEstateWithoutAddress() {
    RealEstateInsertInDTO dto = new RealEstateInsertInDTO(
      RealEstateMocks.PROPERTY_TYPE,
      RealEstateMocks.PROPERTY_NAME,
      RealEstateMocks.DESCRIPTION,
      null,
      RealEstateMocks.TOTAL_AREA_DESCRIPTION,
      RealEstateMocks.BUILT_AREA_DESCRIPTION,
      RealEstateMocks.IDEAL_AREA,
      RealEstateMocks.PROPERTY_REGISTRATION_NUMBER,
      null
    );

    RealEstate result = realEstateDTOMapper.toDomain(dto);

    assertNotNull(result);
    assertEquals(RealEstateMocks.PROPERTY_TYPE, result.getPropertyType());
    assertEquals(RealEstateMocks.PROPERTY_NAME, result.getPropertyName());
    assertEquals(RealEstateMocks.DESCRIPTION, result.getDescription());
    assertNull(result.getAddress());
    assertEquals(RealEstateMocks.TOTAL_AREA_DESCRIPTION, result.getTotalAreaDescription());
    assertEquals(RealEstateMocks.BUILT_AREA_DESCRIPTION, result.getBuiltAreaDescription());
    assertEquals(RealEstateMocks.IDEAL_AREA, result.getIdealArea());
    assertEquals(RealEstateMocks.PROPERTY_REGISTRATION_NUMBER, result.getPropertyRegistrationNumber());
    assertNull(result.getAdditionalNotes());
  }
}