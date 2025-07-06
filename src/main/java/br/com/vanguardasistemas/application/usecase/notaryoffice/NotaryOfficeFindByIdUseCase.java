package br.com.vanguardasistemas.application.usecase.notaryoffice;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.NotaryOffice;

public interface NotaryOfficeFindByIdUseCase {
  NotaryOffice findById(UUID id);
} 