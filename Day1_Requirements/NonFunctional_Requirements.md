# Non-Functional Requirements

## 1. Performance
- Device commands should execute in under 1 second.
- Dashboard should load in under 2 seconds.

## 2. Scalability
- System supports up to 100 devices per user.
- High-write throughput support for DynamoDB.

## 3. Security
- Passwords must be stored using secure hashing.
- Only logged-in users can access control features.

## 4. Availability
- The system should have 99.9% uptime.
- One device's failure must not affect others.

## 5. Usability
- Console menu must be intuitive and easy to navigate.
- Every user’s action will return a clear success or failure message.

## 6. Maintainability
- Code will follow Java coding standards.
- Modularity and separation of concerns will be applied.

## 7. Testability
- JUnit or Cucumber (TBD) for unit and integration testing.

## 8. Portability
- The application runs on Java 17+.
- Docker support allows cross-platform deployment.

## 9. Reliability
- Handles socket communication failures gracefully.
- Device data retries if DynamoDB is temporarily down.
