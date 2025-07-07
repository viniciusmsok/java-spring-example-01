package br.com.vanguardasistemas.adapter.mapper;

import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.adapter.entity.ItbiPaymentSlipEntity;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;

@Component
public class ItbiPaymentSlipEntityMapper {
  private final PersonEntityMapper personEntityMapper;
  private final RealEstateEntityMapper realEstateEntityMapper;
  private final NotaryOfficeEntityMapper notaryOfficeEntityMapper;

  public ItbiPaymentSlipEntityMapper(
    PersonEntityMapper personEntityMapper,
    RealEstateEntityMapper realEstateEntityMapper,
    NotaryOfficeEntityMapper notaryOfficeEntityMapper
  ) {
    this.personEntityMapper = personEntityMapper;
    this.realEstateEntityMapper = realEstateEntityMapper;
    this.notaryOfficeEntityMapper = notaryOfficeEntityMapper;
  }

  public ItbiPaymentSlipEntity toEntity(ItbiPaymentSlip domain) {
    if (domain == null) {
      return null;
    }

    return ItbiPaymentSlipEntity.builder()
      .itbiPaymentSlipId(domain.getItbiPaymentSlipId())
      .taxPayer(personEntityMapper.toEntity(domain.getTaxPayer()))
      .realEstate(realEstateEntityMapper.toEntity(domain.getRealEstate()))
      .notaryOffice(notaryOfficeEntityMapper.toEntity(domain.getNotaryOffice()))
      .recordOffice(notaryOfficeEntityMapper.toEntity(domain.getRecordOffice()))
      .realStateGrantee(personEntityMapper.toEntity(domain.getRealStateGrantee()))
      .realStateGrantor(personEntityMapper.toEntity(domain.getRealStateGrantor()))
      .transactionType(domain.getTransactionType())
      .officialRecordCode(domain.getOfficialRecordCode())
      .build();
  }

  public ItbiPaymentSlip toDomain(ItbiPaymentSlipEntity entity) {
    if (entity == null) {
      return null;
    }

    return ItbiPaymentSlip.builder()
      .itbiPaymentSlipId(entity.getItbiPaymentSlipId())
      .taxPayer(personEntityMapper.toDomain(entity.getTaxPayer()))
      .realEstate(realEstateEntityMapper.toDomain(entity.getRealEstate()))
      .notaryOffice(notaryOfficeEntityMapper.toDomain(entity.getNotaryOffice()))
      .recordOffice(notaryOfficeEntityMapper.toDomain(entity.getRecordOffice()))
      .realStateGrantee(personEntityMapper.toDomain(entity.getRealStateGrantee()))
      .realStateGrantor(personEntityMapper.toDomain(entity.getRealStateGrantor()))
      .transactionType(entity.getTransactionType())
      .officialRecordCode(entity.getOfficialRecordCode())
      .build();
  }
} 