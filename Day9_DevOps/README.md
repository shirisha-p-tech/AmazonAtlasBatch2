# Day 9 – DevOps: CI/CD Automation and Dockerization

##  Objective

Dockerize the Smart Home Dashboard and automate the CI/CD pipeline using **Jenkins**, **Maven**, and **Docker Desktop**.
This step demonstrates full automation — building, testing, packaging, and deploying the project as Docker containers.

---

## Tools & Technologies Used

| Tool                                      | Purpose                                                    |
| ----------------------------------------- | ---------------------------------------------------------- |
| **Java 17**                               | Application development language                           |
| **Maven**                                 | Build tool for packaging & dependency management           |
| **JUnit 5 + Mockito**                     | Unit testing and mocking framework                         |
| **AWS SDK v2 (DynamoDB Enhanced Client)** | Database interaction with DynamoDB Local (NoSQL Workbench) |
| **Docker**                                | Containerization of the application                        |
| **Docker Compose**                        | Multi-container orchestration (DeviceServer + Dashboard)   |
| **Jenkins**                               | CI/CD automation for build, test, and deploy pipeline      |
| **PowerShell**                            | Manual testing of containers and logs                      |


---

## Project Structure Overview

The application is composed of **two main modules** that communicate via sockets:

| Module                 | Description                                                                                |
| ---------------------- | ------------------------------------------------------------------------------------------ |
| **DeviceServer**       | Receives device control commands (status ON/OFF) over port **12345**                       |
| **SmartHomeDashboard** | Main console application for user interaction, device management, and sensor data handling |

---

## Jenkinsfile – CI/CD Pipeline

1. **Checkout** → Pulls the latest code from GitHub (`IOTSmartHomeProject`)
2. **Build with Maven** → Compiles and packages the app into a **fat JAR**
3. **Run Unit Tests** → Executes all JUnit + Mockito test cases
4. **Build Docker Image** → Creates a Docker image for the app
5. **Deploy to Docker Desktop** → Spins up both containers using Docker Compose

---

## Build Artifact
After a successful pipeline run:

    target/
        │── SmartHomeDashboardProject-1.0-SNAPSHOT.jar

This fat JAR is your deployment artifact and can run inside a VM or Docker container.


---

## Dockerfile (Multi-Stage Build)


* Stage 1: Uses Maven image to **build and package** the project
* Stage 2: Uses a smaller runtime image (JDK only) to **run the app**
* Reduces final image size & improves build performance
* Exposes **port 12345** for the DeviceServer

---

## docker-compose.yml

* Defines **two services**:

    * `device-server`: backend that listens for device commands
    * `smart-home-dashboard`: main console dashboard app
* Both run on a shared custom Docker network `iot-net`
* Uses the environment variable `DEVICE_SERVER_HOST=device-server` for inter-container communication

---

## Steps to Run

### Option 1: Run via Jenkins

1. Open Jenkins
2. Build the pipeline (this runs all Maven + Docker steps)
3. View results under console output
4. Verify containers:

   ```powershell
   docker ps
   ```

---

### Option 2: Run manually via PowerShell

1. Create a Docker network manually:

   ```powershell
   docker network create iot-net
   ```
2. Start the `DeviceServer`:

   ```powershell
   docker run --rm --name device-server --network iot-net smart-home-dashboard-image:latest java -cp app.jar org.example.smartHome.network.DeviceServer
   ```
3. In another terminal, start the main app:

   ```powershell
   docker run -it --rm --name smart-home-dashboard --network iot-net -e DEVICE_SERVER_HOST=device-server smart-home-dashboard-image:latest java -cp app.jar org.example.smartHome.Main
   ```

---

## Key Learnings

* Automated CI/CD pipeline with **Jenkins + Docker**
* Created lightweight **multi-stage Docker build**
* Used **Docker Compose** for service orchestration
* Integrated **DynamoDB Local** via NoSQL Workbench
* Verified end-to-end interaction between containers in PowerShell

---

## Deliverable

Fully automated built + tested + deploy pipeline successfully running in Jenkins and Docker.


---

