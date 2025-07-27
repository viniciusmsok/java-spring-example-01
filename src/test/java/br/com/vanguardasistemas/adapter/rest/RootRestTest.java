package br.com.vanguardasistemas.adapter.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

class RootRestTest {

  private RootRest rootRest;

  @BeforeEach
  void setUp() {
    rootRest = new RootRest();
  }

  @Test
  void getRoot_ShouldReturnHtmlContent() {
    // When
    ResponseEntity<String> response = rootRest.getRoot();

    // Then
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(MediaType.TEXT_HTML, response.getHeaders().getContentType());
    
    String htmlContent = response.getBody();
    assertTrue(htmlContent != null && !htmlContent.isEmpty());
    assertTrue(htmlContent.contains("Payment Slip API"));
    assertTrue(htmlContent.contains("/swagger-ui/index.html"));
    assertTrue(htmlContent.contains("/health-check"));
    assertTrue(htmlContent.contains("Swagger Documentation"));
    assertTrue(htmlContent.contains("Health Check"));
  }
} 