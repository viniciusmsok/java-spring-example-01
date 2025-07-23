package br.com.vanguardasistemas.application.usecase.realestate;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;
import br.com.vanguardasistemas.application.mapper.RealEstateDTOMapper;
import br.com.vanguardasistemas.mocks.RealEstateMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

class RealEstateCreateUseCaseImplTest {

  @Test
  void deveCriarImovelComSucesso() {
    RealEstateRepository realEstateRepository = Mockito.mock(RealEstateRepository.class);
    RealEstateDTOMapper realEstateDTOMapper = Mockito.mock(RealEstateDTOMapper.class);

    RealEstateCreateUseCaseImpl useCase = new RealEstateCreateUseCaseImpl(
      realEstateRepository,
      realEstateDTOMapper
    );

    RealEstateInsertInDTO dto = RealEstateMocks.defaultRealEstateInsertInDTO(null);
    RealEstate realEstate = RealEstateMocks.defaultRealEstate(null);

    Mockito.when(realEstateDTOMapper.toDomain(dto)).thenReturn(realEstate);
    Mockito.when(realEstateRepository.save(realEstate)).thenReturn(realEstate);

    RealEstate result = useCase.create(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(realEstate, result);
    Mockito.verify(realEstateDTOMapper).toDomain(dto);

    Mockito.verify(realEstateRepository).save(realEstate);
  }
} 