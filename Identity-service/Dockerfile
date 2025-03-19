# Use official OpenJDK as base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder into the container
COPY target/Identity-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the service port
EXPOSE 7001

# Run the application
CMD ["java", "-jar", "app.jar"]