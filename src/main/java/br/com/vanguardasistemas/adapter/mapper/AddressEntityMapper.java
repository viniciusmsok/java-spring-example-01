package br.com.vanguardasistemas.adapter.mapper;

import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.adapter.entity.AddressEntity;
import br.com.vanguardasistemas.domain.model.Address;

@Component
public class AddressEntityMapper {
  public AddressEntity toEntity(Address address) {
    if (address == null) {
      return null;
    }

    return AddressEntity.builder()
      .addressId(address.getAddressId())
      .addressDescription(address.getAddressDescription())
      .addressNumber(address.getAddressNumber())
      .neighborhoodName(address.getNeighborhoodName())
      .cityName(address.getCityName())
      .postalCode(address.getPostalCode())
      .build();
  }

  public Address toDomain(AddressEntity entity) {
    if (entity == null) {
      return null;
    }

    return Address.builder()
      .addressId(entity.getAddressId())
      .addressDescription(entity.getAddressDescription())
      .addressNumber(entity.getAddressNumber())
      .neighborhoodName(entity.getNeighborhoodName())
      .cityName(entity.getCityName())
      .postalCode(entity.getPostalCode())
      .build();
  }
} 