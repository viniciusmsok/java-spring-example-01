package br.com.vanguardasistemas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnvironmentValidator implements CommandLineRunner {

  private final Environment environment;

  public EnvironmentValidator(Environment environment) {
    this.environment = environment;
  }

  @Value("${server.port}")
  private String serverPort;

  @Value("${spring.datasource.url}")
  private String databaseUrl;

  @Value("${spring.datasource.username}")
  private String databaseUsername;

  @Override
  public void run(String... args) throws Exception {
    List<String> errors = new ArrayList<>();

    // Active profile validation
    String activeProfile = environment.getActiveProfiles().length > 0 ? environment.getActiveProfiles()[0] : null;
    if (activeProfile == null || activeProfile.trim().isEmpty()) {
      errors.add("spring.profiles.active is not configured");
    } else if (!"DEV".equals(activeProfile) && !"PROD".equals(activeProfile)) {
      errors.add("spring.profiles.active must be 'DEV' or 'PROD', current value: " + activeProfile);
    }

    // Server port validation
    if (serverPort == null || serverPort.trim().isEmpty()) {
      errors.add("server.port is not configured");
    }

    // Database URL validation
    if (databaseUrl == null || databaseUrl.trim().isEmpty()) {
      errors.add("spring.datasource.url is not configured");
    }

    // Database username validation
    if (databaseUsername == null || databaseUsername.trim().isEmpty()) {
      errors.add("spring.datasource.username is not configured");
    }

    // If there are errors, display and stop the application
    if (!errors.isEmpty()) {
      System.err.println("========================================");
      System.err.println("ERROR: Required environment variables not configured:");
      System.err.println("========================================");
      
      for (String error : errors) {
        System.err.println("❌ " + error);
      }
      
      System.err.println("========================================");
      System.err.println("Configure the environment variables and restart the application.");
      System.err.println("========================================");
      
      System.exit(1);
    }

    System.out.println("========================================");
    System.out.println("✅ Environment validation completed successfully!");
    System.out.println("Environment: " + activeProfile);
    System.out.println("========================================");
  }
} 