# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR built by Maven into the container
COPY target/SmartHomeDashboardProject-1.0-SNAPSHOT.jar app.jar

# Expose ports (DynamoDB Local: 8000, DeviceServer: 12345)
EXPOSE 12345

# Command to run the Smart Home app
CMD ["java", "-jar", "app.jar"]
