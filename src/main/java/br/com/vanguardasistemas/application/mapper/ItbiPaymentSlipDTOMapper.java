package br.com.vanguardasistemas.application.mapper;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;

@Service
public class ItbiPaymentSlipDTOMapper {

  public ItbiPaymentSlip toDomain(ItbiPaymentSlipInsertInDTO itbiPaymentSlipInsertInDTO) {
    return ItbiPaymentSlip.builder()
      .taxPayer(createPersonFromId(itbiPaymentSlipInsertInDTO.taxPayerId()))
      .realEstate(createRealEstateFromId(itbiPaymentSlipInsertInDTO.realEstateId()))
      .notaryOffice(createNotaryOfficeFromId(itbiPaymentSlipInsertInDTO.notaryOfficeId()))
      .recordOffice(createPersonFromId(itbiPaymentSlipInsertInDTO.recordOfficeId()))
      .realStateGrantee(createPersonFromId(itbiPaymentSlipInsertInDTO.realStateGranteeId()))
      .realStateGrantor(createPersonFromId(itbiPaymentSlipInsertInDTO.realStateGrantorId()))
      .transactionType(itbiPaymentSlipInsertInDTO.transactionType())
      .officialRecordCode(itbiPaymentSlipInsertInDTO.officialRecordCode())
      .build();
  }

  private Person createPersonFromId(String id) {
    return Person.builder()
      .personId(UUID.fromString(id))
      .build();
  }

  private RealEstate createRealEstateFromId(String id) {
    return RealEstate.builder()
      .realEstateId(UUID.fromString(id))
      .build();
  }

  private NotaryOffice createNotaryOfficeFromId(String id) {
    return NotaryOffice.builder()
      .notaryOfficeId(UUID.fromString(id))
      .build();
  }
} 