# Base image
FROM maven:latest as build

# Define a pasta de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml para baixar as dependências primeiro
COPY pom.xml .

# Baixa as dependências do Maven (somente dependências)
RUN mvn dependency:go-offline

# Copia todo o código fonte para dentro do container
COPY src ./src

# Constrói o projeto com Maven
RUN mvn package -DskipTests

# Estágio de produção
FROM openjdk:latest

# Define a pasta de trabalho dentro do container
WORKDIR /app

# Copia o JAR construído do estágio anterior para dentro do container
COPY --from=build /app/target/*.jar app.jar

# Expor a porta 8080 do container
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot
CMD ["java", "-jar", "app.jar"]
