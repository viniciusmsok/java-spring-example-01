Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Loading environment variables" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan

if (-not (Test-Path ".env")) {
    Write-Host ".env file not found!" -ForegroundColor Yellow
    Write-Host "Copying env.example to .env..." -ForegroundColor Yellow
    Copy-Item "env.example" ".env"
    Write-Host ".env file created successfully!" -ForegroundColor Green
}

Write-Host ""
Write-Host "Loading variables from .env file..." -ForegroundColor Yellow

Get-Content ".env" | ForEach-Object {
    if ($_ -match "^([^#][^=]+)=(.*)$") {
        $name = $matches[1].Trim()
        $value = $matches[2].Trim()
        [Environment]::SetEnvironmentVariable($name, $value, "Process")
        Write-Host "$name=$value" -ForegroundColor Gray
    }
}

Write-Host ""
Write-Host "Environment variables loaded!" -ForegroundColor Green
Write-Host ""
Write-Host "To run the application with loaded variables:" -ForegroundColor Yellow
Write-Host "mvn spring-boot:run" -ForegroundColor White
Write-Host ""
Write-Host "Or to generate JAR and run:" -ForegroundColor Yellow
Write-Host "mvn clean package" -ForegroundColor White
Write-Host "java -jar target\payment-slip-0.0.1-SNAPSHOT.jar" -ForegroundColor White 