package br.com.vanguardasistemas.application.mapper;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.mocks.NotaryOfficeMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class NotaryOfficeDTOMapperTest {

  private final NotaryOfficeDTOMapper mapper = new NotaryOfficeDTOMapper();

  @Test
  void deveMapearParaDomainCorretamente() {
    NotaryOfficeInsertInDTO dto = new NotaryOfficeInsertInDTO(
      NotaryOfficeMocks.NAME,
      NotaryOfficeMocks.CITY_NAME,
      NotaryOfficeMocks.STATE_NAME
    );

    NotaryOffice result = mapper.toDomain(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(NotaryOfficeMocks.NAME, result.getName());
    Assertions.assertEquals(NotaryOfficeMocks.CITY_NAME, result.getCityName());
    Assertions.assertEquals(NotaryOfficeMocks.STATE_NAME, result.getStateName());
  }

  @Test
  void deveRetornarNullQuandoDTOForNull() {
    NotaryOffice result = mapper.toDomain(null);

    Assertions.assertNull(result);
  }
} 