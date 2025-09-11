FROM maven:3.9.5-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY . ./

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application with a lightweight JDK 21 runtime
FROM eclipse-temurin:21-jre-alpine

# Set the working directory for the runtime container
WORKDIR /app

# Copy the application JAR from the build stage
COPY --from=build /app/target/*.jar RnD-CodingBattle.jar

# Expose port 8080 for the application
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "RnD-CodingBattle.jar"]