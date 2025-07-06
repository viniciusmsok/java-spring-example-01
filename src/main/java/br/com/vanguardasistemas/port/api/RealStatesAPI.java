package br.com.vanguardasistemas.port.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.vanguardasistemas.application.dto.realestate.in.RealEstateInsertInDTO;
import br.com.vanguardasistemas.domain.model.RealEstate;
import jakarta.validation.Valid;

@RequestMapping("/real-estates")
public interface RealStatesAPI {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  RealEstate createRealEstate(
    @Valid @RequestBody RealEstateInsertInDTO realEstateInDTO
  );

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  RealEstate findById(@PathVariable UUID id);
} 