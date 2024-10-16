Co 3 containers:
- SQL Server 2019
- SQL Server 2017
- Ubuntu 20(nginx)

Cho chung vao 1 network(docker-network-c2002l)
Viet 2 cau lenh dai => cho het 1 file "Docker compose" dang yaml

docker rm -f sql-server-2019-c2002l
docker rm -f sql-server-2017-c2002l

docker network ls
docker network create c2002l-docker-network

docker-compose -f ./myDockerCompose.yaml up
docker-compose -f ./myDockerCompose.yaml stop
