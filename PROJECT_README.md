# IoT Smart Home Dashboard
**Console-Based Project using Java, Maven, DynamoDB, JUnit, Jenkins, and Docker**
**Batch:** Amazon Atlas Batch 2
**Author:** Shirisha Perapagu


---


## Project Summary


The **IoT Smart Home Dashboard** is a console-based Java application that simulates a smart home automation system.
Users can **sign up, log in, and manage smart devices** such as TVs, ACs, and Fans. The system stores all device and customer data securely in **AWS DynamoDB**, enabling real-time monitoring and control.
It supports **socket-based communication** for device commands and displays a **network topology graph** to visualize device connectivity using BFS traversal.
The codebase includes **JUnit and Mockito testing**, and is fully automated with a **Jenkins CI/CD pipeline** and **Docker containerization**.


This project demonstrates a complete software development lifecycle — from requirements and design to implementation, testing, and DevOps — providing a practical IoT simulation built with enterprise-grade tools.


---


## 1. Requirements Phase


### Objective
To define the scope, functionality, and system expectations for the Smart Home Dashboard.


### Functional Requirements
- User registration and secure login along with validation.
- Register, view, and control smart devices.
- Sends commands to Server for toggling device statuses.
- Store and retrieve user, device and time-series sensor data.
- Display network topology using graph traversal.


### Non-Functional Requirements
- **Scalable:** Handle multiple users and devices.
- **Reliable:** Maintain stable database operations.
- **Secure:** Validate and sanitize inputs.
- **Maintainable:** Follow modular, layered architecture.
- **Automated:** Support CI/CD and containerized deployment.


*Deliverable:* Requirements specification document finalized.


---


## 2. Design Phase


### Objective
To design a modular, layered architecture with clear class responsibilities using **PlantUML** in IntelliJ IDEA.


### Diagrams Designed
- **Class Diagram:** Defined entities like Customer, Device, SensorData, and relationships between them.
- **Activity Diagram:** Represented signup/login → dashboard → device control → logout flow.
- **Sequence Diagram:** Illustrated Client and DeviceServer communication.


*Deliverable:* UML diagrams completed and pushed to repository.


---


## 3. Development Phase


### Objective
To implement all system components based on the design architecture.


### Backend Implementation
- Implemented modular packages:
    - `model` → Entity classes (`Customer`, `Device`, `SensorData`)
    - `repository` → Handles DynamoDB operations
    - `service` → Business logic (register, login, sensor updates)
    - `network` → Socket communication (DeviceServer & Client)
    - `datastructures` → Graph for network topology


### Networking
- Implemented **DeviceServer** to listen on port 12345.
- Added **DeviceNetworkClient** to send `CHANGE_STATUS` commands.
- Enabled two-way simulated communication between server and dashboard.


### DynamoDB Integration
- Used **AWS SDK v2 Enhanced Client** to interact with local DynamoDB.
- Created tables:
    - `Customers`
    - `Devices`
    - `SensorData`
- Implemented CRUD operations (`save`, `update`, `query`) via repositories.


### Graph Data Structure
- Created **Graph**, **Node**, and **GraphBuilderService** to represent IoT topology.
- Added **BFS traversal** for analyzing device connections.
- Added “View Network Topology” feature in the dashboard.


*Deliverable:* Functional Smart Home backend with DynamoDB and Socket integration.




---


## 4. Testing Phase


### Objective
To validate system functionality and reliability using automated unit testing.


### Test Implementation
- Used **JUnit 5** and **Mockito** frameworks.
- Tested all three services:
    - `CustomerServiceTest` → Signup, login, invalid credentials.
    - `DeviceServiceTest` → Register, list, toggle device, simulate network responses.
    - `SensorServiceTest` → Add, query, get latest sensor readings.
- Mocked repositories to simulate DynamoDB interactions.


### Test Results
- All **15 unit tests passed successfully**.
- Handled both success and failure scenarios gracefully.


*Deliverable:* All components verified through unit testing.


---


## 5. DevOps Phase


### Objective
To automate build, test, and deployment using **Jenkins** and **Docker**.


### Jenkins Pipeline
Configured a **declarative Jenkinsfile** with the following automated stages:


