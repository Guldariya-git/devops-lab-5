FROM openjdk:11

WORKDIR /app

COPY app/target/*.jar app.jar

EXPOSE 5000

CMD ["java", "-jar", "app.jar"]
