package br.com.vanguardasistemas.domain.repository;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.RealEstate;

public interface RealEstateRepository {
  RealEstate save(RealEstate realEstate);
  RealEstate findById(UUID id);
} 