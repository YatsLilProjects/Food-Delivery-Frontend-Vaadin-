FROM openjdk:17
WORKDIR /usr/src/myapp
COPY . /usr/src/myapp/
CMD ["java","-jar","target/fooddeliveryapp-1.0-SNAPSHOT.jar"]
EXPOSE 9595