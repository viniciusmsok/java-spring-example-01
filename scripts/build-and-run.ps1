Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Build and Run - Payment Slip" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan

Write-Host ""
Write-Host "0. Loading environment variables..." -ForegroundColor Yellow
if (Test-Path ".env") {
    Write-Host "Loading variables from .env file..." -ForegroundColor Yellow
    Get-Content ".env" | ForEach-Object {
        if ($_ -match "^([^#][^=]+)=(.*)$") {
            $name = $matches[1].Trim()
            $value = $matches[2].Trim()
            [Environment]::SetEnvironmentVariable($name, $value, "Process")
        }
    }
    Write-Host "Variables loaded!" -ForegroundColor Green
} else {
    Write-Host ".env file not found. Using default configurations." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "1. Cleaning previous build..." -ForegroundColor Yellow
mvn clean

if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Clean failed!" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "2. Compiling and generating JAR..." -ForegroundColor Yellow
mvn package -DskipTests

if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Build failed!" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "3. JAR generated successfully!" -ForegroundColor Green
Write-Host "Location: target\payment-slip-0.0.1-SNAPSHOT.jar" -ForegroundColor Green

Write-Host ""
Write-Host "4. Running application..." -ForegroundColor Yellow
Write-Host "Press Ctrl+C to stop the application" -ForegroundColor Yellow
Write-Host ""
java -jar target\payment-slip-0.0.1-SNAPSHOT.jar

Read-Host "Press Enter to exit" 