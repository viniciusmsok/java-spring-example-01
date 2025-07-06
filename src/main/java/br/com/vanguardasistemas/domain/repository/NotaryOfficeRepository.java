package br.com.vanguardasistemas.domain.repository;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.NotaryOffice;

public interface NotaryOfficeRepository {
  NotaryOffice save(NotaryOffice notaryOffice);
  NotaryOffice findById(UUID id);
} 