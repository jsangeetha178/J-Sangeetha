FROM java:8
ADD build/libs/SpringBootGradleApp1-1.jar dockerapp.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","dockerapp.jar"]