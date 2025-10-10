# Day 8 – JUnit Testing & BDD

## Objective
Implement Behavior-Driven Unit Testing for all service layers using **JUnit 5** and **Mockito**.

---

## Tested Components

| Service Layer | Test Class | Coverage Summary |
|----------------|-------------|------------------|
| `CustomerService` | `CustomerServiceTest.java` | Registration (success/failure), Login (valid, invalid, not found) |
| `DeviceService` | `DeviceServiceTest.java` | Device registration, Listing devices, Status toggle (success/failure via mock network) |
| `SensorService` | `SensorServiceTest.java` | Add sensor data, Query range, Fetch latest readings, Handle empty responses |

---

## Frameworks Used
- **JUnit 5 (Jupiter):** For writing structured test cases.
- **Mockito:** To mock dependencies (e.g., DynamoDB Repositories).
- **Mockito JUnit Jupiter Extension:** Enables `@Mock` and `@InjectMocks` annotations.

---

## Setup
No database or network connection is required —  
all DynamoDB and network calls are **mocked** using Mockito.

Run tests using Maven: *mvn test*

## Example Output

[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.smartHome.service.CustomerServiceTest
[INFO] Running org.example.smartHome.service.DeviceServiceTest
[INFO] Running org.example.smartHome.service.SensorServiceTest
[INFO]
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS
[INFO] -------------------------------------------------------

---

## Deliverables

- Complete unit test suite for all service layers
- Mocked repositories — no live DynamoDB dependency
- Clear test naming and readable BDD-style structure
- Verified successful build with all tests passing (BUILD SUCCESS)


## Project Structure (Testing Focus)

FirstProject/
│
├── src/
│   ├── main/java/org/example/smartHome/service/
│   │   ├── CustomerService.java
│   │   ├── DeviceService.java
│   │   └── SensorService.java
│   │
│   └── test/java/org/example/smartHome/service/
│       ├── CustomerServiceTest.java
│       ├── DeviceServiceTest.java
│       └── SensorServiceTest.java
│
└── Day8_JUnit_Testing/
    └── README.md





