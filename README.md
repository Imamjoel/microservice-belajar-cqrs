# microservice-belajar-cqrs

CREATE NETWORK IN DOCKER
sudo docker network create --attachable -d overlay belajar

CREATE CONTAINER AXON-SERVER IN DOCKER 
sudo docker run -it -d --name axon-server -p 8024:8024 -p 8124:8124 --network belajar --restart always axoniq/axonserver:latest

CREATE CONTAINER MONGODB IN DOCKER
sudo docker run -it -d --name mongo-container -p 27017:27017 --network belajar --restart always -v mongo_data_container:/data/db mongo:latest

CREATE CONTAINER MYSQL IN DOCKER
sudo docker run-it -d --name mysql-container -p 3306:3306 --network belajar -e MYSQL_ROOT_PASSWORD=root --restart always -v mysql_data_container:/var/lib/mysql mysql:latest

CREATE CONTAINER MYSQL CLIENT IN DOCKER
sudo docker run -it -d --name adminer -p 8080:8080 --network belajar -e ADMINER_DEFAULT_SERVER=mysql-container --restart always adminer:latest

DOWNLOAD IMAGE IN DOCKER HUB 
https://hub.docker.com/u/joel007 open tag next pull image

CREATE CONTAINER USE IMAGE FROM PULL
example, please see name image docker afer pull
sudo docker run -d -p 8084:8084 --name user.security --network belajar -e "SPRING_PROFILES_ACTIVE=docker" --restart always joel007/microservice-cqrs:user.security

After create container, demo project in postman or etc..

--register
http://localhost:8083/api/v1/registerUser

{
  "user": {
    "firstname": "joel",
    "lastname": "cr7",
    "emailAddress": "joel@gmail.com",
    "account": {
        "username": "joelcr7",
        "password": "pass1",
        "roles": [
            "READ_PRIVILEGE", "WRITE_PRIVILEGE"
        ]
    }
  }

}


--login
http://localhost:8084/oauth/token