| Stage | Description                                                            |
|--------|------------------------------------------------------------------------|
| **Checkout** | Pulls the latest code from GitHub (`IOTSmartHomeProject` branch).      |
| **Build** | Compiles and packages the Java project using Maven.                    |
| **Test** | Executes all JUnit and Mockito test cases.                             |
| **Check DynamoDB** | Verifies if the local DynamoDB instance is running (port 8000).        |
| **Start DeviceServer** | Launches the socket server (port 12345) to simulate IoT communication. |
| **Run Main App** | Executes the Smart Home Dashboard in non-interactive (CI) mode.        |
| **Cleanup** | Stops any running background DeviceServer process after execution.     |




### Dockerization
- Built **Dockerfile** using multi-stage build:
    1. Compile JAR using Maven image
    2. Run lightweight Java image for execution
- Exposed necessary ports (12345 for DeviceServer).
 

---


## 6. Technologies Used


| Category | Tools / Tech |
|-----------|--------------|
| **Language** | Java 17 |
| **Database** | AWS DynamoDB (Local) |
| **Build Tool** | Apache Maven |
| **Testing** | JUnit 5, Mockito |
| **Automation** | Jenkins Pipeline |
| **Containerization** | Docker |
| **IDE** | IntelliJ IDEA |
| **OS** | Windows 10 |


---



## 7. Conclusion Phase


Outcome


- A complete IoT Smart Home Management System that integrates:
- AWS DynamoDB for persistent data storage.
- Socket programming for real-time device simulation.
- Graph structures for network visualization.
- Validation utilities for secure inputs.
- JUnit tests for quality assurance.
- Jenkins pipeline + Docker for DevOps automation.


Key Learnings


- Applying modular architecture in Java.
- Using DynamoDB Enhanced Client with local NoSQL setup.
- Building and testing pipelines with Jenkins.
- Containerizing Java applications with Docker.
- Implementing graph-based data relationships in IoT.


---


## 8. Final Deliverable:


“A Smart Home Dashboard System — successfully designed, developed, tested, and deployed using Java, AWS DynamoDB, and CI/CD automation.”

---



## 9. Project Structure
SmartHomeDashboardProject/
│
├── Day1_Requirements/
│   ├── FunctionalRequirements.md
│   └── NonFunctionalRequirements.md
│
├── Day2_Design_Diagrams/
│   ├── Customer-Device_Class_Diagram.puml
│   ├── Dashboard_Activity_Diagram.puml
│   ├── Gateway_Sequence_Diagram.puml
│   └── Readme.md
│
├── Day3_JavaAPI/
│   └── Readme.md
│
├── Day4_Networking/
│   └── Readme.md
│
├── Day5 & Day6_DynamoDB/
│   └── Readme.md
│
├── Day7_DataStructures/
│   └── Readme.md
│
├── Day8_BDD_Testing/
│   └── Readme.md
│
├── Day9_DevOps/
│   └── Readme.md
│
│
├── src/
│   ├── main/java/org/example/smartHome/
│   │   ├── model/
│   │   │   ├── Customer.java
│   │   │   ├── Device.java
│   │   │   └── SensorData.java
│   │   │
│   │   ├── repository/
│   │   │   ├── CustomerRepository.java
│   │   │   ├── DeviceRepository.java
│   │   │   └── SensorDataRepository.java
│   │   │
│   │   ├── service/
│   │   │   ├── CustomerService.java
│   │   │   ├── DeviceService.java
│   │   │   └── SensorService.java
│   │   │
│   │   ├── network/
│   │   │   ├── DeviceServer.java
│   │   │   └── DeviceNetworkClient.java
│   │   │
│   │   ├── datastructures/
│   │   │   ├── Graph.java
│   │   │   ├── Node.java
│   │   │   └── GraphBuilderService.java
│   │   │
│   │   ├── util/
│   │   │   └── ValidationUtil.java
│   │   │
│   │   ├── ui/
│   │   │   ├── DeviceMenuHandler.java
│   │   │   └── SensorMenuHandler.java
│   │   │
│   │   └── Main.java
│   │
│   └── test/java/org/example/smartHome/service/
│       ├── CustomerServiceTest.java
│       ├── DeviceServiceTest.java
│       └── SensorServiceTest.java
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md




---


## 10. **Project Status:** Completed Successfully



---












