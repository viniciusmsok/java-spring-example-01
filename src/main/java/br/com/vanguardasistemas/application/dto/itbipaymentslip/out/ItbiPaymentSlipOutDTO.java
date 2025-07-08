package br.com.vanguardasistemas.application.dto.itbipaymentslip.out;

import java.util.UUID;

import br.com.vanguardasistemas.application.dto.notaryoffice.out.NotaryOfficeOutDTO;
import br.com.vanguardasistemas.application.dto.person.out.PersonOutDTO;
import br.com.vanguardasistemas.application.dto.realestate.out.RealEstateOutDTO;

public record ItbiPaymentSlipOutDTO(
  UUID itbiPaymentSlipId,
  PersonOutDTO taxPayer,
  RealEstateOutDTO realEstate,
  NotaryOfficeOutDTO notaryOffice,
  PersonOutDTO recordOffice,
  PersonOutDTO realEstateGrantee,
  PersonOutDTO realEstateGrantor,
  String transactionType,
  String officialRecordCode
) {} 