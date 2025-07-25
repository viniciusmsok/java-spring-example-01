package br.com.vanguardasistemas.application.usecase.person;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.repository.PersonRepository;

@Service
public class PersonFindByIdUseCaseImpl implements PersonFindByIdUseCase {

  private final PersonRepository personRepository;

  public PersonFindByIdUseCaseImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person findById(UUID id) {
    Person person = personRepository.findById(id);
    if (person == null) {
      throw new NotFoundException("Person", id);
    }

    return person;
  }
}