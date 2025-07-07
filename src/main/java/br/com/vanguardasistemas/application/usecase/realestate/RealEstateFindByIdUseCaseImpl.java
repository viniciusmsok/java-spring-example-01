package br.com.vanguardasistemas.application.usecase.realestate;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.domain.repository.RealEstateRepository;

@Service
public class RealEstateFindByIdUseCaseImpl implements RealEstateFindByIdUseCase {

  private final RealEstateRepository realEstateRepository;

  public RealEstateFindByIdUseCaseImpl(RealEstateRepository realEstateRepository) {
    this.realEstateRepository = realEstateRepository;
  }

  @Override
  public RealEstate findById(UUID id) {
    RealEstate realEstate = realEstateRepository.findById(id);
    if (realEstate == null) {
      throw new NotFoundException("RealEstate", id);
    }

    return realEstate;
  }
}