#Camunda 8 Case Managemnet POC: CSAWC 2.0

##Install dependencies
The open source library spring-zeebe provides a Zeebe client.

<dependency>
  <groupId>io.camunda</groupId>
  <artifactId>spring-zeebe-starter</artifactId>
  <version>8.5.6</version>
</dependency>

##Create Client
If we want to connect to a Camunda Platform 8 SaaS cluster we need the clusterId from the Clusters details page, a clientId and clientSecret from a client credentials pair.

The credentails can be added to the application.properties.

zeebe.client.cloud.clusterId=365eed98-16c1-4096-bb57-eb8828ed131e
zeebe.client.cloud.clientId=GZVO3ALYy~qCcD3MYq~sf0GIszNzLE_z
zeebe.client.cloud.clientSecret=.RPbZc6q0d6uzRbB4LW.B8lCpsxbBEpmBX0AHQGzINf3.KK9RkzZW1aDaZ-7WYNJ


To enable the Zeebe client integration annotate your application class with @EnableZeebeClient, see ProcessApplication.java.

@SpringBootApplication
@EnableZeebeClient
public class ProcessApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProcessApplication.class, args);
  }

}

##Deploy Process and Start Instance
To deploy a process you can use the annotation @Deployment, which allows to specify a list of resources (e.g. from classpath) to be deployed on start up.

@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = "classpath:send-email.bpmn")
public class ProcessApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProcessApplication.class, args);
  }

}

##Deploying BPMN diagrams
In addition to the local environment setup with docker compose, use the Camunda Desktop Modeler to locally model BPMN diagrams for execution and directly 
deploy them to your local environment. As an enterprise customer, you can use Web Modeler.

