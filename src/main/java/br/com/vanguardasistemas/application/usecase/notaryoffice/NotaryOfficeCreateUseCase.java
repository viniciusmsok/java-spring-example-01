package br.com.vanguardasistemas.application.usecase.notaryoffice;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;

public interface NotaryOfficeCreateUseCase {
  NotaryOffice create(NotaryOfficeInsertInDTO notaryOfficeInsertInDTO);
} 