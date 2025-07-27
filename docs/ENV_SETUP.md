# .env File Configuration

## How to use

1. **Create a `.env` file in the project root** (copy from `env.example`):
```bash
cp env.example .env
```

2. **Configure the variables in the `.env` file**:
```env
# Environment Configuration
ENVIRONMENT=DEV

# Server Configuration
SERVER_PORT=5000

# Database Configuration
DB_URL=jdbc:mysql://localhost:3306/payment_slip?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
DB_USERNAME=your_username
DB_PASSWORD=your_password
DB_DRIVER=com.mysql.cj.jdbc.Driver

# Database Pool Configuration
DB_CONNECTION_TIMEOUT=3000
DB_MAX_POOL_SIZE=200
DB_MIN_IDLE=1

# JPA Configuration
JPA_SHOW_SQL=true
JPA_FORMAT_SQL=true
```

## Advantages of .env

- ✅ **Security**: `.env` file is not committed to Git
- ✅ **Flexibility**: Each developer can have their own configurations
- ✅ **Simplicity**: No need to configure environment variables in the system
- ✅ **Portability**: Works in any environment (development, CI/CD, etc.)

## How it works

The `spring-dotenv` library automatically:
1. Loads the `.env` file on startup
2. Makes variables available to Spring Boot
3. Allows using `${VARIABLE_NAME}` in `application.properties`

## Valid values for ENVIRONMENT

- `DEV`: Development environment (displays sensitive information)
- `PROD`: Production environment (hides sensitive information) 