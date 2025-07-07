package br.com.vanguardasistemas.application.mapper;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;

@Service
public class NotaryOfficeDTOMapper {
  public NotaryOffice toDomain(NotaryOfficeInsertInDTO dto) {
    if (dto == null) {
      return null;
    }

    return NotaryOffice.builder()
      .name(dto.notaryOfficeName())
      .cityName(dto.cityName())
      .stateName(dto.stateName())
      .build();
  }
}