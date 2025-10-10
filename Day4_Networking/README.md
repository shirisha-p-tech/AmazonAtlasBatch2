# Day 4 – Networking Simulation

## Objectives
- Simulate IoT device communication using **Java Sockets**.
- Implement:
    - `DeviceServer` → TCP server
    - `DeviceNetworkClient` → TCP client

## How It Works
1. **DeviceServer** (runs on port `12345`)
    - Accepts client connections
    - Receives commands like `CHANGE_STATUS <deviceId>`
    - Responds with `"SUCCESS"` or `"ERROR"`

2. **DeviceNetworkClient**
    - Connects to server using sockets
    - Sends command
    - Reads server response

3. **Integration**
    - `DeviceService.changeDeviceStatus()` sends command via `DeviceNetworkClient`
    - On `"SUCCESS"`, status updated in the app

## Demo Flow
1. Start **DeviceServer** in a separate terminal:
2. Run **Main.java**:
- Signup / Login
- Register a device
- Change device status → Client sends command → Server confirms

## Deliverable
- Functional **console app with networking simulation**.
- Device status toggling works via server-client socket communication.
