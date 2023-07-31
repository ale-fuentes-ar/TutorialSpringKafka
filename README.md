# Intro to Kafka with Spring
![](https://img.shields.io/badge/by-Alejandro.Fuentes-informational?style=flat&logoColor=white&color=cdcdcd)
![](https://img.shields.io/badge/Attention-Project_In_Construction-informational?style=flat&logoColor=white&color=red)

Hi guys, in this project I do a simple two projects where see how to Spring use kafka, with a production-api a one consumer-api.

> Note: when execute docker cmd, make sure to start Docker Desktop.


For execute Kafka enviroment, can be use to `dc-kafka-container.yml`
```bash
docker-compose -f dc-kafka-container.yml up --build -d

# see how response
[+] Running 3/3
 ✔ Network tutorialkafkafromspring_default  Created                                                                                                                          0.0s
 ✔ Container zookeeper                      Started                                                                                                                          0.4s
 ✔ Container kafka                          Started   
 
# after started, we can see its healft in cmd
docker ps
CONTAINER ID   IMAGE                    COMMAND                  CREATED          STATUS          PORTS                                                NAMES
27d64d35f86e   wurstmeister/kafka       "start-kafka.sh"         14 minutes ago   Up 13 minutes   0.0.0.0:9092->9092/tcp                               kafka
dbe1cfc09803   wurstmeister/zookeeper   "/bin/sh -c '/usr/sb…"   14 minutes ago   Up 14 minutes   22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp   zookeeper
```

### Some command CMD of kafka
For testing using CMD, after the running our container, we can use commnad.
For this test, need to use two consoles.

**In one console CLI for producer**
<br>
*dont close this console after finish command, because in here we send future message*
```bash
# connect to bash container's kafka
docker exec -it kafka /bin/bash

# go to kafka's path: cd opt/<kafka_with_vesrion>/bin
cd opt/kafka_2.13-2.8.1/bin/

# first create a topic called 'sametopic', indicate in what zookeeper server, with 1 replica and in 1 partition
kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic sampletopic
Created topic sampletopic.

# start producer
kafka-console-producer.sh --topic sampletopic --bootstrap-server kafka:9092
> 
```

**In another console CLI for consumer**
```bash
# connect to bash container's kafka
docker exec -it kafka /bin/bash

# go to kafka's path: cd opt/<kafka_with_vesrion>/bin
cd opt/kafka_2.13-2.8.1/bin/

# start to consumer the topic 'sametopic'
kafka-console-consumer.sh --topic sampletopic --from-beginning --bootstrap-server kafka:9092
```

**Now send message**
<br>
Now we can send message from CLI producer and see how print this same message in CLI consumer

```bash
# type some message in CLI producer
> Hello, this is a small test in sampletopic

# we can see this same message in CLI consumer
Hello, this is a small test in sampletopic
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