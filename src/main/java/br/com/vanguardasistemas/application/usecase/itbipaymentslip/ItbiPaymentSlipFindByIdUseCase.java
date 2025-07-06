package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;

public interface ItbiPaymentSlipFindByIdUseCase {
  ItbiPaymentSlip findById(UUID id);
} 