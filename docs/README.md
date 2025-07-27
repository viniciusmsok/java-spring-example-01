# Payment Slip

Payment Slip application developed with Spring Boot and Hexagonal Architecture (Ports and Adapters).

**Company:** Vanguarda Sistemas

## Technologies Used

- Java 21
- Spring Boot 3.2.3
- MySQL 8.0
- Lombok
- Maven
- Docker & Docker Compose
- Checkstyle
- Liquibase

## Project Structure

The project follows the principles of Hexagonal Architecture (Ports and Adapters), with the following package structure:

```
src/main/java/br/com/vanguardasistemas/
├── application/           # Application layer
│   ├── dto/              # Data Transfer Objects
│   ├── mapper/           # Object mappers
│   └── usecase/          # Application use cases
├── domain/               # Domain layer
│   ├── model/            # Domain entities and value objects
│   └── repository/       # Repository interfaces
├── port/                 # Application ports (interfaces)
│   ├── api/              # Input ports (APIs)
│   └── db/               # Output ports (database)
├── adapter/              # Adapters (implementations)
│   ├── db/               # Database implementations
│   ├── entity/           # JPA entities
│   ├── exception/        # Exception handling
│   ├── interceptor/      # Interceptors
│   ├── mapper/           # Adapter mappers
│   └── rest/             # REST controllers
└── PaymentSlipApplication.java
```

### Criteria for Creating New Classes

