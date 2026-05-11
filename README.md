# JavaFX BMI Calculator

A lightweight, desktop-based Body Mass Index (BMI) calculator built using **JavaFX**. This application provides a clean graphical user interface (GUI) to help users determine their BMI and weight category based on their height and weight.

---

## Preview

<img width="245" height="146" alt="image" src="https://github.com/user-attachments/assets/2ebb5fac-4cfc-4db3-a609-e677734e5ffa" />

---
## 🚀 Features

* **Real-time Calculation:** Instantly calculates BMI based on metric input (kg and meters).
* **Health Categorization:** Automatically identifies the BMI category:
* **Underweight:** < 18.5
* **Normal:** 18.5 – 24.9
* **Overweight:** 25.0 – 29.9
* **Obese:** 30.0+


* **Input Validation:** Simple check to ensure both fields are populated before calculating.
* **Reset Functionality:** Easily clear all fields with a single click.
* **User-Friendly Layout:** Uses a structured `GridPane` and `BorderPane` for a consistent UI experience.

---

## 🛠️ Built With

* **Java 21** (or higher)
* **JavaFX 17+**
* **CSS/Layout:** JavaFX Scene Graph

---

## 📖 How to Use

1. **Enter Weight:** Input your weight in kilograms (kg) in the first field.
2. **Enter Height:** Input your height in meters (m) in the second field.
3. **Calculate:** Click the **Calculate** button to see your numerical BMI and health status.
4. **Reset:** Click the **Reset** button to clear the inputs and start over.

---

## ⚙️ Setup and Installation

### Prerequisites

* [Java Development Kit (JDK)]() installed.
* JavaFX SDK downloaded and configured in your environment or IDE.

### Running the Application

If you are using a terminal and have JavaFX configured, navigate to the source folder and run:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls BMICalculator.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls bmi.BMICalculator

```

---

🏗️ ## Future Development 
Imperial Unit SupportTo make the application more versatile, the following updates are planned for the next release:1. Toggleable Unit SystemsImplement a Radio Button or Toggle Switch to allow users to choose between Metric (kg/m) and Imperial (lbs/ft) systems.Update the UI dynamically to change labels from "Weight (kg)" to "Weight (lbs)" and "Height (m)" to "Height (ft/in)".2. Enhanced Height InputsAdd two separate input fields for Imperial height (Feet and Inches) to improve user experience, as most users know their height in that format rather than total inches.3. Backend Logic UpdateIntegrate the Imperial BMI constant ($703$) into the calculation logic:$$BMI = \frac{weight_{lbs} \times 703}{(height_{ft} \times 12 + height_{in})^2}$$4. Input SanitizationAdd error handling to prevent the application from crashing if a user enters non-numeric characters (e.g., "6'1" instead of "6").

---

## 📝 Author

**Tyrone Darby**

*Created: May 11, 2026*

---

## ⚖️ License

This project is open-source and available for educational purposes.
