package br.com.vanguardasistemas.adapter.exception;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vanguardasistemas.application.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class NotFoundExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<DefaultErrorResponse> handleNotFoundException(
    NotFoundException ex, HttpServletRequest request
  ) {
    DefaultErrorResponse response = new DefaultErrorResponse(
      LocalDateTime.now(),
      HttpStatus.NOT_FOUND.value(),
      "Not Found",
      Collections.singletonList(ex.getMessage()),
      request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}