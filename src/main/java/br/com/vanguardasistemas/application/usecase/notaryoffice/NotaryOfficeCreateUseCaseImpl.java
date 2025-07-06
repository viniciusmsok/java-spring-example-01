package br.com.vanguardasistemas.application.usecase.notaryoffice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.application.mapper.NotaryOfficeDTOMapper;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;

@Service
public class NotaryOfficeCreateUseCaseImpl implements NotaryOfficeCreateUseCase {
  private final NotaryOfficeRepository notaryOfficeRepository;
  private final NotaryOfficeDTOMapper notaryOfficeDTOMapper;

  public NotaryOfficeCreateUseCaseImpl(
    NotaryOfficeRepository notaryOfficeRepository,
    NotaryOfficeDTOMapper notaryOfficeDTOMapper
  ) {
    this.notaryOfficeRepository = notaryOfficeRepository;
    this.notaryOfficeDTOMapper = notaryOfficeDTOMapper;
  }

  @Override
  @Transactional
  public NotaryOffice create(NotaryOfficeInsertInDTO notaryOfficeInsertInDTO) {
    NotaryOffice notaryOffice = notaryOfficeDTOMapper.toDomain(notaryOfficeInsertInDTO);
    return notaryOfficeRepository.save(notaryOffice);
  }
} 