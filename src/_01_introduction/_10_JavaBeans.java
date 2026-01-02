/*
JavaBeans
This document explains what JavaBeans are, their purpose, conventions, typical usage, and benefits in Java applications.

What is JavaBeans
- JavaBeans are reusable software components for Java that follow a set of conventions for properties, methods, and
  events.
- They provide a standard way to encapsulate data (properties) and behavior (methods) in Java objects.
- JavaBeans are used to simplify development, enable introspection, and support frameworks and tools that manipulate
  components programmatically.

Key Conventions
- Properties: private fields accessed via public getter and setter methods.
  - Getter methods: getPropertyName() or isPropertyName() for boolean properties.
  - Setter methods: setPropertyName().
- No-argument constructor: JavaBeans must provide a public default constructor.
- Serializable: JavaBeans often implement java.io.Serializable to allow object persistence or transfer.
- Naming conventions: CamelCase for class names, camelCase for property names.

Typical Usage
- Encapsulate data in a standardized way for frameworks (e.g., JSP, JSF, Spring).
- Enable introspection and manipulation by IDEs, visual builders, and frameworks.
- Facilitate event handling and listener registration in GUI applications.
- Often used for DTOs (Data Transfer Objects), form backing objects, or configuration components.

Benefits
- Promotes reusability and consistency in Java code.
- Simplifies interaction with tools, frameworks, and libraries.
- Makes code easier to maintain and extend due to standardized structure.

Modern Context
- JavaBeans remain relevant for enterprise Java applications, especially for form objects and DTOs.
- Many modern frameworks (like Spring) leverage JavaBean conventions for dependency injection, property binding, and
  configuration.
- While not always required explicitly, following JavaBean conventions improves interoperability with libraries and
  frameworks.

Summary
- JavaBeans are Java classes following standard conventions for properties, methods, and constructors.
- They enable reusable, maintainable, and tool-friendly components.
- Widely used for data encapsulation, GUI components, and integration with frameworks that rely on introspection.
*/
void main() {
    /*
    Java Bean Example
    - Follows standard JavaBean conventions
    - Private properties
    - Public getters and setters
    - No-argument constructor
    - Implements Serializable
    */
    class UserAccount implements Serializable {
        private static final long serialVersionUID = 1L;

        // Properties
        private String userName;
        private String emailAddress;
        private boolean active;

        // No-argument constructor
        public UserAccount() {
        }

        // Parameterized constructor (optional)
        public UserAccount(String userName, String emailAddress, boolean active) {
            this.userName = userName;
            this.emailAddress = emailAddress;
            this.active = active;
        }

        // Getters and setters
        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        // Optional: override toString for easier debugging
        @Override
        public String toString() {
            return "UserAccount{" +
                    "userName='" + userName + '\'' +
                    ", emailAddress='" + emailAddress + '\'' +
                    ", active=" + active +
                    '}';
        }
    }
}