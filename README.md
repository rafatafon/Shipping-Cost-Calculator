# Shipping Cost Calculator

A Java application that calculates shipping costs based on item dimensions and weight. This project was developed as part of a Backend Development course.

## Project Overview

The Shipping Cost Calculator helps users determine the most cost-effective shipping method for their items. It calculates the total volume of items and recommends the appropriate container sizes (big or small) to optimize shipping costs.

## Features

- Add different types of products (Laptop, Mouse, Desktop, LCD Screen)
- Specify quantities for each product
- Calculate total volume and weight
- Determine the optimal combination of shipping containers
- Calculate total shipping cost
- View order details in a separate window

## Project Structure

- **items**: Contains the Item class for product definitions
- **containers**: Contains Container abstract class and concrete implementations (BigContainer, SmallContainer)
- **methods**: Contains the Calculation class with core business logic
- **gui**: Contains the ShippingCostCalculatorGUI class for the user interface
- **main**: Contains the Main class for console-based testing

## How to Run

### Using Build Scripts

The easiest way to compile and run the project is by using the provided build scripts:

#### On macOS/Linux:
```bash
# Make the script executable
chmod +x build.sh
# Run the script
./build.sh
```

#### On Windows:
```bash
build.bat
```

The build scripts will compile the project and prompt you to choose between running the console version or the GUI version.

### Manual Compilation

If you prefer to compile and run the project manually:

#### Console Version
1. Compile the Java files
2. Run the Main class in the main package

```bash
javac -d bin src/*/*.java src/*/*/*.java
java -cp bin main.Main
```

#### GUI Version
1. Compile the Java files
2. Run the ShippingCostCalculatorGUI class in the gui package

```bash
javac -d bin src/*/*.java src/*/*/*.java
java -cp bin gui.ShippingCostCalculatorGUI
```

## Container Specifications

- **Big Container**: 259.0 cm × 243.0 cm × 1201.0 cm (Height × Width × Length)
- **Small Container**: 259.0 cm × 243.0 cm × 606.0 cm (Height × Width × Length)

## Shipping Costs

- Big Container: 1800.0 Euros
- Small Container: 1000.0 Euros

## Product Specifications

| Product    | Length (cm) | Width (cm) | Height (cm) | Weight (kg) |
|------------|-------------|------------|-------------|-------------|
| Laptop     | 60          | 50         | 50          | 6.5         |
| Mouse      | 30          | 30         | 20          | 0.2         |
| Desktop    | 100         | 150        | 50          | 20          |
| LCD Screen | 120         | 140        | 80          | 2.6         |

## License

This project is for educational purposes as part of a Backend Development course.
