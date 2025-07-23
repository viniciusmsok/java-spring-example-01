package br.com.vanguardasistemas.mocks;

import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import java.util.UUID;

public class ItbiPaymentSlipMocks {
  public static final UUID ITBI_PAYMENT_SLIP_ID = UUID.fromString("77777777-7777-7777-7777-777777777777");
  public static final String TRANSACTION_TYPE = "VENDA";
  public static final String OFFICIAL_RECORD_CODE = "REG123";

  public static ItbiPaymentSlip defaultItbiPaymentSlip(
    Person taxPayer,
    RealEstate realEstate,
    NotaryOffice notaryOffice,
    NotaryOffice recordOffice,
    Person realEstateGrantee,
    Person realEstateGrantor
  ) {
    return ItbiPaymentSlip.builder()
      .itbiPaymentSlipId(ITBI_PAYMENT_SLIP_ID)
      .taxPayer(taxPayer)
      .realEstate(realEstate)
      .notaryOffice(notaryOffice)
      .recordOffice(recordOffice)
      .realEstateGrantee(realEstateGrantee)
      .realEstateGrantor(realEstateGrantor)
      .transactionType(TRANSACTION_TYPE)
      .officialRecordCode(OFFICIAL_RECORD_CODE)
      .build();
  }
} 