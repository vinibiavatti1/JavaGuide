/*
JPackage
- This document explains the Java tool "jpackage", its purpose, usage, and how it is used to create native
  executables and installer packages for Java applications.

Overview
- jpackage is a command-line tool introduced in Java 14 (preview) and stabilized in Java 16+.
- Purpose:
  - Create platform-specific native packages for Java applications.
  - Bundle a Java runtime (JRE) with your application, so users do not need a separate JDK/JRE installation.
  - Generate executables and installer packages for Windows, macOS, and Linux.
- Supported output types:
  - Windows: exe, msi
  - macOS: dmg, pkg
  - Linux: deb, rpm
- Benefits:
  - Simplifies desktop Java application distribution
  - Reduces dependency on pre-installed JDK/JRE
  - Produces professional-looking native installers
  - Can include custom runtime images generated via jlink

Basic Usage
- Syntax:
  jpackage [options]
- Mandatory options:
  - --input <folder> -> folder containing your JAR and dependencies
  - --name <AppName> -> application name
  - --main-jar <jar-file> -> main executable JAR
  - --main-class <class-name> -> class with public static void main(String[] args)
  - --type <type> -> package type (exe, msi, dmg, pkg, deb, rpm)
  - --dest <folder> -> output folder for the generated package

Example (Windows EXE):
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp --main-jar MyApp.jar
           --main-class com.example.Main
           --type exe
           --icon src/main/resources/icon.ico
           --dest dist/

Common Options
- --app-version <version> -> specify application version
- --icon <file> -> application icon (ico for Windows, icns for macOS, png for Linux)
- --vendor <vendor-name> -> company or developer name
- --description <text> -> application description
- --license-file <file> -> include a license agreement
- --win-menu -> add application to Windows Start menu
- --win-shortcut -> create a desktop shortcut
- --mac-package-identifier <id> -> macOS bundle identifier
- --mac-sign -> sign the macOS app (requires certificate)
- --linux-package-name <name> -> package name for Linux (deb/rpm)
- --linux-shortcut -> create desktop shortcut for Linux

Examples
1. Windows EXE with icon:
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp
           --main-jar MyApp.jar
           --main-class com.example.Main
           --type exe
           --icon src/main/resources/icon.ico
           --dest dist/
           --win-menu
           --win-shortcut

2. macOS DMG:
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp
           --main-jar MyApp.jar
           --main-class com.example.Main
           --type dmg
           --icon src/main/resources/icon.icns
           --dest dist/
           --mac-package-identifier com.example.myapp

3. Linux DEB:
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp
           --main-jar MyApp.jar
           --main-class com.example.Main
           --type deb
           --icon src/main/resources/icon.png
           --dest dist/
           --linux-shortcut

4. Using a custom runtime image:
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp
           --main-jar MyApp.jar
           --main-class com.example.Main
           --type exe
           --runtime-image my-runtime
           --dest dist/

Best Practices
- Always generate an executable JAR first with a proper Main-Class in MANIFEST.MF.
- Include icons and metadata to make the installer professional.
- Test the generated package on the target OS.
- Version your packages clearly (semantic versioning recommended).
- Bundle dependencies in the input folder or create a fat/uber JAR if needed.

Summary
- jpackage is the modern way to distribute Java desktop applications as native executables or installer packages.
- Supports Windows, macOS, and Linux with platform-specific options.
- Can bundle a custom runtime to remove dependency on pre-installed JDK.
- Produces professional, user-friendly distribution artifacts.
- Ideal for shipping desktop Java applications to end users.
*/
void main() {}