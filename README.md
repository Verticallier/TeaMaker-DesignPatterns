# ☕ TeaMaker – Design Patterns in Java

This project is a **Java-based demonstration of software design patterns**, implemented through a smart **Tea Maker simulation**.  
It showcases how **behavioral and structural design patterns** can be used together to manage complex states and extend functionality in a **clean, decoupled, and scalable** way.

---

## 🎯 Project Purpose

- Demonstrate **Object-Oriented Design Patterns** in a real-world inspired scenario
- Show how patterns can manage **hardware-like states** (Boiling, Brewing, Idle)
- Serve as a **learning and portfolio project** for software engineering
- Provide a **clean and extensible codebase** integrated with a **MySQL database** for logging

---

## 🧠 Implemented Design Patterns

The project implements the following design patterns to solve specific architectural problems:

### 🔹 State Pattern
Manages the tea maker’s lifecycle and transitions between states such as:
- `EmptyState`
- `BoilingWaterState`
- `TeaState`
- `DoneState`

This allows state-specific behavior without complex conditional logic.

### 🔹 Observer Pattern
Implements a notification mechanism where:
- UI components or other listeners are **automatically updated**
- State changes propagate without tight coupling

### 🔹 Decorator Pattern
Dynamically extends message functionality without modifying existing classes:
- Example: `HealthWarningDecorator` adds additional behavior to `BaseMessage`

---

## 🧩 Architectural Overview

The **State pattern** controls the TeaMaker’s lifecycle, while the **Observer pattern** keeps the user interface synchronized with state changes.  
The **Decorator pattern** is used to extend system messages dynamically, ensuring the core logic remains clean and open for extension.

---

## 🛠️ Technologies & Requirements

- **Java** (JDK 8 or higher)
- **Swing** – Graphical User Interface (GUI)
- **MySQL** – Persistent logging of tea-making history
- **JDBC** – MySQL Connector/J
- **Apache Ant** – Build automation
- **NetBeans IDE** – Original development environment

---

## 🏗️ Project Structure

```text
TeaMaker-DesignPatterns/
│
├── src/                    # Java source files (.java)
├── teaMakerDB.sql          # MySQL database schema
├── nbproject/              # NetBeans project configuration
├── build.xml               # Ant build configuration
└── .gitignore              # Git ignored files
```
⚠️ This project is currently configured as a NetBeans Ant project.

▶️ How to Run the Project
Prerequisites
Database Setup
Import teaMakerDB.sql into your MySQL server to create the required tables.

Configuration
Update DBConnection.java with your MySQL username and password if necessary.

Option 1: NetBeans (Recommended)
Open NetBeans

Select File → Open Project

Choose the TeaMaker-DesignPatterns folder

Right-click the project and select Clean and Build

Click Run

Option 2: IntelliJ IDEA
Open IntelliJ IDEA

File → Open, select the project folder

Add build.xml as an Ant build file if prompted

Ensure the MySQL JDBC driver is available in the classpath

Run the main class

🚀 Possible Improvements (Future Work)
Migrate from Ant to Maven or Gradle for better dependency management

Add JUnit tests to validate state transitions and behavior

Containerize the application and database using Docker

Add UML diagrams to visually document design pattern usage

