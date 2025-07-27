@echo off
set JAVA_HOME=D:\Programas\java\corretto-17.0.15
set PATH=%JAVA_HOME%\bin;%PATH%
echo Using Java 17: %JAVA_HOME%
java -version
echo.
mvn %* 