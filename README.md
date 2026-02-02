# ☕ TeaMaker – Advanced Design Patterns Project

This project is a **sophisticated Tea Maker Simulation** built with **Java**, designed to demonstrate the **practical application of Software Design Patterns** in a realistic, state-driven system.

The application models real-world machine behavior, manages user notifications dynamically, and persists usage data through a repository layer backed by a MySQL database.  
While **MVC** is used as a supporting architectural pattern, the core focus of the project is on **behavioral and structural design patterns**, especially **State-driven system design**.

---

## ⚡ System at a Glance

- **State Pattern** controls machine behavior and lifecycle
- **Observer Pattern** keeps the UI reactively synchronized
- **Decorator Pattern** injects health warnings dynamically
- **Repository Pattern** persists brewing history to a database
- **MVC Architecture** cleanly separates UI, logic, and control flow

---

## 🎯 Architectural Motivation

This project was intentionally designed as a **state-driven system** to accurately model real-world machine behavior.

- The **State Pattern** eliminates complex conditional logic by encapsulating behavior within discrete machine states.
- The **Observer Pattern** ensures the system remains reactive without tight coupling between UI and business logic.
- The **Decorator Pattern** enables runtime extension of system messages without modifying core classes.
- **MVC** is used as a *supporting architecture* to keep concerns clearly separated and the codebase maintainable.

The result is a clean, extensible, and easily understandable architecture that scales in complexity without sacrificing readability.

---

## 🎯 Project Features & Capabilities

### 🔹 State Management
- Simulates a real tea machine lifecycle:
  **Empty → Boiling → Brewing → Done**
- Each state defines its own valid actions and transitions

### 🔹 Health Monitoring
- Automatically tracks daily tea consumption
- Warns the user when the daily limit (**10 cups**) is exceeded
- Implemented using the **Decorator Pattern**

### 🔹 Data Persistence
- Logs every brewing cycle to a **MySQL database**
- Tracks historical usage via a repository abstraction

### 🔹 Asynchronous Operations
- Uses **Timers** to simulate boiling and brewing durations
- Prevents UI freezing during long-running operations

---

## 🏗️ Architecture & Design Patterns

This project goes beyond basic examples by combining multiple **architectural** and **design patterns** in a cohesive system.

---

### 1️⃣ Supporting MVC Architecture (Model–View–Controller)

The application follows MVC principles to ensure separation of concerns:

- **Model**  
  `TeaMakerMachine`  
  Contains business logic and manages state transitions.

- **View**  
  `TeaMaker.java`  
  Swing-based graphical user interface observing system changes.

- **Controller**  
  `TeaMakerController.java`  
  Handles user input and coordinates updates between View and Model.

> MVC acts as a **structural foundation**, while system behavior is driven primarily by design patterns.

---

### 2️⃣ Behavioral & Structural Design Patterns

| Pattern | Implementation | Purpose |
|------|---------------|--------|
| **State Pattern** | `State` interface, `BoilingWaterState`, `TeaState`, etc. | Encapsulates machine behavior and removes complex `if-else` logic. |
| **Observer Pattern** | `Subject` and `Observer` interfaces | Automatically updates the GUI when the machine state or message changes. |
| **Decorator Pattern** | `HealthWarningDecorator` wrapping `BaseMessage` | Dynamically appends health warnings when daily tea consumption exceeds the threshold (10 cups). |
| **Repository Pattern** | `TeaLogRepository` | Abstracts all SQL operations from business logic, making the data layer interchangeable. |

---

## 🛠️ Technical Stack

- **Language:** Java (JDK 8+)
- **GUI:** Java Swing (NetBeans-generated)
- **Database:** MySQL 8.0
- **Driver:** MySQL Connector/J
- **Build Tool:** Apache Ant

---

## 📂 Database Setup

The project requires a MySQL database to log tea consumption history.

1. Create a database named:
   ```sql
   teaMakerDB
Run the provided teaMakerDB.sql script to create the required tables.

Update database credentials in:

src/DBConnection.java
private static final String USER = "root";
private static final String PASSWORD = "YOUR_PASSWORD";
🚀 How It Works (Under the Hood)
🔹 Initialization
The machine starts in the EmptyState.

🔹 State Flow
Fill
User fills water → transitions to IdleState

Boil
User clicks Boil → transitions to BoilingWaterState (Timer starts)

Brew
Timer completes → transitions to TeaState

Pour
User pours tea → usage data is logged via TeaLogRepository

🔹 Smart Warnings
Before displaying any message, the system checks daily consumption.

If dailyCups > 10, the HealthWarningDecorator wraps the base message and appends a warning.

🚫 Non-Goals
This project intentionally does not aim to:

Control a real IoT tea machine

Implement production-level concurrency or scaling

Provide a full beverage management system

The focus is strictly on architecture, design patterns, and clean system design.

🔮 Future Improvements
 Dependency Injection
Introduce Spring or Guice to manage TeaLogRepository and DBConnection.

 Unit Testing
Add JUnit tests for State transitions and Decorator behavior.

 Docker Support
Containerize the MySQL database for easier setup.
