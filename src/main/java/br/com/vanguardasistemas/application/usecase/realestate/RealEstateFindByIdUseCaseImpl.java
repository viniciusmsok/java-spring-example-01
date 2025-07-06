package br.com.vanguardasistemas.application.usecase.realestate;

import java.util.UUID;

import org.springframework.stereotype.Service;

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
    return realEstateRepository.findById(id);
  }
} 