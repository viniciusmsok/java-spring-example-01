package br.com.vanguardasistemas.adapter.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.adapter.mapper.HealthCheckDTOMapper;
import br.com.vanguardasistemas.port.api.HealthCheckAPI;

@RestController
@RequestMapping("/health-check")
public class HealthCheckRest implements HealthCheckAPI {

  private final HealthCheckDTOMapper healthCheckDTOMapper;

  public HealthCheckRest(HealthCheckDTOMapper healthCheckDTOMapper) {
    this.healthCheckDTOMapper = healthCheckDTOMapper;
  }

  @Override
  public ResponseEntity<Map<String, Object>> check() {
    try {
      return ResponseEntity.ok(healthCheckDTOMapper.check());
    } catch (Exception e) {
      Map<String, Object> errorResponse = new HashMap<>();
      errorResponse.put("status", "DOWN");
      errorResponse.put("timestamp", LocalDateTime.now());
      errorResponse.put("service", "Vanguarda Sistemas API");
      errorResponse.put("error", "Health check failed");

      return ResponseEntity.status(503).body(errorResponse);
    }
  }
}