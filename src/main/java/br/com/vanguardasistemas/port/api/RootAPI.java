package br.com.vanguardasistemas.port.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
 
public interface RootAPI {
  @GetMapping("/")
  ResponseEntity<String> getRoot();
} 