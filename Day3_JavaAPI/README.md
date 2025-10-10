# Day 3 – Java API & Project Structure

## Objectives
- Set up **Maven project structure** (`src/main/java`, `src/test/java`).
- Create **domain models**:
    - `Customer` (signup/login user)
    - `Device` (smart device metadata)
    - `DeviceStatus` (enum: ON/OFF)
- Implement **services**:
    - `CustomerService` → signup, login, email checks
    - `DeviceService` → register, list, toggle devices
- Add **utility**:
    - `ValidationUtil` → email & password validation
- Build **UI handler**:
    - `DeviceMenuHandler` → console menu for device registration
- Implement **Main.java** as console dashboard.

## Key Points
- Customers can **signup/login** with email + password validation.
- Devices are managed in memory via `DeviceService`.

## Deliverable
- Working console dashboard with signup, login, register devices, and simple device listing.
