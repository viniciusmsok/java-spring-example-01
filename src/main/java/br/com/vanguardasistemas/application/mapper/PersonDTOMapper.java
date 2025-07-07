package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;

@Service
public class PersonDTOMapper {

  private final AddressDTOMapper addressDTOMapper;

  public PersonDTOMapper(AddressDTOMapper addressDTOMapper) {
    this.addressDTOMapper = addressDTOMapper;
  }

  public Person toDomain(PersonInsertInDTO dto) {
    if (dto == null) {
      return null;
    }

    Address mainAddress = addressDTOMapper.toDomain(dto.mainAddress());

    return Person.builder()
      .personType(dto.personType())
      .nationalIdentifierCode(dto.nationalIdentifierCode())
      .regionalIdentifierCode(dto.regionalIdentifierCode())
      .mainAddress(mainAddress)
      .build();
  }
}