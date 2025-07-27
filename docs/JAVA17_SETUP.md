# Java 17 Setup - Vanguarda Sistemas

This document explains how to configure and use Java 17 in the project, even if the default Java in the operating system is different.

## Configurations Made

### 1. Maven (pom.xml)
- ✅ Java version changed to 17
- ✅ Spring Boot 3.2.3 (compatible with Java 17)

### 2. Docker
- ✅ Dockerfile updated to use Java 17
- ✅ Base images changed to `eclipse-temurin:17`

### 3. IDE - IntelliJ IDEA
- ✅ Project configuration already points to Java 17
- ✅ File `.idea/misc.xml` configured correctly

### 4. VS Code
- ✅ Java 17 configuration in `.vscode/settings.json`
- ✅ Java 17 path specified

### 5. Execution Scripts
- ✅ `scripts/mvn-java17.bat` - Batch script for Windows
- ✅ `scripts/mvn-java17.ps1` - PowerShell script for Windows

## How to Use

### Option 1: Using Scripts (Recommended)

#### Windows (PowerShell):
```powershell
.\scripts\mvn-java17.ps1 clean compile
.\scripts\mvn-java17.ps1 spring-boot:run
```

#### Windows (Batch):
```cmd
scripts/mvn-java17.bat clean compile
scripts/mvn-java17.bat spring-boot:run
```

### Option 2: Setting Environment Variables

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

### Option 3: Permanent System Configuration

1. Open **System Environment Variables**
2. In **System Variables**, click **New**
3. Variable name: `JAVA_HOME`
4. Variable value: `D:\Programas\java\corretto-17.0.15`
5. Add `%JAVA_HOME%\bin` to the beginning of the `PATH` variable

## Verification

To verify if you're using Java 17:

```bash
java -version
```

Should show something like:
```
openjdk version "17.0.15" 2025-04-15 LTS
OpenJDK Runtime Environment Corretto-17.0.15.6.1 (build 17.0.15+6-LTS)
OpenJDK 64-Bit Server VM Corretto-17.0.15.6.1 (build 17.0.15+6-LTS, mixed mode, sharing)
```

## Useful Commands

### Compile the Project:
```bash
.\scripts\mvn-java17.ps1 clean compile
```

### Run Tests:
```bash
.\scripts\mvn-java17.ps1 test
```

### Run the Application:
```bash
.\scripts\mvn-java17.ps1 spring-boot:run
```

### Generate JAR:
```bash
.\scripts\mvn-java17.ps1 clean package
```

### Check Dependencies:
```bash
.\scripts\mvn-java17.ps1 dependency:tree
```

## Troubleshooting

### Problem: "java: command not found"
**Solution:** Make sure JAVA_HOME is set correctly and the bin directory is in PATH.

### Problem: "Unsupported major.minor version"
**Solution:** Make sure you're using Java 17 and the project is compiled with Java 17.

### Problem: Maven still using old Java version
**Solution:** Use the provided scripts or set JAVA_HOME before running Maven commands.

## Notes

- The scripts automatically set JAVA_HOME to the correct Java 17 installation
- All Maven commands work normally with the scripts
- The configuration is compatible with both development and production environments 