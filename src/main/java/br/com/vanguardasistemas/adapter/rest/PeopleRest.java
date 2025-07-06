package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.application.usecase.person.PersonCreateUseCase;
import br.com.vanguardasistemas.application.usecase.person.PersonFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.port.api.PeopleAPI;
import jakarta.validation.Valid;

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
  public Person createPerson(@Valid @RequestBody PersonInsertInDTO personInDTO) {
    return personCreateUseCase.create(personInDTO);
  }

  @Override
  public Person findById(@PathVariable UUID id) {
    return personFindByIdUseCase.findById(id);
  }
}