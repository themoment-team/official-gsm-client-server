 Setting JDK 17 with amazoncorretto
FROM amazoncorretto:17

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# gradle dependency caching with docker cache
ADD build.gradle ./
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

# client application jar file
ARG JAR_FILE=build/libs/official-gsm-client-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ./OfficialGsm-0.0.1.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/OfficialGsm-0.0.1.jar"]