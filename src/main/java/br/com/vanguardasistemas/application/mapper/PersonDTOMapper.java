package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;

@Service
public class PersonDTOMapper {

  public Person toDomain(PersonInsertInDTO dto) {
    Address mainAddress = null;
    if (dto.mainAddress() != null) {
      mainAddress = Address.builder()
        .addressDescription(dto.mainAddress().addressDescription())
        .addressNumber(dto.mainAddress().addressNumber())
        .neighborhoodName(dto.mainAddress().neighborhoodName())
        .cityName(dto.mainAddress().cityName())
        .postalCode(dto.mainAddress().postalCode())
        .build();
    }

    return Person.builder()
      .personType(dto.personType())
      .nationalIdentifierCode(dto.nationalIdentifierCode())
      .regionalIdentifierCode(dto.regionalIdentifierCode())
      .mainAddress(mainAddress)
      .build();
  }
} 