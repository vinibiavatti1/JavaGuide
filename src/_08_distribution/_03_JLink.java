/*
JLink
- This document explains the Java tool "jlink", its purpose, usage, requirements, and how it is used to create custom
  Java runtime images for modular applications.

Overview
- jlink is a command-line tool introduced in Java 9 as part of the Java Platform Module System (JPMS).
- Purpose:
  - Create custom runtime images containing only the modules required by your application.
  - Reduce the size of Java distributions by excluding unnecessary modules.
  - Bundle your application with a minimal Java runtime for self-contained deployment.
- Requirements:
  - Your application must be modular, i.e., use the Java module system with "module-info.java".
  - Only modules present in the module path can be included in the custom runtime image.
- Benefits:
  - Smaller package size compared to the full JDK/JRE.
  - Ensures the application runs with a compatible set of modules.
  - Can be combined with tools like "jpackage" to create native executables/installers.

Basic Usage
- Syntax:
  jlink [options]
- Mandatory options:
  - --module-path <path> -> path to modules required by your application (JDK modules + your app modules)
  - --add-modules <module-list> -> list of modules to include in the runtime image
  - --output <folder> -> folder where the custom runtime image will be created

Example: Basic custom runtime image
  jlink --module-path $JAVA_HOME/jmods:mods
        --add-modules com.example.myapp
        --output my-runtime

Options
- --launcher <name>=<module>/<main-class> -> create a launcher script to run your main class
- --strip-debug -> remove debug information to reduce image size
- --compress <level> -> compress resources (0 = none, 1 = moderate, 2 = maximum)
- --no-header-files -> exclude header files
- --no-man-pages -> exclude man pages
- --verbose -> display detailed information during image creation

Example: Custom runtime with launcher, compression, and stripped debug
  jlink --module-path $JAVA_HOME/jmods:mods
        --add-modules com.example.myapp
        --launcher myapp=com.example.myapp/com.example.myapp.Main
        --compress 2
        --strip-debug
        --no-man-pages
        --output my-runtime

Output Structure
- The custom runtime image has a folder structure similar to a JDK/JRE:
  my-runtime/
  |- bin/          -> executable launcher scripts
  |- conf/         -> configuration files
  |- include/      -> header files (optional)
  |- legal/        -> license information
  |- lib/          -> compiled modules included in the image
  |- release       -> release metadata
- You can run your application using the launcher or directly via "bin/java" inside the runtime image.

Integration with jpackage
- The runtime image created by jlink can be used with jpackage to produce self-contained native applications.
- Example:
  jpackage --input out/artifacts/MyApp_jar/
           --name MyApp --main-jar MyApp.jar
           --main-class com.example.myapp.Main
           --runtime-image my-runtime
           --type exe
           --dest dist/

Best Practices
- Only include the modules your application actually requires to reduce image size.
- Use --launcher to simplify running the application.
- Combine jlink with jpackage for professional, self-contained desktop applications.
- Test the custom runtime image on all target platforms.
- Keep a versioned copy of the runtime image to match your application releases.

Summary
- jlink creates custom Java runtime images for modular applications.
- Requires Java modules (module-info.java) to work.
- Reduces image size and ensures a compatible set of modules for the app.
- Can be bundled with jpackage to create native, self-contained applications.
- Ideal for distributing Java desktop applications without requiring a full JDK/JRE installation.
*/
void main() {}
