package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.vanguardasistemas.adapter.entity.ItbiPaymentSlipEntity;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;

@Repository
public class ItbiPaymentSlipRepositoryImpl implements ItbiPaymentSlipRepository {

  private final ItbiPaymentSlipJpaRepository itbiPaymentSlipJpaRepository;

  public ItbiPaymentSlipRepositoryImpl(ItbiPaymentSlipJpaRepository itbiPaymentSlipJpaRepository) {
    this.itbiPaymentSlipJpaRepository = itbiPaymentSlipJpaRepository;
  }

  @Override
  public ItbiPaymentSlip save(ItbiPaymentSlip itbiPaymentSlip) {
    ItbiPaymentSlipEntity entity = ItbiPaymentSlipEntity.builder()
      .itbiPaymentSlipId(itbiPaymentSlip.getItbiPaymentSlipId())
      .taxPayer(convertPersonToEntity(itbiPaymentSlip.getTaxPayer()))
      .realEstate(convertRealEstateToEntity(itbiPaymentSlip.getRealEstate()))
      .notaryOffice(convertNotaryOfficeToEntity(itbiPaymentSlip.getNotaryOffice()))
      .recordOffice(convertPersonToEntity(itbiPaymentSlip.getRecordOffice()))
      .realStateGrantee(convertPersonToEntity(itbiPaymentSlip.getRealStateGrantee()))
      .realStateGrantor(convertPersonToEntity(itbiPaymentSlip.getRealStateGrantor()))
      .transactionType(itbiPaymentSlip.getTransactionType())
      .officialRecordCode(itbiPaymentSlip.getOfficialRecordCode())
      .build();

    ItbiPaymentSlipEntity saved = itbiPaymentSlipJpaRepository.save(entity);
    return convertToDomain(saved);
  }

  @Override
  public ItbiPaymentSlip findById(UUID id) {
    return itbiPaymentSlipJpaRepository.findById(id)
      .map(this::convertToDomain)
      .orElse(null);
  }

  private ItbiPaymentSlip convertToDomain(ItbiPaymentSlipEntity entity) {
    return ItbiPaymentSlip.builder()
      .itbiPaymentSlipId(entity.getItbiPaymentSlipId())
      .taxPayer(convertPersonToDomain(entity.getTaxPayer()))
      .realEstate(convertRealEstateToDomain(entity.getRealEstate()))
      .notaryOffice(convertNotaryOfficeToDomain(entity.getNotaryOffice()))
      .recordOffice(convertPersonToDomain(entity.getRecordOffice()))
      .realStateGrantee(convertPersonToDomain(entity.getRealStateGrantee()))
      .realStateGrantor(convertPersonToDomain(entity.getRealStateGrantor()))
      .transactionType(entity.getTransactionType())
      .officialRecordCode(entity.getOfficialRecordCode())
      .build();
  }

  // Métodos auxiliares para conversão - implementação simplificada
  private br.com.vanguardasistemas.adapter.entity.PersonEntity convertPersonToEntity(br.com.vanguardasistemas.domain.model.Person person) {
    if (person == null) {
      return null;
    }
    // Implementação simplificada - em um cenário real, você buscaria a entidade existente
    return br.com.vanguardasistemas.adapter.entity.PersonEntity.builder()
      .personId(person.getPersonId())
      .build();
  }

  private br.com.vanguardasistemas.adapter.entity.RealEstateEntity convertRealEstateToEntity(br.com.vanguardasistemas.domain.model.RealEstate realEstate) {
    if (realEstate == null) {
      return null;
    }
    return br.com.vanguardasistemas.adapter.entity.RealEstateEntity.builder()
      .realEstateId(realEstate.getRealEstateId())
      .build();
  }

  private br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity convertNotaryOfficeToEntity(br.com.vanguardasistemas.domain.model.NotaryOffice notaryOffice) {
    if (notaryOffice == null) {
      return null;
    }
    return br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity.builder()
      .notaryOfficeId(notaryOffice.getNotaryOfficeId())
      .build();
  }

  private br.com.vanguardasistemas.domain.model.Person convertPersonToDomain(br.com.vanguardasistemas.adapter.entity.PersonEntity entity) {
    if (entity == null) {
      return null;
    }
    return br.com.vanguardasistemas.domain.model.Person.builder()
      .personId(entity.getPersonId())
      .build();
  }

  private br.com.vanguardasistemas.domain.model.RealEstate convertRealEstateToDomain(br.com.vanguardasistemas.adapter.entity.RealEstateEntity entity) {
    if (entity == null) {
      return null;
    }
    return br.com.vanguardasistemas.domain.model.RealEstate.builder()
      .realEstateId(entity.getRealEstateId())
      .build();
  }

  private br.com.vanguardasistemas.domain.model.NotaryOffice convertNotaryOfficeToDomain(br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity entity) {
    if (entity == null) {
      return null;
    }
    return br.com.vanguardasistemas.domain.model.NotaryOffice.builder()
      .notaryOfficeId(entity.getNotaryOfficeId())
      .build();
  }
} 