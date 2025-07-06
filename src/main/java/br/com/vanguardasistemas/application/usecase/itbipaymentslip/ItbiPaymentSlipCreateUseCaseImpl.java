package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanguardasistemas.application.dto.itbipaymentslip.in.ItbiPaymentSlipInsertInDTO;
import br.com.vanguardasistemas.application.mapper.ItbiPaymentSlipDTOMapper;
import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;

@Service
public class ItbiPaymentSlipCreateUseCaseImpl implements ItbiPaymentSlipCreateUseCase {

  private final ItbiPaymentSlipRepository itbiPaymentSlipRepository;
  private final ItbiPaymentSlipDTOMapper itbiPaymentSlipDTOMapper;

  public ItbiPaymentSlipCreateUseCaseImpl(
    ItbiPaymentSlipRepository itbiPaymentSlipRepository,
    ItbiPaymentSlipDTOMapper itbiPaymentSlipDTOMapper
  ) {
    this.itbiPaymentSlipRepository = itbiPaymentSlipRepository;
    this.itbiPaymentSlipDTOMapper = itbiPaymentSlipDTOMapper;
  }

  @Override
  @Transactional
  public ItbiPaymentSlip create(ItbiPaymentSlipInsertInDTO itbiPaymentSlipInsertInDTO) {
    ItbiPaymentSlip itbiPaymentSlip = itbiPaymentSlipDTOMapper.toDomain(itbiPaymentSlipInsertInDTO);
    return itbiPaymentSlipRepository.save(itbiPaymentSlip);
  }
}