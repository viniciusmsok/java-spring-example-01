package br.com.vanguardasistemas.adapter.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.application.usecase.person.PersonCreateUseCase;
import br.com.vanguardasistemas.application.usecase.person.PersonFindByIdUseCase;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.port.api.PeopleAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "People", description = "Operations related to people")
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
  @Operation(
    summary = "Create a new person",
    description = "Creates a person from the data provided in the request body."
  )
  public Person createPerson(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Data for person creation", required = true)
    PersonInsertInDTO personInDTO
  ) {
    return personCreateUseCase.create(personInDTO);
  }

  @Override
  @Operation(
    summary = "Find person by ID",
    description = "Returns a person by their UUID."
  )
  public Person findById(
    @Parameter(description = "Person UUID", required = true)
    UUID personId
  ) {
    return personFindByIdUseCase.findById(personId);
  }
}