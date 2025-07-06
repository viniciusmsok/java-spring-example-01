package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;

@Service
public class NotaryOfficeDTOMapper {
  public NotaryOffice toDomain(NotaryOfficeInsertInDTO notaryOfficeInsertInDTO) {
    return NotaryOffice.builder()
      .name(notaryOfficeInsertInDTO.notaryOfficeName())
      .cityName(notaryOfficeInsertInDTO.cityName())
      .stateName(notaryOfficeInsertInDTO.stateName())
      .build();
  }
} 