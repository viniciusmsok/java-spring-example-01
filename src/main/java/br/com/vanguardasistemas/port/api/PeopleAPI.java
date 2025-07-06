package br.com.vanguardasistemas.port.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.vanguardasistemas.application.dto.person.in.PersonInsertInDTO;
import br.com.vanguardasistemas.domain.model.Person;
import jakarta.validation.Valid;

@RequestMapping("/people")
public interface PeopleAPI {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Person createPerson(@Valid @RequestBody PersonInsertInDTO personInDTO);

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  Person findById(@PathVariable UUID id);
} 