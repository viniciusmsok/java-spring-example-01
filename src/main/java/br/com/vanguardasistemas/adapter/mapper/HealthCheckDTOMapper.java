package br.com.vanguardasistemas.adapter.mapper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.vanguardasistemas.port.db.HealthCheckPort;

@Service
public class HealthCheckDTOMapper {
  private final List<HealthCheckPort> healthCheckPorts;

  public HealthCheckDTOMapper(List<HealthCheckPort> healthCheckPorts) {
    this.healthCheckPorts = healthCheckPorts;
  }

  public Map<String, Object> check() {
    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", LocalDateTime.now());
    response.put("service", "Payment Slip API");

    boolean allHealthy = true;
    Map<String, Object> checks = new HashMap<>();
    for (HealthCheckPort port : healthCheckPorts) {
      boolean healthy = port.isHealthy();
      checks.put(port.name(), healthy ? "UP" : "DOWN");
      if (!healthy) {
        allHealthy = false;
      }
    }
    response.put("checks", checks);
    response.put("status", allHealthy ? "UP" : "DEGRADED");

    return response;
  }
}