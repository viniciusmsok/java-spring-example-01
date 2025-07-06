# Vanguarda Sistemas

Projeto desenvolvido com Spring Boot, Clean Architecture e DDD.

## Estrutura do Projeto

O projeto segue os princípios da Clean Architecture e DDD, com a seguinte estrutura de pacotes:

```
src/main/java/br/com/vanguardasistemas/
├── application/           # Casos de uso da aplicação
│   ├── ports/            # Portas (interfaces) da aplicação
│   │   ├── input/        # Portas de entrada (use cases)
│   │   └── output/       # Portas de saída (repositories)
│   └── services/         # Implementação dos casos de uso
├── domain/               # Regras de negócio e entidades
│   ├── entities/         # Entidades do domínio
│   ├── repositories/     # Interfaces dos repositórios
│   └── valueobjects/     # Objetos de valor
├── infrastructure/       # Implementações técnicas
│   ├── config/          # Configurações do Spring
│   ├── persistence/     # Implementações dos repositórios
│   └── rest/            # Controllers e DTOs
└── VanguardaSistemasApplication.java
```

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.3
- MySQL 8.0
- Lombok
- Maven
- Docker & Docker Compose
- Checkstyle

## Configuração do Ambiente

### Pré-requisitos

1. Java 21
2. Docker e Docker Compose
3. Maven

### Banco de Dados

O projeto utiliza MySQL 8.0 com as seguintes configurações:

- Porta: 3306
- Database: payment_slip
- Usuário: root
- Senha: dados123

### Configurações do Projeto

- Pool de conexões Hikari configurado com:
  - Timeout: 3 segundos
  - Máximo de conexões: 200
  - Mínimo de conexões ociosas: 1
- Logging configurado para:
  - SQL: DEBUG
  - Parâmetros SQL: TRACE
  - Aplicação: DEBUG

## Executando o Projeto

### Usando Docker Compose

```bash
# Iniciar todos os serviços
docker-compose up -d

# Verificar logs
docker-compose logs -f

# Parar todos os serviços
docker-compose down
```

### Usando Maven

```bash
# Compilar e executar
mvn spring-boot:run

# Verificar estilo do código
mvn checkstyle:check
```

## Endpoints

### Health Check

```
GET /health
```

Retorna o status do sistema incluindo:

- Status geral da aplicação
- Status do banco de dados
- Timestamp
- Mensagens de erro (se houver)

Exemplo de resposta:

```json
{
  "status": "UP",
  "timestamp": "2024-03-14T10:30:00.123",
  "service": "Vanguarda Sistemas API",
  "database": {
    "status": "UP",
    "message": "Database connection is healthy"
  }
}
```

## Desenvolvimento

### Padrões de Código

- Indentação: 2 espaços
- Checkstyle configurado para validação automática
- EditorConfig para padronização entre IDEs

### Clean Architecture

O projeto segue os princípios SOLID e as melhores práticas de Clean Architecture e DDD:

- Separação clara de responsabilidades
- Independência de frameworks
- Testabilidade
- Independência de UI
- Independência de banco de dados
- Independência de qualquer agente externo
