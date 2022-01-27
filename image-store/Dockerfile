FROM openjdk:11

COPY build/libs/*.jar image-store.jar

EXPOSE 8086 8006

ENTRYPOINT [ "java", "-jar", "image-store.jar"]
