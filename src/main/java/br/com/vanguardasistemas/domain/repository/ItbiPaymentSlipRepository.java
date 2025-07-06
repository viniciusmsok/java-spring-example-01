package br.com.vanguardasistemas.domain.repository;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;

public interface ItbiPaymentSlipRepository {
  ItbiPaymentSlip save(ItbiPaymentSlip itbiPaymentSlip);
  ItbiPaymentSlip findById(UUID id);
} 