# springBoot-demos
Sample spring boot projects. Mainly to do POC projects for evaluation of features.

### List of Sample applications
---
1. **sam-function-demo** - Spring clould function samples
2. **sam-api-gateway** - Spring boot API gateway with redirection, URL rewriting etc. samples. Need to use  **sam-eureka-service** and **sam-app-service** project together
3. **sam-eureka-service** - Companion project for **sam-api-gateway**
4. **sam-app-service** - Companion project for **sam-api-gateway**
5. **rsocket-server** &  **rsocket-client** - Spring boot RSocket samples for all 4 interaction models with custom messages.
6. **sam-admin-server** &  **sam-admin-client** - Spring boot Admin samples. This can be used for managing and monitoring Spring Boot applications. Each application is registered as a  client to the admin server which then monitors the application with the help of exposed actuator endpoints.


