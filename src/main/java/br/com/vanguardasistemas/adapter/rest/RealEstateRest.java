package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.application.usecase.realestate.RealEstateCreateUseCase;
import br.com.vanguardasistemas.application.usecase.realestate.RealEstateFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.RealEstate;
import br.com.vanguardasistemas.port.api.RealEstateAPI;
import jakarta.validation.Valid;

@RestController
public class RealEstateRest implements RealEstateAPI {

  private final RealEstateCreateUseCase realEstateCreateUseCase;
  private final RealEstateFindByIdUseCase realEstateFindByIdUseCase;

  public RealEstateRest(
    RealEstateCreateUseCase realEstateCreateUseCase,
    RealEstateFindByIdUseCase realEstateFindByIdUseCase
  ) {
    this.realEstateCreateUseCase = realEstateCreateUseCase;
    this.realEstateFindByIdUseCase = realEstateFindByIdUseCase;
  }

  @Override
  public RealEstate createRealEstate(
    @Valid @RequestBody RealEstateInsertInDTO realEstateInsertInDTO
  ) {
    return realEstateCreateUseCase.create(realEstateInsertInDTO);
  }

  @Override
  public RealEstate findById(@PathVariable UUID id) {
    return realEstateFindByIdUseCase.findById(id);
  }
}