# LogChain
Would it make sense to store logs on a blockchain?

This project is an implementation based on [this article](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa).

## Technical details
This is a Spring Boot 2.1.1 starter project using Spring Web, JPA, REST Repositories and REST Docs as dependencies.

To make it work with JPA an H2 in-memory database is included. Read more about Spring and H2 in [this article](http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database).

### Build from source
Launch a command window (on Windows use `cmd.exe` or Powershell) in the project's root folder and 
type `.\mvnw clean package`. This will create a file `LogChain-<version>.jar` in a `target` folder. 
Navigate to this folder and launch the application by typing `java -jar LogChain-<version>.jar`.

### Launching the LogChain application
Go to the [releases](https://github.com/milbe/logchain/releases) page and download the most recent jar file. You will
need a Java JRE installation on your machine (at least version 1.8).