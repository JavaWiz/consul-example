## Consul Service Registration and Discovery Example

We will create Microservices, based on Spring cloud, registering on [HashiCorp Consul](https://www.consul.io/) registry server and how other microservices (discovery clients) use it to register and discover services to call their APIs.

We will be using Spring Boot based Spring Cloud API. We will use Consul registry server for building the service registry server and generic discovery clients which will register themselves and discover other services to call REST APIs.

### Overview

Consul provides multiple features like service discovery, configuration management, health checking and key-value store etc. In this example we will focus on service registry and discovery part. We will develop the below components to build a distributed Eco system where each component is somehow dependent on each other, yet they are very much loosely coupled and of course fault tolerance.

* Consul Agent – running on localhost acting as discovery/registry server functionality.
* book-service microservice – which will give some functionality based on book entity. It will be a rest based service and most importantly it will be a discovery service client, which will talk with Consul Server/Agent to register itself in the service registry.
* book-web-service Microservice – book-web-service will invoke book-service service with service look up mechanism. We will not use absolute URL of book-service to interact with that service. We will use Consul discovery feature and use that to look up student service instance before invoking that.

### Configuring Consul in Local workstation

Before starting our microservices, We need to download, configure and run consul agent in localhost.

Start Consul Agent in local workstation – The Zip file that we have unzipped, has only one exe file called consul.exe. We will start a command prompt here and use below command to start the agent.

```
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.6.1
```

Make sure you enter the correct bind address, it would be different depending on the LAN settings. Do ipconfig in command prompt to know your IpV4 address and use it here.

Test whether Consul Server is running – Consul runs on default port and once agent started successfully, browse http://localhost:8500/ui and you should see a console screen.

So we have configured consul in our local machine and consul agent is running successfully. Now we need to create clients and test the service registry and discovery.


