FROM amazoncorretto:17

MAINTAINER romanmartinez

COPY target/romanm-0.0.1-SNAPSHOT.jar romanm-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/romanm-0.0.1-SNAPSHOT.jar"]