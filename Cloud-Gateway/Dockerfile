# Use official OpenJDK as base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder into the container
COPY target/Cloud-Gateway-0.0.1-SNAPSHOT.jar app.jar

# Expose the service port
EXPOSE 7009

# Run the application
CMD ["java", "-jar", "app.jar"]