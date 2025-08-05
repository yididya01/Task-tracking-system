# TaskTracker

## 📝 Overview

**TaskTracker** is a Java-based task management system that allows users to create, track, and manage tasks through a clean object-oriented architecture. It uses DAO design patterns, custom interfaces, and a modular approach to provide extensibility and maintainability.

---

## 🚀 Features

- User types (e.g., StandardUser)
- Task creation, status updates, and tracking
- Earn points for task completion (via `PointEarnable` interface)
- Modular design with abstraction and interfaces
- In-memory data management using DAO pattern
- Exception handling and logging capabilities

---

## 📂 Project Structure

```
tasktracker/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/ttracker/
                ├── Main.java
                ├── abstracts/           # Base abstract classes
                ├── dao/                # Data Access Objects
                ├── interfaces/         # Interfaces for extensibility
                └── models/             # Task, User, Status models
```

---

## 🛠️ Technologies Used

- Java 11+
- Maven
- OOP Principles (Abstract Classes, Interfaces, Inheritance)
- File I/O
- Terminal-based Interaction

---

## 📦 How to Build & Run

### 💻 Prerequisites

- Java JDK 11 or newer
- Maven

### 🔧 Build

```bash
cd tasktracker/tasktracker
mvn clean install
```

### ▶️ Run

```bash
mvn exec:java -Dexec.mainClass="com.ttracker.Main"
```

> Make sure to be inside the `tasktracker/tasktracker` directory for Maven to find the `pom.xml`.

---

## 🧪 Sample Classes

- **Task.java**: Represents individual tasks with status and metadata
- **StandardUser.java**: Represents users who interact with tasks
- **TaskDAO.java**: Handles task data operations
- **PointEarnable.java**: Interface for users earning points

--- 

## 👥 Contributors

- Abel
- Kidus
- Yididya
- Ragad
- Siraj
---
