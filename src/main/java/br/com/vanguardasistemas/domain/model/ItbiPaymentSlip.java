package br.com.vanguardasistemas.domain.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItbiPaymentSlip {

  private UUID itbiPaymentSlipId;
  private Person taxPayer;
  private RealEstate realEstate;
  private NotaryOffice notaryOffice;
  private NotaryOffice recordOffice;
  private Person realEstateGrantee;
  private Person realEstateGrantor;
  private String transactionType;
  private String officialRecordCode;
}