/*
 * Meta Information
 * - This document explains the meta-information directories used in Java archives, such as META-INF and WEB-INF, their
 *   purpose, typical contents, and conventions.
 *
 * Overview
 * - Meta information in Java archives provides metadata, configuration, and internal resources that are not part of the
 *   main application logic but are essential for correct execution.
 * - It allows tools, frameworks, and the JVM or application server to know how to run, configure, or integrate the
 *   application.
 * - The two primary meta-information directories are:
 *   - META-INF: used in JAR, EAR, and WAR files.
 *   - WEB-INF: used in WAR files (web applications).
 *
 * Meta Information Directories
 * 1. META-INF
 * - Purpose: store metadata for the archive or module, such as manifest files, configuration files, and security
 *   signatures.
 * - Typical use cases:
 *   - Define the main class for executable JARs.
 *   - Configure classpath entries for dependencies.
 *   - Include framework-specific metadata (e.g., persistence.xml for JPA, services for ServiceLoader).
 *   - Store digital signatures for signed JARs.
 * - Common files:
 *   - MANIFEST.MF -> main manifest file containing information like Main-Class, Class-Path, version, etc.
 *   - services/ -> optional folder for ServiceLoader implementations.
 *   - persistence.xml -> used by JPA modules for database configuration.
 *   - *.SF, *.DSA, *.RSA -> digital signature files for signed JARs.
 * - Example structure in a JAR:
 *   - myapp.jar
 *     |- META-INF/
 *     |   |- MANIFEST.MF
 *     |   |- services/
 *     |   │   |- com.example.MyService
 *     |   |- persistence.xml
 *     |- com/example/MyClass.class
 *     |- resources/config.properties
 *
 * 2. WEB-INF
 * - Purpose: store web application-specific meta-information and resources that cannot be accessed directly via HTTP.
 * - Ensures that internal classes, libraries, and configuration files are private to the application.
 * - Typical contents:
 *   - web.xml -> deployment descriptor defining servlets, filters, and listeners.
 *   - classes/ -> compiled Java classes organized by package.
 *   - lib/ -> JAR libraries used by the web application.
 * - Example structure in a WAR:
 *   - myapp.war
 *     |- index.html
 *     |- css/
 *     |- js/
 *     |- WEB-INF/
 *         |- web.xml
 *         |- classes/
 *         │   |- com/example/MyServlet.class
 *         |- lib/
 *             |- gson-2.10.jar
 *
 * Service Providers (META-INF/services)
 * - Purpose: support the ServiceLoader API.
 * - Files are named after the interface they implement and list the fully qualified class names of implementations.
 * - Example:
 *   - META-INF/services/com.example.MyService
 *     | com.example.impl.MyServiceImpl1
 *     | com.example.impl.MyServiceImpl2
 *
 * Best Practices
 * - Always include MANIFEST.MF for executable JARs with "Main-Class".
 * - Keep configuration and internal resources in META-INF or WEB-INF instead of the root folder.
 * - Use standard naming conventions and structure to ensure portability across JVMs and servers.
 * - Avoid placing sensitive files outside WEB-INF in web applications.
 * - For multi-module or enterprise apps, use META-INF consistently for module descriptors (persistence.xml,
 *   service definitions).
 *
 * Summary
 * - Meta information directories organize metadata, configuration, and private resources in Java archives.
 * - META-INF -> general metadata for JARs, EARs, or WARs.
 * - WEB-INF -> private content for web applications in WAR files.
 * - META-INF/services -> defines implementations for the ServiceLoader API.
 * - Proper usage ensures correct execution, framework integration, and security.
 */
void main() {}