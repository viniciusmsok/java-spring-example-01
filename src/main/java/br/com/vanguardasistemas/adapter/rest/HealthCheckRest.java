package br.com.vanguardasistemas.adapter.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanguardasistemas.adapter.mapper.HealthCheckDTOMapper;
import br.com.vanguardasistemas.port.api.HealthCheckAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health Check", description = "API health check")
@RestController
public class HealthCheckRest implements HealthCheckAPI {

  private final HealthCheckDTOMapper healthCheckDTOMapper;

  public HealthCheckRest(HealthCheckDTOMapper healthCheckDTOMapper) {
    this.healthCheckDTOMapper = healthCheckDTOMapper;
  }

  @Override
  @Operation(
    summary = "Check application health",
    description = "Returns the application status and basic information."
  )
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