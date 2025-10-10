# 📘 Day 5 & Day 6 – DynamoDB Integration

Here IoT Smart Home Dashboard Console Application is connected to DynamoDB Local using AWS SDK v2 (Enhanced Client).

---

##  Tables

### 1. Customers Table
TableName: Customers

Partition Key (PK): customerId (String, UUID)

Attributes:
    - fullName (String)
    - email (String)
    - password (String)

Global Secondary Index (GSI):
    - email-index (PK = email) → used for login queries

---

### 2. Devices Table
TableName: Devices

Partition Key (PK): deviceId (String, UUID)

Attributes:
    - customerId (String → owner reference)
    - model (String)
    - type (String, e.g., TV, AC, Fan)
    - room (String, e.g., BedRoom1, HallWay)
    - status (String: ON/OFF)

Global Secondary Index (GSI):
    - customerId-index (PK = customerId) → used to list all devices for a customer

---

### 3. SensorData Table
TableName: SensorData

Partition Key (PK): deviceId (String)  
Sort Key (SK): timestamp (String, ISO-8601 format, e.g., 2025-10-03T12:30:00Z)

Attributes:
    - sensorType (String, e.g., Temperature, PowerUsage)
    - value (Number or String)
    - expiresAt (Number, Epoch seconds → TTL for auto-expiry)

---

## Integration

Day 5:
- On signup, customer info is stored in Customers
- On device registration, metadata is stored in Devices

Day 6:
- Sensor readings (time-series) are stored in SensorData
- Query by device + timestamp range to get history

Repositories (CustomerRepository, DeviceRepository, SensorDataRepository) handle DynamoDB CRUD operations.  
Services (CustomerService, DeviceService) now persist metadata directly to DynamoDB.

---

## Demo Flow

1. Start DynamoDB Local (localhost:8000)
2. Deploy tables using NoSQL Workbench GUI
3. Run Main.java:
    - Signup → inserts into Customers table
    - Register Device → inserts into Devices table
    - Change Status → updates device status
    - Insert Sensor Data → writes into SensorData table

---

## Deliverable

IoT Application now saves customer, device, and sensor data in DynamoDB Local.  
