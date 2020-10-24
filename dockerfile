FROM openjdk:8u191-jre-alpine3.8

#workspace
WORKDIR /usr/share/udemy

RUN apk add curl jq

#ADD .jars under target from host into this image
ADD target/testproj-0.0.1-SNAPSHOT.jar testproj-0.0.1-SNAPSHOT.jar
ADD target/testproj-0.0.1-SNAPSHOT-tests.jar  testproj-0.0.1-SNAPSHOT-tests.jar
ADD target/libs libs
ADD resources resources
ADD testng.xml testng.xml
ADD BrowserDrivers BrowserDrivers
ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh
