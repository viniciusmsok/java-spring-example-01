package br.com.vanguardasistemas.application.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String type, String id) {
    super("Record of type '" + type + "' not found: " + id);
  }

  public NotFoundException(String type, UUID id) {
    super("Record of type '" + type + "' not found: " + id);
  }
}