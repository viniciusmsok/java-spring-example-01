package br.com.vanguardasistemas.application.usecase.realestate;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.RealEstate;

public interface RealEstateCreateUseCase {
  RealEstate create(RealEstateInsertInDTO realEstateInsertInDTO);
} 