package br.com.vanguardasistemas.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.username=test",
    "spring.datasource.password=test",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.datasource.hikari.maximum-pool-size=10",
    "spring.datasource.hikari.connection-timeout=1000",
    "server.port=8080"
})
class ApplicationConfigTest {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Test
  void contextLoads() {
    assertNotNull(applicationConfig);
  }
} 