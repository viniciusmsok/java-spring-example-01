package br.com.vanguardasistemas.application.usecase.person;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.Person;

public interface PersonFindByIdUseCase {
  Person findById(UUID id);
} 