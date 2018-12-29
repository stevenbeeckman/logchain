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

### Vagrant and Docker
#### Introduction
[Vagrant](https://www.vagrantup.com) is a wrapper around virtual machine providers such as VMWare and VirtualBox. It makes it really easy to make a Linux VM running on Windows. It takes VM specifications (and provisioning) from a `Vagrantfile`. After installing Vagrant it's as easy as typing `vagrant up` on a command line with with as working directory the directory where the `Vagrantfile` is located.

Docker is a popular linux container implementation. It allows to compartementize a host, using less resources than a VM. Docker container images are built from specs defined in a `Dockerfile`. The resulting image can then be shared from a container image repository such as [Docker Hub](https://hub.docker.com).

The below information is enough for demo purposes but not for production usage!

#### Practical
Make you've built the `LogChain-<version>.jar` file and put it in a separate directory together with `Vagrantfile` and `Dockerfile`. Open a command line and type `vagrant up` and wait till the VM is provisioned. Once it's done you can ssh into the VM using `vagrant ssh`. A new shell (`$ vagrant@ubuntu-xenial: `) is opened.

Then enter `sudo docker build -t milbe/logchain:0.0.4 .` to build a container image called milbe/logchain with version 0.0.4. Don't forget the `.` at the end of the command! This will build a minimal image with OpenJDK 8 and install `LogChain-0.0.4.jar`.

Finally, enter `sudo docker run -p 8080:8080 -t milbe/logchain:0.0.4` to run the new container image. The application should be available on [http://localhost:8080](http://localhost:8080).

Have a look at the running containers by issuing `sudo docker ps`. Stop the running container with the command `sudo docker stop <CONTAINER ID>`.