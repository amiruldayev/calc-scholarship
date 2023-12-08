# Используем официальный образ OpenJDK для Java 17
FROM openjdk:17-oracle

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл build/libs/your-application-name.jar из локальной директории Gradle проекта в контейнер
COPY gradle/sis2121-0.0.1-SNAPSHOT.jar .

# В случае, если вам нужны дополнительные зависимости или ресурсы, скопируйте их в контейнер
# COPY src/main/resources /app/resources

# Указываем порт, который будет прослушивать наше приложение
EXPOSE 8080

# Команда, которая будет выполняться при запуске контейнера
CMD ["java", "-jar", "sis2121-0.0.1-SNAPSHOT.jar"]