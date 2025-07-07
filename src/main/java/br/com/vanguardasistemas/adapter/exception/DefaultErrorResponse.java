package br.com.vanguardasistemas.adapter.exception;

import java.time.LocalDateTime;
import java.util.List;

public record DefaultErrorResponse(
  LocalDateTime timestamp,
  int status,
  String error,
  List<String> messages,
  String path
) {}