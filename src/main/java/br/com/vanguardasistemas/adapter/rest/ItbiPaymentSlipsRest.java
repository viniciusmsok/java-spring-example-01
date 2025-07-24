package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.application.usecase.itbipaymentslip.ItbiPaymentSlipCreateUseCase;
import br.com.vanguardasistemas.application.usecase.itbipaymentslip.ItbiPaymentSlipFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.port.api.ItbiPaymentSlipsAPI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "ITBI", description = "Operations related to ITBI payment slips")
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
  @Operation(
    summary = "Create a new ITBI payment slip",
    description = "Creates an ITBI payment slip from the data provided in the request body."
  )
  public ItbiPaymentSlip createItbiPaymentSlip(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Data for ITBI payment slip creation", required = true)
    ItbiPaymentSlipInsertInDTO itbiPaymentSlipInDTO
  ) {
    return itbiPaymentSlipCreateUseCase.create(itbiPaymentSlipInDTO);
  }

  @Override
  @Operation(
    summary = "Find ITBI payment slip by ID",
    description = "Returns an ITBI payment slip by its UUID."
  )
  public ItbiPaymentSlip findById(
    @Parameter(description = "ITBI payment slip UUID", required = true)
    UUID itbiPaymentSlipId
  ) {
    return itbiPaymentSlipFindByIdUseCase.findById(itbiPaymentSlipId);
  }
}