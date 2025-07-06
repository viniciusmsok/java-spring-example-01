package br.com.vanguardasistemas.application.usecase.realestate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.application.mapper.RealEstateDTOMapper;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;

@Service
public class RealEstateCreateUseCaseImpl implements RealEstateCreateUseCase {
  private final RealEstateRepository realEstateRepository;
  private final RealEstateDTOMapper realEstateDTOMapper;

  public RealEstateCreateUseCaseImpl(
    RealEstateRepository realEstateRepository,
    RealEstateDTOMapper realEstateDTOMapper
  ) {
    this.realEstateRepository = realEstateRepository;
    this.realEstateDTOMapper = realEstateDTOMapper;
  }

  @Override
  @Transactional
  public RealEstate create(RealEstateInsertInDTO realEstateInsertInDTO) {
    RealEstate realEstate = realEstateDTOMapper.toDomain(realEstateInsertInDTO);
    return realEstateRepository.save(realEstate);
  }
} 