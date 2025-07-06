package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.vanguardasistemas.adapter.entity.AddressEntity;
import br.com.vanguardasistemas.adapter.entity.RealEstateEntity;
import br.com.vanguardasistemas.domain.model.Address;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;

@Repository
public class RealEstateRepositoryImpl implements RealEstateRepository {
    private final RealEstateJpaRepository realEstateJpaRepository;

    public RealEstateRepositoryImpl(RealEstateJpaRepository realEstateJpaRepository) {
      this.realEstateJpaRepository = realEstateJpaRepository;
    }

    @Override
    public RealEstate save(RealEstate realEstate) {
      AddressEntity addressEntity = null;
      if (realEstate.getAddress() != null) {
          addressEntity = AddressEntity.builder()
            .addressDescription(realEstate.getAddress().getAddressDescription())
            .addressNumber(realEstate.getAddress().getAddressNumber())
            .neighborhoodName(realEstate.getAddress().getNeighborhoodName())
            .cityName(realEstate.getAddress().getCityName())
            .postalCode(realEstate.getAddress().getPostalCode())
            .build();
      }

      RealEstateEntity entity = RealEstateEntity.builder()
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

      RealEstateEntity saved = realEstateJpaRepository.save(entity);

      return convertToDomain(saved);
    }

    @Override
    public RealEstate findById(UUID id) {
      return realEstateJpaRepository.findById(id)
        .map(this::convertToDomain)
        .orElse(null);
    }

    private RealEstate convertToDomain(RealEstateEntity entity) {
      Address address = null;
      if (entity.getAddress() != null) {
        address = Address.builder()
          .addressId(entity.getAddress().getAddressId())
          .addressDescription(entity.getAddress().getAddressDescription())
          .addressNumber(entity.getAddress().getAddressNumber())
          .neighborhoodName(entity.getAddress().getNeighborhoodName())
          .cityName(entity.getAddress().getCityName())
          .postalCode(entity.getAddress().getPostalCode())
          .build();
      }

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