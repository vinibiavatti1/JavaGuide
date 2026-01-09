/*
Editions
- This document explains the main Java editions (Java SE e Java EE (Jakarta EE)).

Java SE (Standard Edition)
- Java SE is the core platform of the Java ecosystem. It provides the foundation for writing and running Java
  applications.
- It includes the Java language, the JVM, and the standard APIs that cover collections, I/O, concurrency, networking,
  utilities, and more. Java SE is suitable for:
  - General-purpose applications
  - Desktop applications
  - Core backend logic
  - Library development
- It represents the "base layer of Java", used in almost every Java project.
- Java SE is the standard edition of Java and is always included with the JDK, providing the core platform, libraries,
  and development tools needed to write, compile, and run Java applications.

Java EE / Jakarta EE (Enterprise Edition)
- Java EE, now known as Jakarta EE, is an "extension of Java SE" aimed at enterprise and server-side applications.
- It builds on top of Java SE and provides additional APIs and frameworks for complex, multi-layered systems.
- Jakarta EE includes:
  - Web APIs: Servlets, JSP, JSF
  - REST and SOAP services: JAX-RS, JAX-WS
  - Dependency injection: CDI
  - Persistence: JPA
  - Messaging: JMS
  - Transactions: JTA
- It is typically used in applications that run on application servers such as WildFly, Payara, or GlassFish.
- Jakarta EE "does not replace Java SE", but extends it to meet enterprise requirements.
- Jakarta EE APIs can be used:
  - As standalone libraries for lightweight Java SE applications (Maven/Gradle dependencies).
  - On full application servers (GlassFish, etc.) when container features are needed (application server).

Comparison Summary:
- Java SE = Core Java platform, foundation for all applications.
- Jakarta EE = Enterprise API extensions built on Java SE, for web, services, and enterprise features.
*/
void main() {}