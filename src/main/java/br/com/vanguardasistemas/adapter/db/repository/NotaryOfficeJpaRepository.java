package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vanguardasistemas.adapter.entity.NotaryOfficeEntity;

public interface NotaryOfficeJpaRepository extends JpaRepository<NotaryOfficeEntity, UUID> {
} 