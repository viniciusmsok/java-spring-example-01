package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;

@Service
public class RealEstateDTOMapper {

  public RealEstate toDomain(RealEstateInsertInDTO dto) {
    Address address = null;
    if (dto.address() != null) {
      address = Address.builder()
        .addressDescription(dto.address().addressDescription())
        .addressNumber(dto.address().addressNumber())
        .neighborhoodName(dto.address().neighborhoodName())
        .cityName(dto.address().cityName())
        .postalCode(dto.address().postalCode())
        .build();
    }

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