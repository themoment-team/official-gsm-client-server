#!/bin/bash

REPOSITORY=/home/ec2-user/official-gsm-client-server

cd $REPOSITORY

docker build -t official-test-server:client .

docker-compose up -d

docker rmi $(docker images -f "dangling=true" -q)