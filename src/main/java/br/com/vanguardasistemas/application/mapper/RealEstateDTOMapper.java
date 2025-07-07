package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;

@Service
public class RealEstateDTOMapper {

  private final AddressDTOMapper addressDTOMapper;

  public RealEstateDTOMapper(AddressDTOMapper addressDTOMapper) {
    this.addressDTOMapper = addressDTOMapper;
  }

  public RealEstate toDomain(RealEstateInsertInDTO dto) {
    if (dto == null) {
      return null;
    }

    Address address = addressDTOMapper.toDomain(dto.address());

    return RealEstate.builder()
      .propertyType(dto.propertyType())
      .propertyName(dto.propertyName())
      .description(dto.realEstateDescription())
      .address(address)
      .totalAreaDescription(dto.totalAreaDescription())
      .builtAreaDescription(dto.builtAreaDescription())
      .idealArea(dto.idealArea())
      .propertyRegistrationNumber(dto.propertyRegistrationNumber())
      .additionalNotes(dto.additionalNotes())
      .build();
  }
} 