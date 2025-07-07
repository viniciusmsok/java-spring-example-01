package br.com.vanguardasistemas.application.dto.itbipaymentslip.in;

import java.util.UUID;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;

public record ItbiPaymentSlipInsertInDTO(
  @RequiredString(attributeName = "taxPayerId", max = 36)
  UUID taxPayerId,

  @RequiredString(attributeName = "realEstateId", max = 36)
  UUID realEstateId,

  @RequiredString(attributeName = "notaryOfficeId", max = 36)
  UUID notaryOfficeId,

  @RequiredString(attributeName = "recordOfficeId", max = 36)
  UUID recordOfficeId,

  @RequiredString(attributeName = "realStateGranteeId", max = 36)
  UUID realStateGranteeId,

  @RequiredString(attributeName = "realStateGrantorId", max = 36)
  UUID realStateGrantorId,

  @RequiredString(attributeName = "transactionType", max = 50)
  String transactionType,

  @OptionalString(attributeName = "officialRecordCode", max = 40)
  String officialRecordCode
) {}