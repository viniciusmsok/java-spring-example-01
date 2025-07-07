package br.com.vanguardasistemas.application.mapper;

import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.application.dto.address.in.AddressInsertInDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressDTOMapper {
  public Address toDomain(AddressInsertInDTO dto) {
    if (dto == null) {
      return null;
    }

    return Address.builder()
      .addressDescription(dto.addressDescription())
      .addressNumber(dto.addressNumber())
      .neighborhoodName(dto.neighborhoodName())
      .cityName(dto.cityName())
      .postalCode(dto.postalCode())
      .build();
  }
}