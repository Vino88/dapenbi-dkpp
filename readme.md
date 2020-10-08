# Technology Stack
- Language: Java 1.8
- Framework: Spring Boot 2.0.5
- Dependency Manager: Gradle
- Template Layout: JMustache
- Database: Oracle 12c

#### Misc
Use Mailcatcher (https://mailcatcher.me/) for catching email locally.
It use Ruby so you must install ruby first on your machine. The rest is explained on the website

# Set Environment Variables

Before start, set below information into machine environment variable

### Environment variable value

```
SERVER_PORT=8080
SERVER_ADDRESS=0.0.0.0
DB_HOST=localhost
DB_PORT=1521
DB_USER_NAME=system
DB_PASSWORD=oracle
DB_NAME=xe
MAIL_HOST=localhost
MAIL_PORT=1025
MAIL_USERNAME=username
MAIL_PASSWORD=password
MAIL_AUTH=false
MAIL_SSL=false
HIBERNATE_DIALECT=org.hibernate.dialect.Oracle10gDialect
SERVER_CONTEXT_PATH=
LIVERELOAD_ENABLED=true
UPLOAD_DIR=
```

### Additional Environment Variable for development mode
```
LIVERELOAD_ENABLED=true
DB_GENERATION=update
SHOW_SQL=true
SQL_LOG_LEVEL=DEBUG
SQL_LOG_DESCRIPTOR=TRACE
```

### Unix System
For unix system, on terminal execute this command:
```
export SERVER_PORT=8080
...
```

### Windows System
For windows system, on cmd execute this command
```
set SERVER_PORT=8080
...
```

### IDE
Or if you use IDE, you can set the environment variable using IDE on run configuration

### System
But if you prefer to keep the value persistent on your machine set tho information on your machine environement variable.

# First Start

1. Add Oracle lib to mvn local repository

    Install maven first then run this command:
    ```
    mvn install:install-file -Dfile=lib/ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1 -Dpackaging=jar
    ```
    
2. You can install oracle directly on your system or you can use docker to prepare the database for you
    To start the docker run this command on application root directory
    ```
    docker-compose up -d
    ```
    
    After the setup is completed, you can access the database with
    ```
    hostname: localhost
    port: 1521
    sid: xe
    service name: xe
    username: system
    password: oracle
    ```
    
    and access the database ui on http://localhost:8081/apex
    ```
    workspace: INTERNAL
    user: ADMIN
    password: 0Racle$
    ```
    
    for more detail about this docker oracle image visit: https://hub.docker.com/r/sath89/oracle-12c/

# How To Run
1. After you set all the environment run `gradle bootRun`
    ```
    If you run the application within a terminal/cmd, every time you want to run on a new terminal/cmd you must set the environment variable again, and the run script must be run on the same tab/windows the environment variable is set.
    But if you set on the system environment varibale or using IDE you just need to set the information once. 
    ```
2. If it hang up on something like:
    ```
    2018-09-22 12:44:01.405  INFO 35738 --- [  restartedMain] com.dapenbi.dkpp.DkppApplication         : Started DkppApplication in 9.22 seconds (JVM running for 9.955)
    <=========----> 75% EXECUTING [24s]
    > :bootRun
    ```
    It means the application is already running 
3. Open http://localhost:8080 on your web browser 
    (it's depending on SERVER_HOST and SERVER_DB you set on the environment variable)
4. Default user for login:
    ```
    email: admin@dkpp.com
    password: Admin231!!
    ```
4. To stop just type ctrl+C

Or use your favourite IDE (Eclipse, NetBean, Intellij, etc) to run the application so you can Debug the application easily