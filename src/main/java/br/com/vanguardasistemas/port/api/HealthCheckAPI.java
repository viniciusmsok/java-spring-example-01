package br.com.vanguardasistemas.port.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health-check")
public interface HealthCheckAPI {
  @GetMapping
  ResponseEntity<Map<String, Object>> check();
}