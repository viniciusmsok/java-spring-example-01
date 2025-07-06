package br.com.vanguardasistemas.application.usecase.person;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Person;

public interface PersonCreateUseCase {
  Person create(PersonInsertInDTO personInsertInDTO);
} 