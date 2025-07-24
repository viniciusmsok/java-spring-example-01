# Configuração Java 17 - Vanguarda Sistemas

Este documento explica como configurar e usar o Java 17 no projeto, mesmo que o Java padrão do sistema operacional seja outro.

## Configurações Realizadas

### 1. Maven (pom.xml)
- ✅ Versão do Java alterada para 17
- ✅ Spring Boot 3.2.3 (compatível com Java 17)

### 2. Docker
- ✅ Dockerfile atualizado para usar Java 17
- ✅ Imagens base alteradas para `eclipse-temurin:17`

### 3. IDE - IntelliJ IDEA
- ✅ Configuração do projeto já aponta para Java 17
- ✅ Arquivo `.idea/misc.xml` configurado corretamente

### 4. VS Code
- ✅ Configuração do Java 17 no `.vscode/settings.json`
- ✅ Caminho do Java 17 especificado

### 5. Scripts de Execução
- ✅ `mvn-java17.bat` - Script batch para Windows
- ✅ `mvn-java17.ps1` - Script PowerShell para Windows

## Como Usar

### Opção 1: Usando os Scripts (Recomendado)

#### Windows (PowerShell):
```powershell
.\mvn-java17.ps1 clean compile
.\mvn-java17.ps1 spring-boot:run
```

#### Windows (Batch):
```cmd
mvn-java17.bat clean compile
mvn-java17.bat spring-boot:run
```

### Opção 2: Configurando Variáveis de Ambiente

#### PowerShell:
```powershell
$env:JAVA_HOME = "D:\Programas\java\corretto-17.0.15"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
mvn clean compile
```

#### CMD:
```cmd
set JAVA_HOME=D:\Programas\java\corretto-17.0.15
set PATH=%JAVA_HOME%\bin;%PATH%
mvn clean compile
```

### Opção 3: Configuração Permanente no Sistema

1. Abra as **Variáveis de Ambiente do Sistema**
2. Em **Variáveis do Sistema**, clique em **Novo**
3. Nome da variável: `JAVA_HOME`
4. Valor da variável: `D:\Programas\java\corretto-17.0.15`
5. Adicione `%JAVA_HOME%\bin` ao início da variável `PATH`

## Verificação

Para verificar se está usando Java 17:

```bash
java -version
```

Deve mostrar algo como:
```
openjdk version "17.0.15" 2025-04-15 LTS
OpenJDK Runtime Environment Corretto-17.0.15.6.1 (build 17.0.15+6-LTS)
OpenJDK 64-Bit Server VM Corretto-17.0.15.6.1 (build 17.0.15+6-LTS, mixed mode, sharing)
```

## Comandos Úteis

### Compilar o Projeto:
```bash
.\mvn-java17.ps1 clean compile
```

### Executar Testes:
```bash
.\mvn-java17.ps1 test
```

### Executar a Aplicação:
```bash
.\mvn-java17.ps1 spring-boot:run
```

### Gerar JAR:
```bash
.\mvn-java17.ps1 clean package
```

### Verificar Dependências:
```bash
.\mvn-java17.ps1 dependency:tree
```

## Troubleshooting

### Problema: "java não é reconhecido como comando"
**Solução:** Verifique se o caminho do Java 17 está correto no script ou nas variáveis de ambiente.

### Problema: "IncompatibleClassVersionError"
**Solução:** Certifique-se de que está usando Java 17 para compilar e executar.

### Problema: IDE não reconhece Java 17
**Solução:** 
1. No IntelliJ IDEA: File → Project Structure → Project SDK → Add SDK → Java 17
2. No VS Code: Verifique se a extensão Java está configurada corretamente

## Notas Importantes

- O projeto foi configurado para usar Java 17 LTS
- Spring Boot 3.2.3 é compatível com Java 17+
- Todos os scripts e configurações estão prontos para uso
- O Dockerfile está configurado para usar Java 17
- As configurações da IDE estão otimizadas para Java 17 