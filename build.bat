@echo off
REM Build script for Shipping Cost Calculator

REM Create bin directory if it doesn't exist
if not exist bin mkdir bin

REM Compile all Java files
echo Compiling Java files...
javac -d bin src\*\*.java src\*\*\*.java

REM Check if compilation was successful
if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    
    REM Ask user which version to run
    echo.
    echo Which version would you like to run?
    echo 1. Console Version
    echo 2. GUI Version
    set /p choice="Enter your choice (1 or 2): "
    
    if "%choice%"=="1" (
        echo Running Console Version...
        java -cp bin main.Main
    ) else if "%choice%"=="2" (
        echo Running GUI Version...
        java -cp bin gui.ShippingCostCalculatorGUI
    ) else (
        echo Invalid choice. Please enter 1 or 2.
    )
) else (
    echo Compilation failed!
)
