package br.com.vanguardasistemas.application.usecase.person;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.repository.PersonRepository;
import br.com.vanguardasistemas.application.mapper.PersonDTOMapper;
import br.com.vanguardasistemas.mocks.PersonMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

class PersonCreateUseCaseImplTest {

  @Test
  void deveCriarPessoaComSucesso() {
    PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    PersonDTOMapper personDTOMapper = Mockito.mock(PersonDTOMapper.class);
    PersonCreateUseCaseImpl useCase = new PersonCreateUseCaseImpl(
      personRepository,
      personDTOMapper
    );

    PersonInsertInDTO dto = PersonMocks.defaultPersonInsertInDTO(null);
    Person person = PersonMocks.defaultPerson(null);

    Mockito.when(personDTOMapper.toDomain(dto)).thenReturn(person);
    Mockito.when(personRepository.save(person)).thenReturn(person);

    Person result = useCase.create(dto);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(person, result);
    Mockito.verify(personDTOMapper).toDomain(dto);
    Mockito.verify(personRepository).save(person);
  }
}