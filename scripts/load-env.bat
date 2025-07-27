@echo off
echo ========================================
echo Loading environment variables
echo ========================================

if not exist .env (
    echo .env file not found!
    echo Copying env.example to .env...
    copy env.example .env
    echo .env file created successfully!
)

echo.
echo Loading variables from .env file...
for /f "tokens=1,* delims==" %%a in (.env) do (
    if not "%%a"=="" if not "%%a:~0,1%"=="#" (
        set "%%a=%%b"
        echo %%a=%%b
    )
)

echo.
echo Environment variables loaded!
echo.
echo To run the application with loaded variables:
echo mvn spring-boot:run
echo.
echo Or to generate JAR and run:
echo mvn clean package
echo java -jar target\payment-slip-0.0.1-SNAPSHOT.jar 