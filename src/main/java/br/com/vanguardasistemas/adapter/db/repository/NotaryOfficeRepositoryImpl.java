package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import br.com.vanguardasistemas.domain.repository.NotaryOfficeRepository;

@Repository
public class NotaryOfficeRepositoryImpl implements NotaryOfficeRepository {
  private final NotaryOfficeJpaRepository notaryOfficeJpaRepository;

  public NotaryOfficeRepositoryImpl(NotaryOfficeJpaRepository notaryOfficeJpaRepository) {
    this.notaryOfficeJpaRepository = notaryOfficeJpaRepository;
  }

  @Override
  public NotaryOffice save(NotaryOffice notaryOffice) {
    NotaryOfficeEntity entity = NotaryOfficeEntity.builder()
      .notaryOfficeId(notaryOffice.getNotaryOfficeId())
      .notaryOfficeName(notaryOffice.getName())
      .cityName(notaryOffice.getCityName())
      .stateName(notaryOffice.getStateName())
      .build();

    NotaryOfficeEntity saved = notaryOfficeJpaRepository.save(entity);

    return NotaryOffice.builder()
      .notaryOfficeId(saved.getNotaryOfficeId())
      .name(saved.getNotaryOfficeName())
      .cityName(saved.getCityName())
      .stateName(saved.getStateName())
      .build();
  }

  @Override
  public NotaryOffice findById(UUID id) {
    return notaryOfficeJpaRepository.findById(id)
      .map(this::convertToDomain)
      .orElse(null);
  }

  private NotaryOffice convertToDomain(NotaryOfficeEntity entity) {
    return NotaryOffice.builder()
      .notaryOfficeId(entity.getNotaryOfficeId())
      .name(entity.getNotaryOfficeName())
      .cityName(entity.getCityName())
      .stateName(entity.getStateName())
      .build();
  }
}