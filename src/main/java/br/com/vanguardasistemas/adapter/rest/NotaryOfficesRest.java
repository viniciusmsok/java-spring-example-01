package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.application.usecase.notaryoffice.NotaryOfficeCreateUseCase;
import br.com.vanguardasistemas.application.usecase.notaryoffice.NotaryOfficeFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.port.api.NotaryOfficesAPI;

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
  public NotaryOffice createNotaryOffice(
    NotaryOfficeInsertInDTO notaryOfficeInsertInDTO
  ) {
    return notaryOfficeCreateUseCase.create(notaryOfficeInsertInDTO);
  }

  @Override
  public NotaryOffice findById(UUID id) {
    return notaryOfficeFindByIdUseCase.findById(id);
  }
}