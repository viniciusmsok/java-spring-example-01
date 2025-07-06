package br.com.vanguardasistemas.port.db;

public interface HealthCheckPort {
  String name();
  boolean isHealthy();
}