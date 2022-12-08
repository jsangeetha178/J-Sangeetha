FROM openjdk:8-jre-alpine
COPY  jrt-fs.jar jre/lib/jrt-fs.jar
CMD ["java","-jar","jre/lib/jrt-fs.jar"]
EXPOSE 8080
RUN apk --update --no-cache add curl
