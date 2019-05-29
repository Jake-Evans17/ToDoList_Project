#!/bin/bash
until nc -z ${mysql_ip} 3306; do
	echo "Waiting on the DB to ready"
	sleep 1
done

/usr/bin/java -jar app.jar
