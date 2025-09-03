FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml first for better Docker layer caching
COPY pom.xml .

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application (this will create the JAR file)
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/java-app-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
