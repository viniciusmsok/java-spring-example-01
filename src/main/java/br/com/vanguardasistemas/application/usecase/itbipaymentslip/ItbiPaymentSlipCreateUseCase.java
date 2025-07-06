package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;

public interface ItbiPaymentSlipCreateUseCase {
  ItbiPaymentSlip create(ItbiPaymentSlipInsertInDTO itbiPaymentSlipInsertInDTO);
}