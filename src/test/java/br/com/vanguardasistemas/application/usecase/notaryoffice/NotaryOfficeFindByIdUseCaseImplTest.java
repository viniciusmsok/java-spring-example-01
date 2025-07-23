package br.com.vanguardasistemas.application.usecase.notaryoffice;

import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;
import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.mocks.NotaryOfficeMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.util.UUID;

class NotaryOfficeFindByIdUseCaseImplTest {

  @Test
  void deveRetornarCartorioQuandoEncontrado() {
    NotaryOfficeRepository notaryOfficeRepository = Mockito.mock(
      NotaryOfficeRepository.class
    );

    NotaryOfficeFindByIdUseCaseImpl useCase = new NotaryOfficeFindByIdUseCaseImpl(
      notaryOfficeRepository
    );

    NotaryOffice notaryOffice = NotaryOfficeMocks.defaultNotaryOffice();
    UUID id = notaryOffice.getNotaryOfficeId();

    Mockito.when(notaryOfficeRepository.findById(id)).thenReturn(notaryOffice);

    NotaryOffice result = useCase.findById(id);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(notaryOffice, result);

    Mockito.verify(notaryOfficeRepository).findById(id);
  }

  @Test
  void deveLancarExcecaoQuandoNaoEncontrado() {
    NotaryOfficeRepository notaryOfficeRepository = Mockito.mock(
      NotaryOfficeRepository.class
    );

    NotaryOfficeFindByIdUseCaseImpl useCase = new NotaryOfficeFindByIdUseCaseImpl(
      notaryOfficeRepository
    );

    UUID id = NotaryOfficeMocks.NOTARY_OFFICE_ID;
    Mockito.when(notaryOfficeRepository.findById(id)).thenReturn(null);

    Assertions.assertThrows(
      NotFoundException.class,
      () -> useCase.findById(id)
    );

    Mockito.verify(notaryOfficeRepository).findById(id);
  }
}