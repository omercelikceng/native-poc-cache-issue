# native-poc-cache

If you follow the steps below in order, you will encounter the error.
1. mvn clean install
2. mvn spring-boot:build-image -P native 
3. docker run --name hz1 -p 5701:5701 --network=cache-network hazelcast/hazelcast:5.5.0-jdk17
4. docker run --network=cache-network docker.io/library/native-poc-cache-solution:0.0.1-SNAPSHOT

# And Result : No errors will be seen, and the service will be running correctly. Because the relevant method was added to the hint.







