# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR built by Maven into the container
COPY target/SmartHomeDashboardProject-1.0-SNAPSHOT.jar app.jar

# Expose ports (DynamoDB Local: 8000, DeviceServer: 12345)
EXPOSE 12345 8000

# Set environment variables to detect Docker and DynamoDB endpoint
ENV IS_DOCKER=true
ENV DYNAMODB_ENDPOINT=http://host.docker.internal:8000
ENV DEVICE_SERVER_HOST=host.docker.internal

# Command to run the Smart Home app
ENTRYPOINT ["java", "-cp", "app.jar"]
CMD ["org.example.smartHome.Main"]
