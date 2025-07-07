package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.application.usecase.realestate.RealEstateCreateUseCase;
import br.com.vanguardasistemas.application.usecase.realestate.RealEstateFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.port.api.RealStatesAPI;

@RestController
public class RealStatesRest implements RealStatesAPI {

  private final RealEstateCreateUseCase realEstateCreateUseCase;
  private final RealEstateFindByIdUseCase realEstateFindByIdUseCase;

  public RealStatesRest(
    RealEstateCreateUseCase realEstateCreateUseCase,
    RealEstateFindByIdUseCase realEstateFindByIdUseCase
  ) {
    this.realEstateCreateUseCase = realEstateCreateUseCase;
    this.realEstateFindByIdUseCase = realEstateFindByIdUseCase;
  }

  @Override
  public RealEstate createRealEstate(
    RealEstateInsertInDTO realEstateInDTO
  ) {
    return realEstateCreateUseCase.create(realEstateInDTO);
  }

  @Override
  public RealEstate findById(UUID id) {
    return realEstateFindByIdUseCase.findById(id);
  }
}