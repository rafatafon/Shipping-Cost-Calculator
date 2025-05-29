#!/bin/bash

# Build script for Shipping Cost Calculator

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files
echo "Compiling Java files..."
javac -d bin src/*/*.java src/*/*/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    
    # Ask user which version to run
    echo ""
    echo "Which version would you like to run?"
    echo "1. Console Version"
    echo "2. GUI Version"
    read -p "Enter your choice (1 or 2): " choice
    
    if [ "$choice" = "1" ]; then
        echo "Running Console Version..."
        java -cp bin main.Main
    elif [ "$choice" = "2" ]; then
        echo "Running GUI Version..."
        java -cp bin gui.ShippingCostCalculatorGUI
    else
        echo "Invalid choice. Please enter 1 or 2."
    fi
else
    echo "Compilation failed!"
fi
