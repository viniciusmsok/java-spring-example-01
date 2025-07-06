package br.com.vanguardasistemas.application.usecase.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.application.mapper.PersonDTOMapper;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.repository.PersonRepository;

@Service
public class PersonCreateUseCaseImpl implements PersonCreateUseCase {
  private final PersonRepository personRepository;
  private final PersonDTOMapper personDTOMapper;

  public PersonCreateUseCaseImpl(
    PersonRepository personRepository,
    PersonDTOMapper personDTOMapper
  ) {
    this.personRepository = personRepository;
    this.personDTOMapper = personDTOMapper;
  }

  @Override
  @Transactional
  public Person create(PersonInsertInDTO personInsertInDTO) {
    Person person = personDTOMapper.toDomain(personInsertInDTO);
    return personRepository.save(person);
  }
} 