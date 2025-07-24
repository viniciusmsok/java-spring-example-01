$env:JAVA_HOME = "D:\Programas\java\corretto-17.0.15"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"

Write-Host "Using Java 17: $env:JAVA_HOME" -ForegroundColor Green
java -version
Write-Host ""

# Pass all arguments to mvn
mvn $args 