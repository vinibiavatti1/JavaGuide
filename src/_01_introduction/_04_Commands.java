/*
Commands: java and javac
This document explains the two fundamental Java commands "javac" and "java", and how they are used in development.

Java Compiler (javac)
Compiles Java source code (".java" files) into bytecode (".class" files) that can be executed by the JVM.
Options:
- "-d <directory>": Specifies the output directory for compiled classes.
- "-cp <classpath>": Defines where to find dependent classes or libraries.
- "-source" and "-target": Specify Java language and bytecode versions.
Command Example:
- javac -cp "bin;lib/*" -d "bin" src/com/example/MyProgram.java

Java Runtime Launcher (java)
Launches Java applications by running compiled bytecode on the JVM.
Options:
- "-cp <classpath>": Defines where to find classes and libraries at runtime.
- "-Xmx" and "-Xms": Configure JVM memory settings.
- "-jar <file.jar>": Run an application packaged as a JAR.
Command Example:
- java -cp "bin;lib/*" com.example.MyProgram

Classpath
The Java classpath is a parameter used by the JVM and the Java compiler (javac) to locate classes and libraries that
your program depends on. It tells Java where to look for compiled ".class" files and JAR archives, during compilation
and runtime. It is similar to the "PATH" Windows variable, which tells the system "where to find executable commands".
Without the correct classpath, Java cannot find the classes your program needs, resulting in errors like
"ClassNotFoundException". Important notes:
- The classpath is optional. If all the necessary classes are included inside your application's JAR,
  you do not need to explicitly define a classpath.
- When running a JAR with `java -jar myapp.jar`, all classes inside the JAR are automatically available
  at runtime, and the JVM will load them as needed.
- Classpath becomes important when your application depends on "external libraries" or "additional JARs".
- Classpath extends where the JVM searches for classes beyond what is already included in your application.
- For classes inside a single JAR, no classpath setting is required.
- For external dependencies, classpath must be set explicitly, either via environment variables, command-line options,
  or build tool configuration.
*/
void main() {}