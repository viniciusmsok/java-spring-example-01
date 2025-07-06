package br.com.vanguardasistemas.application.usecase.realestate;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.RealEstate;

public interface RealEstateFindByIdUseCase {
  RealEstate findById(UUID id);
} 