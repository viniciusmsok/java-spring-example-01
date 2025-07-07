package br.com.vanguardasistemas.application.usecase.notaryoffice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;

@Service
public class NotaryOfficeFindByIdUseCaseImpl implements NotaryOfficeFindByIdUseCase {

  private final NotaryOfficeRepository notaryOfficeRepository;

  public NotaryOfficeFindByIdUseCaseImpl(NotaryOfficeRepository notaryOfficeRepository) {
    this.notaryOfficeRepository = notaryOfficeRepository;
  }

  @Override
  public NotaryOffice findById(UUID id) {
    NotaryOffice notaryOffice = notaryOfficeRepository.findById(id);
    if (notaryOffice == null) {
      throw new NotFoundException("NotaryOffice", id);
    }

    return notaryOffice;
  }
} 