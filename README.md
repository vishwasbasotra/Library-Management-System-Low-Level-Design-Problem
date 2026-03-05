# 📚 Library Management System (LMS)

A robust, enterprise-grade Library Management System implemented in Java. This project demonstrates advanced **Object-Oriented Programming (OOP)**, strict adherence to **SOLID principles**, and the implementation of key **Design Patterns** to solve complex library workflows such as multi-branch inventory, book reservations, and member recommendations.

---

## 🏗️ Architecture & Design Patterns

The system is designed to be highly modular and extensible. Below are the design patterns utilised to achieve this:

| Pattern | Usage in this Project | Benefit |
| :--- | :--- | :--- |
| **Strategy** | Applied to Search (`TitleSearch`, `AuthorSearch`, `ISBNSearch`). | Allows adding new search algorithms without modifying the core system. |
| **Observer** | Applied to the Reservation/Notification system. | Automatically alerts patrons when a reserved book is returned without tight coupling. |
| **Factory** | Applied to `PatronFactory`. | Centralises the creation logic for different member types (Student vs. Faculty). |
| **Facade** | Applied to `LibrarySystem`. | Provides a simplified, single interface to interact with multiple complex services. |

---

## 📊 Class Diagram

The following diagram illustrates the relationships between core entities and services. Note how the `LibrarySystem` coordinates various services while the `SearchStrategy` remains decoupled from the `InventoryService`.



---

## 🚀 Key Features

### 1. Multi-Branch Support
The system manages multiple `Branch` locations. Books can be tracked per branch, and the `BranchService` handles the logic for transferring inventory between locations (e.g., from "Downtown" to "Uptown").

### 2. Reservation & Notification
If a book is currently **BORROWED**, a patron can place a reservation. The system maintains a `PriorityQueue` of patrons. When the book is returned via the `LendingService`, the `ReservationService` (acting as an Observer) is triggered to notify the first patron in the queue.



### 3. Recommendation Engine
The `RecommendationService` analyzes a patron's `LendingRecord` history to identify their most-borrowed genre. It then suggests available books from the same category to improve user engagement.

---

## 🛠️ How to Build and Run

### Prerequisites
* **JDK 17+** (Recommended)
* A terminal or command prompt

### Compilation
From the root of the source directory, compile all classes:

```bash
javac com/library/LibrarySystem.java
```

---

## 📂 Project Structure

The project follows a standard Java package structure to maintain a clean separation of concerns:

```plaintext
src/main/java/com/library/
├── LibrarySystem.java           # Entry point & Facade
├── model/                       # Core Data Entities (POJOs)
│   ├── Book.java
│   ├── Branch.java
│   ├── Patron.java
│   ├── LendingRecord.java
│   └── BookStatus.java
├── service/                     # Business Logic & Orchestration
│   ├── LendingService.java
│   ├── ReservationService.java
│   ├── InventoryService.java
│   ├── RecommendationService.java
│   └── BranchService.java
├── search/                      # Strategy Pattern Implementations
│   ├── SearchStrategy.java
│   ├── TitleSearch.java
│   ├── AuthorSearch.java
│   └── ISBNSearch.java
├── factory/                     # Object Creation Logic
│   └── PatronFactory.java
├── observer/                    # Observer Interfaces
│   └── ReservationObserver.java
└── exception/                   # Custom Domain Exceptions
    ├── BookNotFoundException.java
    └── InsufficientPrivilegesException.java
