package br.com.vanguardasistemas.adapter.mapper;

import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity;
import br.com.vanguardasistemas.domain.model.NotaryOffice;

@Component
public class NotaryOfficeEntityMapper {
  public NotaryOfficeEntity toEntity(NotaryOffice notaryOffice) {
    return NotaryOfficeEntity.builder()
      .notaryOfficeId(notaryOffice.getNotaryOfficeId())
      .notaryOfficeName(notaryOffice.getName())
      .cityName(notaryOffice.getCityName())
      .stateName(notaryOffice.getStateName())
      .build();
  }

  public NotaryOffice toDomain(NotaryOfficeEntity entity) {
    return NotaryOffice.builder()
      .notaryOfficeId(entity.getNotaryOfficeId())
      .name(entity.getNotaryOfficeName())
      .cityName(entity.getCityName())
      .stateName(entity.getStateName())
      .build();
  }
}