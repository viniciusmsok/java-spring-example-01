package br.com.vanguardasistemas.adapter.mapper;

import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.adapter.entity.AddressEntity;
import br.com.vanguardasistemas.adapter.entity.RealEstateEntity;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;

@Component
public class RealEstateEntityMapper {
  private final AddressEntityMapper addressEntityMapper;

  public RealEstateEntityMapper(AddressEntityMapper addressEntityMapper) {
    this.addressEntityMapper = addressEntityMapper;
  }

  public RealEstateEntity toEntity(RealEstate realEstate) {
    AddressEntity addressEntity = addressEntityMapper.toEntity(realEstate.getAddress());

    return RealEstateEntity.builder()
      .realEstateId(realEstate.getRealEstateId())
      .propertyType(realEstate.getPropertyType())
      .propertyName(realEstate.getPropertyName())
      .realEstateDescription(realEstate.getDescription())
      .totalAreaDescription(realEstate.getTotalAreaDescription())
      .builtAreaDescription(realEstate.getBuiltAreaDescription())
      .idealArea(realEstate.getIdealArea())
      .propertyRegistrationNumber(realEstate.getPropertyRegistrationNumber())
      .additionalNotes(realEstate.getAdditionalNotes())
      .address(addressEntity)
      .build();
  }

  public RealEstate toDomain(RealEstateEntity entity) {
    Address address = addressEntityMapper.toDomain(entity.getAddress());

    return RealEstate.builder()
      .realEstateId(entity.getRealEstateId())
      .propertyType(entity.getPropertyType())
      .propertyName(entity.getPropertyName())
      .description(entity.getRealEstateDescription())
      .totalAreaDescription(entity.getTotalAreaDescription())
      .builtAreaDescription(entity.getBuiltAreaDescription())
      .idealArea(entity.getIdealArea())
      .propertyRegistrationNumber(entity.getPropertyRegistrationNumber())
      .additionalNotes(entity.getAdditionalNotes())
      .address(address)
      .build();
  }
}