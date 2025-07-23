FROM openjdk:21

LABEL maintainer="brhanebt01@gmail.com"

WORKDIR /app

COPY target/abooks-0.0.1-SNAPSHOT.jar /app/abooks-docker-v001.jar

ENTRYPOINT ["java","-jar","abooks-docker-v001.jar"]

# docker build -t abooks .
# docker build -t abooks:0.01.RELEASE .
# docker run -p 8081:8081 abooks
# http://localhost:8081/api/v1/books
# docker run -p 8080:8081 abooks
# http://localhost:8080/api/v1/books

# docker run -p 8080:8081 -d abooks
# docker logs -f e1f9 
# e1f9 is CONTAINER id first four digits

# docker stop e1f9

#To list only the latest 3 Docker images

#docker images --format "{{.Repository}}:{{.Tag}}" | head -n 3
#docker images | head -n 3
# to list the latest 3 containers:
#docker ps -a --format "table {{.ID}}\t{{.Image}}\t{{.Status}}" | head -n 3
#docker ps -a | head -n 3

#docker login

#docker tag abooks brhanebt/abooks:0.01.RELEASE
#docker push brhanebt/abooks:0.01.RELEASE
#docker pull brhanebt/abooks:0.01.RELEASE
#docker pull mysql:oraclelinux9
#docker pull mysql
#docker run -p 3307:3306 --name localhost -e MYSQL_ROOT_PASSWORD=Mysql@123 -e MYSQL_DATABASE=customer_db -e MYSQL_USER=briebt -e MYSQL_PASSWORD=briebt -d mysql:latest
#docker ps | head -n 3
#docker exec -it localhost bash
#mysql -u root -p

#docker rmi -f d574463b2855