@echo off
echo ========================================
echo Build and Run - Payment Slip
echo ========================================

echo.
echo 0. Loading environment variables...
if exist .env (
    echo Loading variables from .env file...
    for /f "tokens=1,* delims==" %%a in (.env) do (
        if not "%%a"=="" if not "%%a:~0,1%"=="#" (
            set "%%a=%%b"
        )
    )
    echo Variables loaded!
) else (
    echo .env file not found. Using default configurations.
)

echo.
echo 1. Cleaning previous build...
call mvn clean

echo.
echo 2. Compiling and generating JAR...
call mvn package -DskipTests

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Build failed!
    pause
    exit /b 1
)

echo.
echo 3. JAR generated successfully!
echo Location: target\payment-slip-0.0.1-SNAPSHOT.jar

echo.
echo 4. Running application...
echo Press Ctrl+C to stop the application
echo.
java -jar target\payment-slip-0.0.1-SNAPSHOT.jar

pause 