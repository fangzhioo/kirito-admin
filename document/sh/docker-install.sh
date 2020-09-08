#!/usr/bin/env bash
echo '----docker install start----'
sudo yum update -y
echo '----yum update finish----'
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
echo '----docker 依赖安装完毕----'
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
# sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
echo '----配置docker-ce 仓库地址完毕----'
sudo yum install -y docker-ce
echo '----安装docker-ce完毕, 校验版本----'
sudo docker -v
sudo systemctl enable docker
sudo systemctl start docker

echo '----docker-compose install start----'
curl -L https://get.daocloud.io/docker/compose/releases/download/1.24.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
echo '----docker-compose 修改为可执行----'
chmod +x /usr/local/bin/docker-compose
echo '----docker-compose 校验版本----'
docker-compose --version
