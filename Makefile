stop:
	-pkill java

start:
	java -jar target/sylvester-1.0.0-SNAPSHOT.jar &

run: stop start

