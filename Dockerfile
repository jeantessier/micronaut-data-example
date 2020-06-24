FROM openjdk:14-alpine
COPY build/libs/micronaut-data-example-*-all.jar micronaut-data-example.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-data-example.jar"]
