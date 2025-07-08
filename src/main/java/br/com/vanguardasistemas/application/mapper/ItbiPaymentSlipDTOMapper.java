package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;

@Service
public class ItbiPaymentSlipDTOMapper {

  public ItbiPaymentSlip toDomain(
    ItbiPaymentSlipInsertInDTO itbiPaymentSlipInsertInDTO,
    Person taxPayer,
    RealEstate realEstate,
    NotaryOffice notaryOffice,
    NotaryOffice recordOffice,
    Person realEstateGrantee,
    Person realEstateGrantor
  ) {
    return ItbiPaymentSlip.builder()
      .taxPayer(taxPayer)
      .realEstate(realEstate)
      .notaryOffice(notaryOffice)
      .recordOffice(recordOffice)
      .realEstateGrantee(realEstateGrantee)
      .realEstateGrantor(realEstateGrantor)
      .transactionType(itbiPaymentSlipInsertInDTO.transactionType())
      .officialRecordCode(itbiPaymentSlipInsertInDTO.officialRecordCode())
      .build();
  }
} 