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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Real Estate", description = "Operations related to real estate")
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
  @Operation(
    summary = "Create a new real estate",
    description = "Creates a real estate from the data provided in the request body."
  )
  public RealEstate createRealEstate(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Data for real estate creation", required = true)
    @Valid @RequestBody RealEstateInsertInDTO realEstateInsertInDTO
  ) {
    return realEstateCreateUseCase.create(realEstateInsertInDTO);
  }

  @Override
  @Operation(
    summary = "Find real estate by ID",
    description = "Returns a real estate by its UUID."
  )
  public RealEstate findById(
    @Parameter(description = "Real estate UUID", required = true)
    @PathVariable UUID realEstateId
  ) {
    return realEstateFindByIdUseCase.findById(realEstateId);
  }
}