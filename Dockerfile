# Etapa 1: Build da aplicação
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final com Java 21
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o jar gerado
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Inicia a aplicação Spring Boot

# Produção
CMD ["java", "-jar", "app.jar"]

# Desenvolvimento
#CMD ["./mvnw", "spring-boot:run"]