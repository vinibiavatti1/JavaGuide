/*
Ecosystem
This document explains the core concepts of the Java ecosystem (JVM, JDK and JRE).

JVM (Java Virtual Machine)
The JVM is the runtime engine that executes Java applications. Java source code is first compiled into bytecode
(`.class` files). The JVM then interprets or compiles this bytecode into native machine code for the operating system.
It only understands bytecode, not Java syntax. Key responsibilities:
- Bytecode execution
- Memory management (heap, stack, garbage collection)
- Thread management
- Security and sandboxing
- Just-In-Time (JIT) compilation for performance

JRE (Java Runtime Environment)
The JRE is a software package that provides all the necessary components to run Java applications on a computer. It does
not include tools for developing Java programs, such as compilers or debuggers. Its primary purpose is to execute Java
bytecode produced by the compiler. It provides:
- JVM (Java Virtual Machine): executes Java bytecode and manages memory, threads, and runtime optimizations.
- Core Java libraries: essential classes and APIs for collections, I/O, networking, utilities, and more.
- Runtime support files: configuration and resource files required for the JVM and libraries to run applications.

JDK (Java Development Kit)
The Java Development Kit (JDK) is a software package that provides everything needed to develop, compile, and build Java
applications. It includes all the components of the Java Runtime Environment (JRE), plus additional tools specifically
for development. It provides:
- JRE (Java Runtime Environment, including the JVM).
- Java compiler (javac): to compile source code into bytecode.
- Debugger (jdb): to debug Java applications.
- Documentation generator (javadoc): to create API documentation.
- Archive tool (jar): to package classes and resources.
- Additional development tools: for tasks like disassembly (javap), runtime image creation (`jlink`), etc.

Comparison Summary:
- JVM = The engine that executes Java bytecode; handles memory, threads, and runtime optimizations; does not include
        libraries or development tools.
- JRE = JVM + core Java libraries + runtime support files; used to run Java applications without development tools.
- JDK = JRE + development tools (javac, jdb, javadoc, jar, etc.); used to develop, compile, and build Java applications.
*/
void main() {}