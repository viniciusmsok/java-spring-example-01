package br.com.vanguardasistemas.application.dto.itbipaymentslip.in;

import java.util.UUID;

import br.com.vanguardasistemas.adapter.rest.validation.OptionalString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredString;
import br.com.vanguardasistemas.adapter.rest.validation.RequiredUUID;

public record ItbiPaymentSlipInsertInDTO(
  @RequiredUUID(attributeName = "taxPayerId")
  UUID taxPayerId,

  @RequiredUUID(attributeName = "realEstateId")
  UUID realEstateId,

  @RequiredUUID(attributeName = "notaryOfficeId")
  UUID notaryOfficeId,

  @RequiredUUID(attributeName = "recordOfficeId")
  UUID recordOfficeId,

  @RequiredUUID(attributeName = "realEstateGranteeId")
  UUID realEstateGranteeId,

  @RequiredUUID(attributeName = "realEstateGrantorId")
  UUID realEstateGrantorId,

  @RequiredString(attributeName = "transactionType", max = 50)
  String transactionType,

  @OptionalString(attributeName = "officialRecordCode", max = 40)
  String officialRecordCode
) {}