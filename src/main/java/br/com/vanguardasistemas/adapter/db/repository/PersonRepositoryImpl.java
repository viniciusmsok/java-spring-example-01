package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.vanguardasistemas.adapter.entity.AddressEntity;
import br.com.vanguardasistemas.adapter.entity.PersonEntity;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.repository.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

  private final PersonJpaRepository personJpaRepository;

  public PersonRepositoryImpl(PersonJpaRepository personJpaRepository) {
    this.personJpaRepository = personJpaRepository;
  }

  @Override
  public Person save(Person person) {
    AddressEntity addressEntity = null;
    if (person.getMainAddress() != null) {
      addressEntity = AddressEntity.builder()
        .addressDescription(person.getMainAddress().getAddressDescription())
        .addressNumber(person.getMainAddress().getAddressNumber())
        .neighborhoodName(person.getMainAddress().getNeighborhoodName())
        .cityName(person.getMainAddress().getCityName())
        .postalCode(person.getMainAddress().getPostalCode())
        .build();
    }

    PersonEntity personEntity = PersonEntity.builder()
      .personType(person.getPersonType())
      .nationalIdentifierCode(person.getNationalIdentifierCode())
      .regionalIdentifierCode(person.getRegionalIdentifierCode())
      .mainAddress(addressEntity)
      .build();

    return convertToDomain(personJpaRepository.save(personEntity));
  }

  @Override
  public Person findById(UUID id) {
    return personJpaRepository.findById(id)
      .map(this::convertToDomain)
      .orElse(null);
  }

  private Person convertToDomain(PersonEntity entity) {
    Address address = null;
    if (entity.getMainAddress() != null) {
      address = Address.builder()
        .addressId(entity.getMainAddress().getAddressId())
        .addressDescription(entity.getMainAddress().getAddressDescription())
        .addressNumber(entity.getMainAddress().getAddressNumber())
        .neighborhoodName(entity.getMainAddress().getNeighborhoodName())
        .cityName(entity.getMainAddress().getCityName())
        .postalCode(entity.getMainAddress().getPostalCode())
        .build();
    }

    return Person.builder()
      .personId(entity.getPersonId())
      .personType(entity.getPersonType())
      .nationalIdentifierCode(entity.getNationalIdentifierCode())
      .regionalIdentifierCode(entity.getRegionalIdentifierCode())
      .mainAddress(address)
      .build();
  }
}