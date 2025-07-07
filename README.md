# Vanguarda Sistemas

Projeto desenvolvido com Spring Boot e Hexagonal Architecture (Ports and Adapters).

## Estrutura do Projeto

O projeto segue os princípios da Hexagonal Architecture (Ports and Adapters), com a seguinte estrutura de pacotes:

```
src/main/java/br/com/vanguardasistemas/
├── application/           # Camada de aplicação
│   ├── dto/              # Data Transfer Objects
│   ├── mapper/           # Mappers para conversão de objetos
│   └── usecase/          # Casos de uso da aplicação
├── domain/               # Camada de domínio
│   ├── model/            # Entidades e modelos de domínio
│   └── repository/       # Interfaces dos repositórios
├── port/                 # Portas (interfaces) da aplicação
│   ├── api/              # Portas de entrada (APIs)
│   └── db/               # Portas de saída (banco de dados)
├── adapter/              # Adaptadores (implementações)
│   ├── db/               # Implementações de banco de dados
│   ├── entity/           # Entidades JPA
│   ├── exception/        # Tratamento de exceções
│   ├── interceptor/      # Interceptadores
│   ├── mapper/           # Mappers de adaptação
│   └── rest/             # Controllers REST
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
- Liquibase

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
- Liquibase para controle de versão do banco de dados

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

### Hexagonal Architecture

O projeto segue os princípios da Hexagonal Architecture (Ports and Adapters):

- **Domain**: Contém as regras de negócio e entidades centrais
- **Application**: Orquestra os casos de uso e coordena as operações
- **Ports**: Define as interfaces de entrada e saída
- **Adapters**: Implementa as interfaces definidas pelos ports

#### Vantagens desta Arquitetura:

- Separação clara de responsabilidades
- Independência de frameworks
- Testabilidade facilitada
- Flexibilidade para trocar implementações
- Manutenibilidade do código

### Estrutura de Camadas

1. **Domain Layer**: Regras de negócio puras
2. **Application Layer**: Casos de uso e orquestração
3. **Port Layer**: Contratos de entrada e saída
4. **Adapter Layer**: Implementações concretas

## Contribuição

Para contribuir com o projeto:

1. Siga os padrões de código estabelecidos
2. Execute `mvn checkstyle:check` antes de commitar
3. Mantenha a arquitetura hexagonal
4. Escreva testes para novas funcionalidades
