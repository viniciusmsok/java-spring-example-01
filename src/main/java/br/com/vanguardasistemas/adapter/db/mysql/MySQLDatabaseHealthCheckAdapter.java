package br.com.vanguardasistemas.adapter.db.mysql;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.vanguardasistemas.port.db.HealthCheckPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.QueryTimeoutException;

@Component
public class MySQLDatabaseHealthCheckAdapter implements HealthCheckPort {
  private static final Logger logger = LoggerFactory.getLogger(MySQLDatabaseHealthCheckAdapter.class);
  private final EntityManager entityManager;
  private static final int TIMEOUT_SECONDS = 3;

  public MySQLDatabaseHealthCheckAdapter(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public String name() {
    return "database";
  }

  @Override
  public boolean isHealthy() {
    try {
      var query = entityManager.createNativeQuery("SELECT 1");
      query.unwrap(Query.class).setTimeout(TIMEOUT_SECONDS);
      query.getSingleResult();
      return true;
    } catch (QueryTimeoutException e) {
      logger.error("Database health check timeout after {} seconds", TIMEOUT_SECONDS, e);
      return false;
    } catch (Exception e) {
      logger.error("Database health check failed", e);
      return false;
    }
  }
} 