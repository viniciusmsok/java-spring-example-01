package br.com.vanguardasistemas.application.usecase.itbipaymentslip;

import br.com.vanguardasistemas.domain.model.ItbiPaymentSlip;
import br.com.vanguardasistemas.domain.repository.ItbiPaymentSlipRepository;
import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.mocks.ItbiPaymentSlipMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.util.UUID;

class ItbiPaymentSlipFindByIdUseCaseImplTest {

  @Test
  void deveRetornarItbiPaymentSlipQuandoEncontrado() {
    ItbiPaymentSlipRepository itbiPaymentSlipRepository = Mockito.mock(
      ItbiPaymentSlipRepository.class
    );

    ItbiPaymentSlipFindByIdUseCaseImpl useCase = new ItbiPaymentSlipFindByIdUseCaseImpl(
      itbiPaymentSlipRepository
    );

    ItbiPaymentSlip itbiPaymentSlip = ItbiPaymentSlipMocks.defaultItbiPaymentSlip(
      null,
      null,
      null,
      null,
      null,
      null
    );

    UUID id = itbiPaymentSlip.getItbiPaymentSlipId();

    Mockito.when(itbiPaymentSlipRepository.findById(id)).thenReturn(itbiPaymentSlip);

    ItbiPaymentSlip result = useCase.findById(id);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(itbiPaymentSlip, result);
    Mockito.verify(itbiPaymentSlipRepository).findById(id);
  }

  @Test
  void deveLancarExcecaoQuandoNaoEncontrado() {
    ItbiPaymentSlipRepository itbiPaymentSlipRepository = Mockito.mock(
      ItbiPaymentSlipRepository.class
    );

    ItbiPaymentSlipFindByIdUseCaseImpl useCase = new ItbiPaymentSlipFindByIdUseCaseImpl(
      itbiPaymentSlipRepository
    );

    UUID id = ItbiPaymentSlipMocks.ITBI_PAYMENT_SLIP_ID;
    Mockito.when(itbiPaymentSlipRepository.findById(id)).thenReturn(null);

    Assertions.assertThrows(
      NotFoundException.class,
      () -> useCase.findById(id)
    );

    Mockito.verify(itbiPaymentSlipRepository).findById(id);
  }
}