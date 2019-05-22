#!/bin/bash
until nc -z db-con 3306; do
	echo "Waiting on the DB to ready"
	sleep 1
done

/usr/bin/java -jar app.jar
