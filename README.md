# backoffice-api

Repository to Bettha Backoffice API project

### Requirements

* JDK 11 or greater
* Maven 3.6.0 or greater

### Building Project and Running Migrations

It's necessary to run migrations in Maven build manually, because they are disable in application startup to avoid undesirable migrations in local database.
Run below code to build project and run migrations:

    mvn resources:resources liquibase:update -P local clean install -DskipTests
    
### Running Application

We are ready to run application. Run the code below:

    java -jar target/backoffice-api-1.0.0.war
    
### Debugging
    
If you want to debug application in some IDE running application outside IDE, instead run above code, run the following code:

    java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address={SOME_PORT} target/backoffice-api-1.0.0.war
    
Some configuration is required in IDE for this to work. See https://www.jetbrains.com/help/idea/tutorial-remote-debug.html to configure IntelliJ.
