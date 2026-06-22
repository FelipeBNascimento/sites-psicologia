# Usar uma imagem base com Java 17
FROM eclipse-temurin:17-jre-jammy

# Copiar o arquivo jar gerado pelo Gradle para dentro do container
COPY build/libs/*.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]