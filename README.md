-	mvn clean install -Dmaven.test.skip=true
-	cf cs p-redis shared-vm redis-service
-	cf push redis-example -p target/redis-example-0.0.1-SNAPSHOT.jar --no-start
-	cf bs redis-example redis-service
-	cf start redis-example

To Test:

-	Do a POST to the endpoint

http://redis-example.<TLD>/person/

and send the body {"id":"1","firstName":"Test","lastName":"Test"}

-	Then try a GET to http://redis-example.<TLD>/person/1
