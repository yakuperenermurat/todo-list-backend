# Temel Java 17 image
FROM openjdk:17-jdk-slim

# Maven için image ekliyoruz (Maven build otomatik olacak)
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Uygulama için çalışma dizini
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/todo-list-0.0.1-SNAPSHOT.jar app.jar

# Port Açıklama
EXPOSE 8080

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "app.jar"]