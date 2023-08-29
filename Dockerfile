#FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
#FROM registry.access.redhat.com/ubi8/openjdk-11:1.14-11
#FROM enterprisequay.hbctxdom.com/prarambh/openjdk-11:1.14-11
FROM openjdk:17-oracle
#USER 0
#RUN microdnf update --nodocs -y
#RUN microdnf clean all

COPY /tmp/build/inputs/build/libs/guvvalas-content-api-services-0.0.1-SNAPSHOT.jar ../../guvvalas-content-api-services-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/guvvalas-content-api-services-0.0.1-SNAPSHOT.jar"]