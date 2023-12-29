#!/bin/bash

(trap 'kill 0' SIGINT; ./scripts/listen.sh & ./mvnw spring-boot:run)