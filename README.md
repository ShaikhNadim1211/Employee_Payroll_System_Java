# Employee Payroll System

This is a Java-based Employee Payroll System that calculates and generates an employee's payslip based on input data like basic salary, overtime, bonus, commissions, tax rates, insurance, provident fund, and other deductions. It also generates a `.txt` file containing the payslip details.

## Features

- Calculates the gross salary, deductions, and net salary.
- Generates payslip with breakdowns of increments and deductions.
- Saves the payslip to a `.txt` file.
- Handles multiple salary components like overtime, bonus, commission, leaves, income tax, insurance, and provident fund.
- Validates input data to ensure accuracy and prevents incorrect data entries.

## Dependencies

Ensure you have the following Java packages or imports ready:

- `java.util.Scanner`
- `java.util.regex.Pattern`
- `java.io.File`
- `java.io.FileWriter`
- `java.io.IOException`
- `java.text.SimpleDateFormat`
- `java.time.LocalDate`
- `java.time.Period`

## Getting Started

### Prerequisites

- Install JDK 8 or above on your system.
- A Java IDE like IntelliJ IDEA, Eclipse, or NetBeans is recommended.

### Running the Application

1. Compile the Java files:
    ```bash
    javac Main.java
    ```

2. Run the application:
    ```bash
    java Main
    ```

3. Follow the instructions in the console to enter employee details, salary components, and applicable taxes.

4. After the calculation, you can choose to create a payslip by pressing `1`, which will generate a `.txt` file with the payslip details in the project directory.

### Example Input/Output
![Payroll](https://github.com/user-attachments/assets/9fd44a21-aba9-4f3a-8e18-5db80865c2bd)
