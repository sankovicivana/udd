#!/bin/bash

if ! command -v inotifywait &> /dev/null
then
    sudo apt-get update
    sudo apt-get -y install inotify-tools
fi

echo "Already running process: $(ps -ef | awk '/inotifywait/{print $3}')"
kill $(ps -ef | awk '/inotifywait/{print $3}')

echo "Listening to file changes..."
inotifywait -q -m -r -e create,delete,close_write src |
while read -r filename event; do
    echo "Compiling..."
    mvn package -DskipTests
done