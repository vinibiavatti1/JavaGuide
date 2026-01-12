/*
Annotation Compile Processing
- This section explains compile-time annotation processing in Java, which allows programs to process annotations during
  compilation rather than at runtime.

Overview
- Compile-time processing is executed by the compiler using Annotation Processors.
- Processors can read annotations on classes, methods, fields, or other elements and generate code, perform validation,
  or create additional resources before the program runs.
- This mechanism does not use reflection; all logic is executed by the compiler during the build process.

Key Characteristics
- Implemented by creating a class that extends AbstractProcessor and overrides the "process()" method.
- The "process()" method receives the set of annotations to process and the elements annotated with them.
- The processor can:
  - Validate annotation usage (e.g., enforce rules, required fields)
  - Generate additional source code or resource files
  - Produce compiler messages and warnings
- Only annotations declared with proper targets and retention policies can be processed by a processor.
- Note: Annotation processing is used to generate new code or resources during compilation, but it cannot modify
  existing classes directly. Tools like Lombok modify the existing class’s AST or bytecode at compile-time, allowing
  fields or methods to be injected directly into the original class.

Supported Annotations for Processor Configuration
- @SupportedAnnotationTypes
  - Specifies which annotations the processor is designed to handle.
  - Optional if "getSupportedAnnotationTypes()" is overridden manually.
- @SupportedSourceVersion
  - Specifies the Java source version the processor supports.
  - Optional if "getSupportedSourceVersion()" is overridden manually.
- Both annotations simplify processor configuration and are widely used in practice.

Registration
- To enable the compiler to recognize and execute an annotation processor, the processor must be registered.
- Registration is done by creating a file at the path: META-INF/services/javax.annotation.processing.Processor
- This file should contain the fully qualified class name of your processor, for example:
  com.example.processor.MyAnnotationProcessor
- During compilation, the Java compiler reads this file and automatically loads the listed processor(s).
- This mechanism allows multiple processors to coexist and ensures that processors are discovered without manual
  configuration.

Usage
- Compile-time annotation processing is ideal for:
  - Code generation (e.g., generating boilerplate classes, builders, or DTOs)
  - Validation of annotation rules (e.g., enforcing correct usage)
  - Generating configuration files or other auxiliary resources
- Processors must be registered using the file: "META-INF/services/javax.annotation.processing.Processor" containing the
  fully qualified processor class name.

Example
- The example below only illustrates the implementation of an Annotation Processor. Execution details and advanced setup
  are omitted, as the guide aims to provide a simple demonstration rather than an in-depth exploration.
*/
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("com.example.MyAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_25)
public static class MyProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Code Generation here.
        return true;
    }
}

void main() {}