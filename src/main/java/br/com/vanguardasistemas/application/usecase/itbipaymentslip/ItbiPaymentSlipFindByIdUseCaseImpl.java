package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;

@Service
public class ItbiPaymentSlipFindByIdUseCaseImpl implements ItbiPaymentSlipFindByIdUseCase {

  private final ItbiPaymentSlipRepository itbiPaymentSlipRepository;

  public ItbiPaymentSlipFindByIdUseCaseImpl(ItbiPaymentSlipRepository itbiPaymentSlipRepository) {
    this.itbiPaymentSlipRepository = itbiPaymentSlipRepository;
  }

  @Override
  public ItbiPaymentSlip findById(UUID id) {
    ItbiPaymentSlip itbiPaymentSlip = itbiPaymentSlipRepository.findById(id);
    if (itbiPaymentSlip == null) {
      throw new NotFoundException("ItbiPaymentSlip", id);
    }

    return itbiPaymentSlip;
  }
}