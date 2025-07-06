package br.com.vanguardasistemas.adapter.db.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vanguardasistemas.adapter.entity.PersonEntity;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, UUID> {
} 