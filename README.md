# Microservices patterns implented with Spring Cloud
Project implemented the following microservice patters:
* Service discovery (self-registration) with the help of eureka-cloud
* Api gateway (+load balancing)
* Security - for the sake of writing extra code api-gateway service is client regisered in local Keycloak service (Authentication service).   
For securing resource services endpoints TokenRelay configuration is used.
_____
On other branches there are some other features, e.g.:
* Securing configuration with Vault (local password management instance in dev mode) in KV store engine for simplicity.   
More details can be found on [documentation] (https://www.vaultproject.io/docs/secrets/kv) 
* Securing and routing Eureka service
* For dummy data population useful popular libraries were used - javafaker and javamoneta
