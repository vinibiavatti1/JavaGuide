/*
Packages
Packages are used to "organize Java classes and interfaces" into namespaces. They help prevent "name conflicts" and make
large projects easier to maintain. Packages also define the "directory structure" for source and compiled code.

Standard Naming Convention
The recommended convention is "reverse domain names", followed by project or module names. Reverse domain ensures
"uniqueness". if your company owns "example.com", starting your packages with "com.example" avoids conflicts with other
organizations. Examples:
- com.example.utils
- org.apache.commons.lang
- net.mycompany.app

Sub-Packages
After the domain, we can add "sub-packages" for modules, features, or logical grouping. Examples:
- com.example.myproject.model
- com.example.myproject.service
- com.example.myproject.controller

Directory Structure Mapping
Each package corresponds to a directory in the filesystem or inside a JAR. The compiler expects the directory structure
to match the package name exactly.
- Package: com.example.myproject.model
- Directory: src/main/java/com/example/myproject/model/

Rules and Best Practices
- Package names should be "all lowercase" to avoid conflicts between OS filesystems.
- Avoid using Java reserved keywords in package names.
- Use meaningful names to reflect module, layer, or functionality.
- Keep the hierarchy as "shallow as reasonable", too many nested packages can be hard to navigate.

Example Project Structure
MyProject                                    | Project
|- src                                       |
   |- main                                   |
      |- java                                | (Source Root)
         |- com.example.myproject            | Package
         |- com.example.myproject.model      | Package
         |- com.example.myproject.controller | Package
   |- test                                   |
      |- java                                | (Test Source Root)
         |- com.example.myproject            | Package
         |- com.example.myproject.model      | Package
         |- com.example.myproject.controller | Package
*/
@SuppressWarnings("all")
void main() {}