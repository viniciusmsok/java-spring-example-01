package br.com.vanguardasistemas.application.usecase.notaryoffice;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;
import br.com.vanguardasistemas.application.mapper.NotaryOfficeDTOMapper;
import br.com.vanguardasistemas.mocks.NotaryOfficeMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

class NotaryOfficeCreateUseCaseImplTest {

  @Test
  void deveCriarCartorioComSucesso() {
    NotaryOfficeRepository notaryOfficeRepository = Mockito.mock(
      NotaryOfficeRepository.class
    );

    NotaryOfficeDTOMapper notaryOfficeDTOMapper = Mockito.mock(
      NotaryOfficeDTOMapper.class
    );

    NotaryOfficeCreateUseCaseImpl useCase = new NotaryOfficeCreateUseCaseImpl(
      notaryOfficeRepository,
      notaryOfficeDTOMapper
    );

    NotaryOfficeInsertInDTO dto = new NotaryOfficeInsertInDTO(
      NotaryOfficeMocks.NAME,
      NotaryOfficeMocks.CITY_NAME,
      NotaryOfficeMocks.STATE_NAME
    );

    NotaryOffice notaryOffice = NotaryOfficeMocks.defaultNotaryOffice();

    Mockito.when(notaryOfficeDTOMapper.toDomain(dto)).thenReturn(notaryOffice);

    Mockito.when(notaryOfficeRepository.save(notaryOffice)).thenReturn(notaryOffice);

    NotaryOffice result = useCase.create(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(notaryOffice, result);
    Mockito.verify(notaryOfficeDTOMapper).toDomain(dto);
    Mockito.verify(notaryOfficeRepository).save(notaryOffice);
  }
}