package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.application.usecase.itbipaymentslip.ItbiPaymentSlipCreateUseCase;
import br.com.vanguardasistemas.application.usecase.itbipaymentslip.ItbiPaymentSlipFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.port.api.ItbiPaymentSlipsAPI;

@RestController
public class ItbiPaymentSlipsRest implements ItbiPaymentSlipsAPI {

  private final ItbiPaymentSlipCreateUseCase itbiPaymentSlipCreateUseCase;
  private final ItbiPaymentSlipFindByIdUseCase itbiPaymentSlipFindByIdUseCase;

  public ItbiPaymentSlipsRest(
    ItbiPaymentSlipCreateUseCase itbiPaymentSlipCreateUseCase,
    ItbiPaymentSlipFindByIdUseCase itbiPaymentSlipFindByIdUseCase
  ) {
    this.itbiPaymentSlipCreateUseCase = itbiPaymentSlipCreateUseCase;
    this.itbiPaymentSlipFindByIdUseCase = itbiPaymentSlipFindByIdUseCase;
  }

  @Override
  public ItbiPaymentSlip createItbiPaymentSlip(
    ItbiPaymentSlipInsertInDTO itbiPaymentSlipInDTO
  ) {
    return itbiPaymentSlipCreateUseCase.create(itbiPaymentSlipInDTO);
  }

  @Override
  public ItbiPaymentSlip findById(UUID id) {
    return itbiPaymentSlipFindByIdUseCase.findById(id);
  }
}