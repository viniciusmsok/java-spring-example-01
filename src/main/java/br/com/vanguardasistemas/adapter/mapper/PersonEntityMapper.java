package br.com.vanguardasistemas.adapter.mapper;

import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.adapter.entity.AddressEntity;
import br.com.vanguardasistemas.adapter.entity.PersonEntity;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;

@Component
public class PersonEntityMapper {
  private final AddressEntityMapper addressEntityMapper;

  public PersonEntityMapper(AddressEntityMapper addressEntityMapper) {
    this.addressEntityMapper = addressEntityMapper;
  }

  public PersonEntity toEntity(Person person) {
    AddressEntity addressEntity = addressEntityMapper.toEntity(person.getMainAddress());

    return PersonEntity.builder()
      .personId(person.getPersonId())
      .personType(person.getPersonType())
      .nationalIdentifierCode(person.getNationalIdentifierCode())
      .regionalIdentifierCode(person.getRegionalIdentifierCode())
      .mainAddress(addressEntity)
      .build();
  }

  public Person toDomain(PersonEntity entity) {
    Address address = addressEntityMapper.toDomain(entity.getMainAddress());

    return Person.builder()
      .personId(entity.getPersonId())
      .personType(entity.getPersonType())
      .nationalIdentifierCode(entity.getNationalIdentifierCode())
      .regionalIdentifierCode(entity.getRegionalIdentifierCode())
      .mainAddress(address)
      .build();
  }
} 