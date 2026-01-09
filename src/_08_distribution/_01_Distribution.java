/*
Distribution
- This document explains how Java applications are packaged and distributed, including standard archive formats,
  native executables, custom runtime images, and deployment options.

Overview
- Distribution refers to preparing a Java application for delivery so that it can be executed by end users or deployed
  on servers.
- Java applications are usually distributed as:
  - JAR (Java Archive) -> standard for desktop or library applications
  - WAR (Web Application Archive) -> standard for web applications
  - EAR (Enterprise Archive) -> for full enterprise applications with multiple modules
  - EXE (Native executables) -> using tools like GraalVM "native-image" or launchers to simplify execution
  - Custom runtime images -> using "jlink" to create minimized JVM distributions

Archive Formats
1. JAR (Java Archive)
- Purpose: Package compiled ".class" files, resources, and metadata into a single archive.
- File extension: .jar
- Structure:
  - META-INF/
    - MANIFEST.MF -> optional, can define main class and classpath
  - com/example/... -> compiled .class files matching package structure
  - resources/ -> properties, images, configuration files
- Executable JAR: include Main-Class in manifest and run via:
  java -jar myapp.jar
- Creation:
  jar cf myapp.jar -C out/ .
- Advantages:
  - Platform-independent
  - Simplifies library and app distribution
  - Supported by build tools (Maven, Gradle) and IDEs

2. WAR (Web Application Archive)
- Purpose: Package Java web applications for deployment on servers (Servlets, JSP, JSF, Jakarta EE apps)
- File extension: .war
- Structure:
  - WEB-INF/classes -> compiled classes
  - WEB-INF/lib -> dependent JARs
  - WEB-INF/web.xml -> deployment descriptor (optional in modern specs)
  - Static resources (HTML, CSS, JS, images) at root level
- Deployment: copied to application servers like Tomcat, WildFly, GlassFish, or Payara
- Build tools automatically generate WAR from standard Maven/Gradle layout

3. EAR (Enterprise Archive)
- Purpose: Package enterprise applications combining multiple modules
- File extension: .ear
- Structure:
  - META-INF/application.xml -> deployment descriptor
  - EJB modules (.jar)
  - Web modules (.war)
  - lib/ -> shared libraries
- Deployment: installed on full Jakarta EE application servers (WebSphere, WebLogic, WildFly)
- Use case: large, modular enterprise applications

4. EXE (Native Executables)
- Tools like GraalVM native-image or jpackage can produce platform-specific binaries:
  - GraalVM -> compiles Java to native binary (Windows EXE, Linux ELF, macOS app)
  - jpackage -> packages Java apps into native installers (MSI, DMG, DEB, RPM)
- Advantages:
  - No JVM installation required
  - Faster startup
  - Simplifies distribution to end users

5. Custom Runtime Images ("jlink")
- Introduced in Java 9+ with the module system
- Creates a custom Java runtime including only the required modules
- Benefits:
  - Reduced size
  - Bundled with your application, no full JDK/JRE required
- Example:
  jlink --module-path $JAVA_HOME/jmods:mods --add-modules my.module --output my-runtime
- Output: "my-runtime/bin/java" can run your app directly

Distribution Strategies
- Library distribution -> provide JARs for other projects
- Desktop apps -> executable JARs, native binaries, or installer packages
- Web apps -> WAR files deployed to servers
- Enterprise apps -> EAR files with multiple modules
- Self-contained runtime apps -> JAR + custom runtime (jlink) or native executable
- Build tools (Maven, Gradle) automate packaging and distribution

Best Practices
- Include a manifest file with main class for executable JARs
- Manage dependencies inside archive or via build tools
- Use custom runtime images for desktop apps to reduce size and ensure compatibility
- Consider native images or installers for user-friendly delivery
- Version packages and artifacts clearly (semantic versioning recommended)
- Test distribution artifacts on all target platforms

Summary
- Java distribution involves packaging compiled classes, resources, and optionally runtime components
- Standard archive formats: JAR, WAR, EAR
- Modern options: custom runtime images (jlink), native executables (jpackage, GraalVM)
- Proper distribution ensures portability, easy deployment, and smooth user experience
*/
void main() {}