package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.application.usecase.notaryoffice.NotaryOfficeCreateUseCase;
import br.com.vanguardasistemas.application.usecase.notaryoffice.NotaryOfficeFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.port.api.NotaryOfficesAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Notary Offices", description = "Operations related to notary offices")
@RestController
public class NotaryOfficesRest implements NotaryOfficesAPI {

  private final NotaryOfficeCreateUseCase notaryOfficeCreateUseCase;
  private final NotaryOfficeFindByIdUseCase notaryOfficeFindByIdUseCase;

  public NotaryOfficesRest(
    NotaryOfficeCreateUseCase notaryOfficeCreateUseCase,
    NotaryOfficeFindByIdUseCase notaryOfficeFindByIdUseCase
  ) {
    this.notaryOfficeCreateUseCase = notaryOfficeCreateUseCase;
    this.notaryOfficeFindByIdUseCase = notaryOfficeFindByIdUseCase;
  }

  @Override
  @Operation(
    summary = "Create a new notary office",
    description = "Creates a notary office from the data provided in the request body."
  )
  public NotaryOffice createNotaryOffice(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Data for notary office creation", required = true)
    NotaryOfficeInsertInDTO notaryOfficeInsertInDTO
  ) {
    return notaryOfficeCreateUseCase.create(notaryOfficeInsertInDTO);
  }

  @Override
  @Operation(
    summary = "Find notary office by ID",
    description = "Returns a notary office by its UUID."
  )
  public NotaryOffice findById(
    @Parameter(description = "Notary office UUID", required = true)
    UUID notaryOfficeId
  ) {
    return notaryOfficeFindByIdUseCase.findById(notaryOfficeId);
  }
}