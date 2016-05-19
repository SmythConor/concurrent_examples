if [ -z $1 ]; then
	echo -e "usage ./run.sh fileName"
else
	javac $1.java
	java -Djava.security.policy=java.policy $1
fi
