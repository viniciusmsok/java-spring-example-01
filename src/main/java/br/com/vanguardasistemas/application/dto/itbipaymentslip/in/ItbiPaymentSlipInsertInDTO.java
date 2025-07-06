package br.com.vanguardasistemas.application.dto.itbipaymentslip.in;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;

public record ItbiPaymentSlipInsertInDTO(
  @RequiredString(attributeName = "taxPayerId", max = 36)
  String taxPayerId,

  @RequiredString(attributeName = "realEstateId", max = 36)
  String realEstateId,

  @RequiredString(attributeName = "notaryOfficeId", max = 36)
  String notaryOfficeId,

  @RequiredString(attributeName = "recordOfficeId", max = 36)
  String recordOfficeId,

  @RequiredString(attributeName = "realStateGranteeId", max = 36)
  String realStateGranteeId,

  @RequiredString(attributeName = "realStateGrantorId", max = 36)
  String realStateGrantorId,

  @RequiredString(attributeName = "transactionType", max = 50)
  String transactionType,

  @OptionalString(attributeName = "officialRecordCode", max = 40)
  String officialRecordCode
) {} 