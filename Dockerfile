# ---------- Stage 1: Build ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy Maven files first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Stage 2: Runtime ----------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/target/SmartHomeDashboardProject-1.0-SNAPSHOT.jar app.jar

# Environment variables for DynamoDB Local (NoSQL Workbench)
ENV DYNAMO_ENDPOINT=http://host.docker.internal:8000

# Expose the DeviceServer port
EXPOSE 12345

# Default command = Smart Home Dashboard (Main)
CMD ["java", "-cp", "app.jar", "org.example.smartHome.Main"]
