package br.com.vanguardasistemas.domain.repository;

import java.util.UUID;

import br.com.vanguardasistemas.domain.model.Person;

public interface PersonRepository {
  Person save(Person person);
  Person findById(UUID id);
} 