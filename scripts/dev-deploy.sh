#!/bin/bash

REPOSITORY=/home/ec2-user/official-gsm-client-server

cd $REPOSITORY

docker build --platform linux/arm64 -t official-test-server:client .

docker-compose up -d

docker image prune