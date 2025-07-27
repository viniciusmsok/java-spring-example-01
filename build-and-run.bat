@echo off
echo ========================================
echo Build e Execucao - Payment Slip
echo ========================================

echo.
echo 1. Limpando build anterior...
call mvn clean

echo.
echo 2. Compilando e gerando JAR...
call mvn package -DskipTests

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERRO: Falha na compilacao!
    pause
    exit /b 1
)

echo.
echo 3. JAR gerado com sucesso!
echo Localizacao: target\payment-slip-0.0.1-SNAPSHOT.jar

echo.
echo 4. Executando aplicacao...
echo Pressione Ctrl+C para parar a aplicacao
echo.
java -jar target\payment-slip-0.0.1-SNAPSHOT.jar

pause 