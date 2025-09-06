
git# Functional Requirements

## 1. Customer Management
- The system should allow new customers to register.
- The system allows customers to log in using email and password.

## 2. Device Control
- The system shall allow customers to control the following devices:
    - TV (Samsung, Sony)
    - AC (LG, Voltas, Blue Star)
    - Fan (Atomberg, Crompton)
    - Robo Vac & Mop (only one model)
- The system shall support device control per room:
    - Hallway, BedRoom1, BedRoom2, BedRoom3

## 3. Device Status
- Customers can view the current On/Off status of each device.
- Customers can change device status from Off to On and vice versa.

## 4. Data Management
- Customer metadata and device information will be stored in DynamoDB.
- Sensor data will be saved as time-series data.

## 5. Dashboard Interface
- A console-based UI will provide options for login, control, and viewing devices.

## 6. Networking
- Socket programming will simulate device communication (sending/receiving commands).

## 7. Device Topology
- A graph data structure will represent device connectivity and relationships.

## 8. DevOps
- The application will be Dockerized.
- Jenkins pipeline will automate build, test, and deployment to VM.
