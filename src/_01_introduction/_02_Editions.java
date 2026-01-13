/*
 * Editions
 * - This document explains the main Java platform editions and their roles within the Java ecosystem: Java SE and Java
 *   EE (Jakarta EE).
 *
 * Overview
 * - The Java platform is organized into editions that address different application needs.
 * - Java SE defines the core language, runtime, and standard APIs, forming the foundation of the ecosystem.
 * - Jakarta EE builds on top of Java SE, providing standardized APIs for enterprise, web, and distributed applications.
 * - The editions are complementary, not competing: Jakarta EE extends Java SE rather than replacing it.
 *
 * Java SE (Standard Edition)
 * - Java SE is the core platform of the Java ecosystem and the foundation for writing and running Java applications.
 * - It defines the Java language, the JVM, and the standard APIs used across almost all Java projects.
 * - Java SE includes APIs for:
 *   - Collections and data structures
 *   - I/O and NIO
 *   - Concurrency and multithreading
 *   - Networking
 *   - Utilities, time, and core language features
 * - Java SE is suitable for:
 *   - General-purpose applications
 *   - Desktop applications
 *   - Core backend and business logic
 *   - Library and framework development
 * - It represents the base layer of Java and is required by all other Java editions.
 * - Java SE is always included with the JDK, providing the core platform, libraries, and development tools needed to
 *   write, compile, and run Java applications.
 *
 * Java EE / Jakarta EE (Enterprise Edition)
 * - Java EE, now known as Jakarta EE, is an extension of Java SE focused on enterprise and server-side development.
 * - It provides standardized APIs and specifications for building scalable, secure, and distributed applications.
 * - Jakarta EE builds on top of Java SE and adds higher-level abstractions for common enterprise concerns.
 * - Jakarta EE includes APIs for:
 *   - Web and HTTP: Servlets, JSP, JSF
 *   - REST and SOAP services: JAX-RS, JAX-WS
 *   - Dependency injection and lifecycle management: CDI
 *   - Persistence and ORM: JPA
 *   - Messaging and asynchronous communication: JMS
 *   - Transactions and consistency: JTA
 * - Jakarta EE applications typically run on application servers such as WildFly, Payara, or GlassFish, which provide
 *   container-managed services.
 * - Jakarta EE does not replace Java SE; it extends it to address enterprise requirements.
 * - Jakarta EE APIs can be used in different ways:
 *   - As standalone libraries in Java SE applications via Maven or Gradle, for lightweight use cases
 *   - Within full application servers, when container-managed features and integration are required
 *
 * Comparison Summary
 * - Java SE: Core Java platform and foundation for all Java applications.
 * - Jakarta EE: Enterprise-focused APIs built on Java SE, targeting web, services, and distributed systems.
 */
void main() {}