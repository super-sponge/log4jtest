#!/usr/bin/env bash


for jar in /home/sponge/IdeaProjects/log4jtest/target/lib/*jar
do
    classpath=$classpath:$jar
done

echo $classpath

java -classpath $classpath -jar log4jtest-1.0-SNAPSHOT.jar