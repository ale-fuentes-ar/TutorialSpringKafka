# Intro to Kafka with Spring
![](https://img.shields.io/badge/by-Alejandro.Fuentes-informational?style=flat&logoColor=white&color=cdcdcd)
![](https://img.shields.io/badge/Attention-Project_In_Construction-informational?style=flat&logoColor=white&color=red)

Hi guys, in this project I do a simple two projects where see how to Spring use kafka, with a production-api a one consumer-api.

> Note: when execute docker cmd, make sure to start Docker Desktop.


For execute Kafka enviroment, can be use to `dc-kafka-container.yml`
```bash
docker-compose -f dc-kafka-container.yml up --build -d

# after started, we can see its healft in cmd
docker ps
CONTAINER ID   IMAGE                    COMMAND                  CREATED          STATUS          PORTS                                                NAMES
27d64d35f86e   wurstmeister/kafka       "start-kafka.sh"         14 minutes ago   Up 13 minutes   0.0.0.0:9092->9092/tcp                               kafka
dbe1cfc09803   wurstmeister/zookeeper   "/bin/sh -c '/usr/sb…"   14 minutes ago   Up 14 minutes   22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp   zookeeper
```

### stop container
For stop all container the use in in this tutorial, can be type in CMD:
```bash
# for see our containers
docker ps

# the console show this
CONTAINER ID   IMAGE                    COMMAND                  CREATED          STATUS          PORTS                                                NAMES
27d64d35f86e   wurstmeister/kafka       "start-kafka.sh"         14 minutes ago   Up 13 minutes   0.0.0.0:9092->9092/tcp                               kafka
dbe1cfc09803   wurstmeister/zookeeper   "/bin/sh -c '/usr/sb…"   14 minutes ago   Up 14 minutes   22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp   zookeeper

# for stop, use name of container
docker stop kafka zookeeper

# the console show this
kafka
zookeeper

# after it, for see if container is stoped
docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

```