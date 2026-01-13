/*
 * Ecosystem
 * - This document describes the fundamental components of the Java ecosystem and how they relate to each other: JVM,
 *   JRE, and JDK.
 *
 * Overview
 * - The Java ecosystem is designed around a clear separation of responsibilities between execution, runtime support,
 *   and development tooling.
 * - Java source code is written once, compiled into platform-independent bytecode, and executed by the JVM on different
 *   operating systems.
 * - JVM, JRE, and JDK build on top of each other in layers: JVM is the execution engine, JRE provides the runtime
 *   environment, and JDK adds development tools.
 *
 * JVM (Java Virtual Machine)
 * - The JVM is the core runtime engine responsible for executing Java bytecode (".class" files).
 * - Java source code is compiled into bytecode, which is then interpreted or JIT-compiled into native machine code at
 *   runtime.
 * - The JVM does not understand Java syntax; it only operates on bytecode.
 * - Its main responsibilities include:
 *   - Bytecode execution
 *   - Memory management (heap, stack, garbage collection)
 *   - Thread scheduling and synchronization
 *   - Security mechanisms and sandboxing
 *   - Just-In-Time (JIT) compilation for performance optimizations
 *
 * JRE (Java Runtime Environment)
 * - The JRE provides everything required to run Java applications, but not to develop them.
 * - It is intended for end users and production environments where applications are executed, not compiled.
 * - The JRE consists of:
 *   - The JVM: responsible for executing bytecode and managing runtime behavior.
 *   - Core Java libraries: standard APIs for collections, I/O, networking, concurrency, utilities, and more.
 *   - Runtime support files: configuration, resources, and metadata required by the JVM and libraries.
 *
 * JDK (Java Development Kit)
 * - The JDK is the complete toolkit for Java development.
 * - It includes the JRE and adds tools required to write, compile, test, debug, and package Java applications.
 * - The JDK provides:
 *   - JRE (including the JVM)
 *   - Java compiler (javac): compiles source code into bytecode
 *   - Debugger (jdb): supports debugging Java applications
 *   - Documentation generator (Javadoc): produces API documentation
 *   - Archive tool (jar): packages classes and resources
 *   - Additional development tools: such as javap (bytecode inspection) and jlink (custom runtime image creation)
 *
 * Comparison Summary
 * - JVM: Executes Java bytecode and manages memory, threads, and runtime optimizations.
 * - JRE: JVM plus core libraries and runtime support; used to run Java applications.
 * - JDK: JRE plus development tools; used to develop, compile, and build Java applications.
 */
void main() {}