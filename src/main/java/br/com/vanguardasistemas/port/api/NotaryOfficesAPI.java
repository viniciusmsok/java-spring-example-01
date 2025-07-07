package br.com.vanguardasistemas.port.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.vanguardasistemas.application.dto.notaryoffice.in.NotaryOfficeInsertInDTO;
import br.com.vanguardasistemas.domain.model.NotaryOffice;
import jakarta.validation.Valid;

@RequestMapping("/notary-offices")
public interface NotaryOfficesAPI {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  NotaryOffice createNotaryOffice(
    @Valid @RequestBody NotaryOfficeInsertInDTO notaryOfficeInDTO
  );

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  NotaryOffice findById(@Valid @PathVariable UUID id);
}