* mvn clean install -Dmaven.test.skip=true
* cf cs p-redis shared-vm redis-service
* cf push redis-example -p target/redis-example-0.0.1-SNAPSHOT.jar --no-start
* cf bs redis-example redis-service
* cf start redis-example