package br.com.vanguardasistemas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import jakarta.annotation.PostConstruct;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {

  private final Environment environment;

  public ApplicationConfig(Environment environment) {
    this.environment = environment;
  }

  @Value("${spring.datasource.url}")
  private String databaseUrl;

  @Value("${spring.datasource.username}")
  private String databaseUsername;

  @Value("${spring.datasource.driver-class-name}")
  private String databaseDriver;

  @Value("${spring.datasource.hikari.maximum-pool-size}")
  private String maxPoolSize;

  @Value("${spring.datasource.hikari.connection-timeout}")
  private String connectionTimeout;

  @Value("${spring.datasource.hikari.minimum-idle}")
  private String minIdle;

  @Value("${spring.jpa.show-sql}")
  private String showSql;

  @Value("${spring.jpa.properties.hibernate.format_sql}")
  private String formatSql;

  @Value("${server.port}")
  private String serverPort;

  @PostConstruct
  public void logApplicationConfiguration() {
    String activeProfile = environment.getActiveProfiles().length > 0 ? environment.getActiveProfiles()[0] : "default";
    
    System.out.println("========================================");
    System.out.println("Application Configuration:");
    System.out.println("========================================");
    System.out.println("Active Profile: " + activeProfile);
    System.out.println("Server Port: " + serverPort);
    
    if ("DEV".equals(activeProfile)) {
      System.out.println("Database URL: " + databaseUrl);
      System.out.println("Database Username: " + databaseUsername);
    }
    
    System.out.println("Database Driver: " + databaseDriver);
    System.out.println("Max Pool Size: " + maxPoolSize);
    System.out.println("Connection Timeout: " + connectionTimeout + "ms");
    System.out.println("Min Idle: " + minIdle);
    System.out.println("Show SQL: " + showSql);
    System.out.println("Format SQL: " + formatSql);
    System.out.println("========================================");
  }
} 