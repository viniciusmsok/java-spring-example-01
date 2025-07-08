package br.com.vanguardasistemas.application.usecase.person;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import br.com.vanguardasistemas.domain.model.Person;
import br.com.vanguardasistemas.domain.repository.PersonRepository;
import br.com.vanguardasistemas.mocks.PersonMocks;

@ExtendWith(MockitoExtension.class)
class PersonFindByIdUseCaseImplTest {

    @Mock
    private PersonRepository personRepository;

    private PersonFindByIdUseCaseImpl personFindByIdUseCase;

    @BeforeEach
    void setUp() {
        personFindByIdUseCase = new PersonFindByIdUseCaseImpl(personRepository);
    }

    @Test
    void shouldFindPersonByIdSuccessfully() {
        UUID personId = PersonMocks.PERSON_ID;
        Person person = PersonMocks.defaultPerson(null);

        when(personRepository.findById(personId)).thenReturn(person);

        Person result = personFindByIdUseCase.findById(personId);

        assertNotNull(result);
        assertEquals(person, result);
        assertEquals(personId, result.getPersonId());
        assertEquals(PersonMocks.PERSON_TYPE, result.getPersonType());
        assertEquals(PersonMocks.NATIONAL_IDENTIFIER_CODE, result.getNationalIdentifierCode());
        assertEquals(PersonMocks.REGIONAL_IDENTIFIER_CODE, result.getRegionalIdentifierCode());

        verify(personRepository).findById(personId);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenPersonNotFound() {
        UUID personId = UUID.randomUUID();
        when(personRepository.findById(personId)).thenReturn(null);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            personFindByIdUseCase.findById(personId);
        });

        assertEquals("Record of type 'Person' not found: " + personId, exception.getMessage());
        verify(personRepository).findById(personId);
    }
} 