#!/bin/bash

# Stop running docker containers
docker stop $(docker ps -a -q)

# Start docker
docker compose up