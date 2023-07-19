#!/bin/bash

# 배포 그룹 이름을 확인합니다. (CodeDeploy 환경 변수를 사용)
DEPLOYMENT_GROUP_NAME=$(echo $DEPLOYMENT_GROUP_NAME)

# 배포 그룹에 따라 다른 작업을 수행합니다.
if [ "$DEPLOYMENT_GROUP_NAME" == "official-client-test-server" ]; then
  # official-client-test-server 배포 그룹에 대한 스크립트 실행
  echo "Running dev-deploy.sh..."
  /home/ec2-user/official-gsm-client-server/scripts/dev-deploy.sh
elif [ "$DEPLOYMENT_GROUP_NAME" == "official-prod-client-server" ]; then
  # official-prod-client-server 배포 그룹에 대한 스크립트 실행
  echo "Running prod-deploy.sh..."
  /home/ec2-user/official-gsm-client-server/scripts/prod-deploy.sh
else
  echo "Unknown deployment group: $DEPLOYMENT_GROUP_NAME"
  exit 1
fi
