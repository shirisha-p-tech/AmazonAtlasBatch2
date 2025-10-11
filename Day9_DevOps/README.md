# Day 9 – DevOps: CI/CD Automation and Dockerization

## Objective
Implement **DevOps automation** for the Smart Home Java Dashboard using:
- **Jenkins** for Continuous Integration (CI)
- **Docker** for containerization
- **Maven + JUnit** for build and test automation
- **Local DynamoDB** for persistence

---

## Overview
This phase integrates **build → test → verify → deploy** into a single automated pipeline.  
The pipeline:
1. Pulls code from GitHub
2. Builds and tests the project using Maven
3. Checks DynamoDB availability
4. Starts the `DeviceServer` automatically
5. Runs the Smart Home Dashboard app
6. Cleans up resources after execution


---

##
Tools & Technologies

| Tool | Purpose |
|------|----------|
| **Jenkins** | Continuous Integration (pipeline orchestration) |
| **Maven** | Build, dependency management, and testing |
| **JUnit 5 & Mockito** | Automated unit testing |
| **Docker** | Packaging app into containers |
| **DynamoDB Local** | Local NoSQL database for persistence |
| **GitHub** | Source control and Jenkins integration |


---

## Project Summary
This phase integrates **continuous integration and deployment** (CI/CD) for your Smart Home application.  
The Jenkins pipeline automates every step — from **GitHub checkout → Build → Test → Verify DynamoDB → Start Server → Run App → Cleanup**.  
You also Dockerized the dashboard for portable deployment.


---

## Pipeline Summary - `Jenkinsfile`

**Stages Executed Automatically in Jenkins:**

| Stage | Description                                       | Status |
|-------|---------------------------------------------------|-------|
| **Checkout from GitHub** | Clones branch `IOTSmartHomeProject`               | Done  |
| **Build Project** | Compiles and packages the app into a JAR          | Done  |
| **Run Unit Tests** | Executes all JUnit and Mockito tests              | Done  |
| **Check DynamoDB Connection** | Verifies if local DynamoDB (port 8000) is running | Done  |
| **Start DeviceServer** | Launches socket server on port 12345              | Done  |
| **Run Main App** | Runs the Smart Home Dashboard in Jenkins CI mode  |  Done |
| **Cleanup** | Stops background processes (DeviceServer)         | Done  |



---


## Build Artifact
After a successful pipeline run:

    target/
        │── SmartHomeDashboardProject-1.0-SNAPSHOT.jar

This JAR is your deployment artifact and can run inside a VM or Docker container.

---

## Dockerization - `Dockerfile`

A multi-stage Docker build was implemented:
- Stage 1 → Maven builds and packages the JAR
- Stage 2 → Lightweight runtime container runs the app
- Exposes port **12345**

---


## Pipeline ResultsNon-Interactive Mode for CI

In Main.java, interactive menus are skipped inside Jenkins or Docker:
if (System.getenv("JENKINS_HOME") != null) {
System.out.println("Running in Jenkins CI environment — skipping interactive menu.");
return;
}

This prevents the pipeline from blocking for keyboard input.

---

## Pipeline Results

- End-to-end Jenkins automation verified
- All unit tests passed
- Docker image builds successfully
- DynamoDB health check integrated
- DeviceServer auto-starts and cleans up

---

## Post Actions

After each pipeline run Jenkins automatically:
Terminates DeviceServer processes (java.exe)
Archives test reports & logs for reference

---



## Deliverable

Fully automated build + deploy pipeline successfully running in Jenkins and Docker.

---