- **application/**
  - **dto/**: Create DTO classes to transfer data between layers, especially for API input and output. Each DTO should represent a clear and specific data contract for the use case and include technical validations for type and required fields.
  - **mapper/**: Create mappers for converting between domain entities, DTOs, and persistence entities. Use mappers to centralize data transformation logic. For now, there is no real need to create interfaces because:
    * Input and output are implicit;
    * They will rarely need different implementations;
    * They do not use specific technology (subject to replacement) for conversion operations.
  - **usecase/**: Each application use case should be represented by a class in this folder. Use cases orchestrate business operations, coordinating interactions between domain and ports/adapters.

- **domain/**
  - **model/**: Create entities and value objects that represent core domain concepts. These classes should be framework-independent and contain only pure business rules.
  - **repository/**: Define repository interfaces that abstract persistence operations. Do not implement data access logic here, only contracts. In this project, we chose to build them free of object-relational mapping frameworks to make the clean architecture divisions clearer.

- **port/**
  - **api/**: Create interfaces that define the contracts for input interactions and potential return for external consumer services (e.g., REST, messaging). Use to abstract communication details.
  - **db/**: Create interfaces that define output contracts for data persistence. Allows swapping database implementations without impacting the domain.

- **adapter/**
  - **db/**: Implement repositories and database integrations using frameworks like JPA/Hibernate, following DDD criteria, understanding that not every entity has its own repository and that these repository classes are created for the aggregate root.
  - **entity/**: Create persistence-specific entities, usually annotated with JPA. Understanding that both relational data structures and other widely used structures (NoSQL, memory, key/value...), as well as the object-oriented model, have their limitations, this difference results in the separation of entity and domain. In many projects, they are implemented "together", however, even with proper use of annotations, we understand that there is still some conflict/interference in their respective responsibilities, justifying a clearer division, so:
    * The domain establishes the data structure for the main operations in the system, focusing on object orientation;
    * The entity classes aim to map the input/output data format with the persistence solution, in this context, focusing on the relational structure.
  - **exception/**: Centralize custom exceptions and global handlers.
  - **interceptor/**: Implement interceptors for cross-cutting concerns (e.g., logging, authentication).
  - **mapper/**: Implement mappers specific to adaptation between external and internal layers.
  - **rest/**: Implement REST controllers, endpoints, and input/output DTOs.

> **Tip:** Always follow the single responsibility principle. Each class should have a clear purpose and be in the layer/package that best represents its function in the system.

## Configuring the Environment

### Prerequisites

1. Java 21
2. Docker and Docker Compose
3. Maven

### Database

The project uses MySQL 8.0 with the following configurations:

- Port: 3306
- Database: payment_slip
- User: your_username
- Password: your_password

### Environment Variables

The application uses environment variables for configuration. You can set them in several ways:

1. **Using .env file (Recommended for development):**
   ```bash
   # Copy the example file
   cp env.example .env
   
   # Edit the .env file with your settings
   # Then load the variables
   scripts/load-env.bat
   # or
   .\scripts\load-env.ps1
   ```

2. **Direct environment variables:**
   ```bash
   export DB_URL=jdbc:mysql://localhost:3306/payment_slip
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
   ```

3. **System environment variables:**
   Set them in your system's environment variables.

### Available Environment Variables

#### Server Configuration
- `SERVER_PORT` - Application port (default: 5000)

#### Database Configuration
- `DB_URL` - Database connection URL
- `DB_USERNAME` - Database username
- `DB_PASSWORD` - Database password
- `DB_DRIVER` - Database driver class

#### Database Pool Configuration
- `DB_CONNECTION_TIMEOUT` - Connection timeout (ms)
- `DB_MAX_POOL_SIZE` - Maximum pool size
- `DB_MIN_IDLE` - Minimum idle connections

#### JPA Configuration
- `JPA_SHOW_SQL` - Show SQL queries
- `JPA_FORMAT_SQL` - Format SQL output

### Project Configurations

- Hikari connection pool configured with:
  - Timeout: 3 seconds
  - Maximum connections: 200
  - Minimum idle connections: 1
- Logging configured for:
  - SQL: DEBUG
  - SQL Parameters: TRACE
  - Application: DEBUG
- Liquibase for database version control

## Running the Project

### Using Docker Compose

```bash
# Start all services
docker-compose up -d

# Check logs
docker-compose logs -f

# Stop all services
docker-compose down
```

### Using Maven

```bash
# Load environment variables first (recommended)
scripts/load-env.bat
# or
.\scripts\load-env.ps1

# Compile and execute
mvn spring-boot:run

# Check code style
mvn checkstyle:check

# Generate JAR file
mvn clean package

# Run JAR file
java -jar target/payment-slip-0.0.1-SNAPSHOT.jar
```

### Using Scripts

#### Windows (Batch)
```bash
# Build and run automatically
scripts/build-and-run.bat
```

#### Windows (PowerShell)
```powershell
# Build and run automatically
.\scripts\build-and-run.ps1
```

## Endpoints

### Root Page

```
GET /
```

Returns an HTML page with links to:
- Swagger Documentation (`/swagger-ui/index.html`)
- Health Check (`/health-check`)

### Health Check

```
GET /health-check
```

Returns the system status including:

- General application status
- Database status
- Timestamp
- Error messages (if any)

Example response:

```json
{
  "status": "UP",
  "timestamp": "2024-03-14T10:30:00.123",
  "service": "Payment Slip API",
  "database": {
    "status": "UP",
    "message": "Database connection is healthy"
  }
}
```

## Development

### Code Patterns

- Indentation: 2 spaces
- Checkstyle configured for automatic validation
- EditorConfig for code standardization between IDEs

### Hexagonal Architecture

The project follows the principles of Hexagonal Architecture (Ports and Adapters):

- **Domain**: Contains business rules and central entities
- **Application**: Orchestrates use cases and coordinates operations
- **Ports**: Defines input and output interfaces
- **Adapters**: Implements interfaces defined by ports

#### Advantages of This Architecture:

- Clear separation of responsibilities
- Independence from frameworks
- Facilitated testability
- Flexible for swapping implementations
- Maintainable code

### Layer Structure

1. **Domain Layer**: Pure business rules
2. **Application Layer**: Use cases and orchestration
3. **Port Layer**: Input and output interfaces
4. **Adapter Layer**: Concrete implementations

## Contribution

To contribute to the project:

1. Follow the established code patterns
2. Execute `mvn checkstyle:check` before committing
3. Maintain the hexagonal architecture
4. Write tests for new features

## Summary of Changes Made

✅ **Project Configuration:**
- **Project name:** `vanguarda-sistemas` → `payment-slip`
- **Domain maintained:** `br.com.vanguardasistemas`
- **Description:** "Payment Slip Application - Vanguarda Sistemas"

✅ **Build Scripts:**
- Updated `scripts/build-and-run.bat` and `scripts/build-and-run.ps1`
- JAR name: `payment-slip-0.0.1-SNAPSHOT.jar`

✅ **Documentation:**
- README.md updated with new project name
- Application title: "Payment Slip"
- Company maintained: "Vanguarda Sistemas"

✅ **Application Interface:**
- Root endpoint (`/`): Title updated to "Payment Slip API"
- Swagger UI: Title updated to "Payment Slip API"
- Health Check: Service name updated

✅ **Tests:**
- RootRest test updated to verify new name

✅ **Main Class:**
- Renamed: `VanguardaSistemasApplication` → `PaymentSlipApplication`
- References updated in `pom.xml` and `README.md`

✅ **Environment Variables:**
- Database configuration moved to environment variables
- `env.example` file created with default configurations
- Scripts `scripts/load-env.bat` and `scripts/load-env.ps1` to load variables
- `DatabaseConfig` class for validation and configuration logging
- Build scripts updated to automatically load variables
- **Optimization:** Only 10 essential variables maintained, other configurations with fixed default values

### Final Structure:
```
br.com.vanguardasistemas (domain/company)
└── payment-slip (application)
    ├── payment-slip-0.0.1-SNAPSHOT.jar
    └── [all project files]
```

Now you can generate the JAR with the command:
```bash
mvn clean package
```

And the file will be generated as: `target/payment-slip-0.0.1-SNAPSHOT.jar`

The domain `br.com.vanguardasistemas` was maintained as requested, and only the application name was changed to `PaymentSlip`.
