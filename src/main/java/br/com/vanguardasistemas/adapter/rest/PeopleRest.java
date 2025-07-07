package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.application.usecase.person.PersonCreateUseCase;
import br.com.vanguardasistemas.application.usecase.person.PersonFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.port.api.PeopleAPI;

@RestController
public class PeopleRest implements PeopleAPI {

  private final PersonCreateUseCase personCreateUseCase;
  private final PersonFindByIdUseCase personFindByIdUseCase;

  public PeopleRest(
    PersonCreateUseCase personCreateUseCase,
    PersonFindByIdUseCase personFindByIdUseCase
  ) {
    this.personCreateUseCase = personCreateUseCase;
    this.personFindByIdUseCase = personFindByIdUseCase;
  }

  @Override
  public Person createPerson(PersonInsertInDTO personInDTO) {
    return personCreateUseCase.create(personInDTO);
  }

  @Override
  public Person findById(UUID id) {
    return personFindByIdUseCase.findById(id);
  }
}