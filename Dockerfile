FROM openjdk:17
ADD /target/MeetUp-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]