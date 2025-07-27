Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Build e Execucao - Payment Slip" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan

Write-Host ""
Write-Host "1. Limpando build anterior..." -ForegroundColor Yellow
mvn clean

if ($LASTEXITCODE -ne 0) {
    Write-Host "ERRO: Falha na limpeza!" -ForegroundColor Red
    Read-Host "Pressione Enter para sair"
    exit 1
}

Write-Host ""
Write-Host "2. Compilando e gerando JAR..." -ForegroundColor Yellow
mvn package -DskipTests

if ($LASTEXITCODE -ne 0) {
    Write-Host "ERRO: Falha na compilacao!" -ForegroundColor Red
    Read-Host "Pressione Enter para sair"
    exit 1
}

Write-Host ""
Write-Host "3. JAR gerado com sucesso!" -ForegroundColor Green
Write-Host "Localizacao: target\payment-slip-0.0.1-SNAPSHOT.jar" -ForegroundColor Green

Write-Host ""
Write-Host "4. Executando aplicacao..." -ForegroundColor Yellow
Write-Host "Pressione Ctrl+C para parar a aplicacao" -ForegroundColor Yellow
Write-Host ""
java -jar target\payment-slip-0.0.1-SNAPSHOT.jar

Read-Host "Pressione Enter para sair" 