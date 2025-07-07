package br.com.vanguardasistemas.port.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import jakarta.validation.Valid;

@RequestMapping("/itbi-payment-slips")
public interface ItbiPaymentSlipsAPI {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ItbiPaymentSlip createItbiPaymentSlip(
    @Valid @RequestBody ItbiPaymentSlipInsertInDTO itbiPaymentSlipInDTO
  );

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  ItbiPaymentSlip findById(@Valid @PathVariable UUID id);
}