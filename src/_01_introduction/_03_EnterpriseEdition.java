/*
Enterprise Edition (Jakarta EE / Java EE)
This document explains what the Java Enterprise Edition is, its components, typical usage, servers, and modern context.

What is Java Enterprise Edition
- Java Enterprise Edition (Java EE), now called Jakarta EE, is a an entire platform with standardized APIs, runtime
  services, and managed components that handle transactions, security, persistence, messaging, and web applications,
  allowing developers to focus on business logic while the server manages the infrastructure.
- Provides standardized APIs for building enterprise applications, including web applications, REST services, messaging,
  transactions, and persistence.
- Adds features such as Servlets, JSP, JSF, JPA, EJB, JMS, and CDI on top of the core Java platform.

Key Components and Libraries
- Servlets / JSP / JSF: web application frameworks
- JPA (Java Persistence API): object-relational mapping for database access
- EJB (Enterprise Java Beans): business logic components
- JMS (Java Messaging Service): asynchronous messaging
- CDI (Contexts and Dependency Injection): dependency management
- Many other standardized APIs for security, transactions, batch processing, and web services

Application Servers
- Jakarta EE applications require a "Java EE-compliant application server" to run. Most popular servers are:
  - Tomcat (servlets only, lightweight)
  - GlassFish / Payara Server
  - WildFly / JBoss EAP
  - WebSphere, WebLogic (enterprise-grade)
- The server provides runtime support for EE APIs, deployment descriptors, and resource management.

How to Use
- Create a web or enterprise project in an IDE like IntelliJ IDEA or Eclipse.
- Configure an application server for deployment.
- Include Jakarta EE APIs in your project dependencies (some servers provide them automatically).
- Package the application as a WAR or EAR for deployment to the server.

Modern Context
- In modern development, using Jakarta EE directly is "less common" for new web projects.
- Frameworks like "Spring Boot" provide:
  - Embedded servers (Tomcat, Jetty)
  - Simplified configuration
  - Dependency injection and web APIs without deploying to an external server
- Jakarta EE is still relevant for legacy applications and large enterprise systems, but for most new projects,
  frameworks like Spring are preferred.

Summary
- Enterprise Edition adds enterprise APIs on top of Java SE for building web and business applications.
- Requires an application server to provide runtime support.
- Includes libraries for web apps, persistence, messaging, and business logic.
- For new web projects, external app servers are often not necessary due to modern frameworks with embedded servers.
*/
@SuppressWarnings("all")
void main() {}
