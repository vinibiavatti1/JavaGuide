/*
JavaBeans
- This document explains what JavaBeans are, their purpose, conventions, typical usage, and benefits in Java 
  applications.

Overview
- JavaBeans are reusable Java components that follow a standardized set of conventions.
- They provide a consistent way to encapsulate data (properties) and behavior (methods) in Java objects.
- Many frameworks, tools, and IDEs rely on these conventions for introspection, property binding, and event handling.

Key Conventions
1. Properties
- Private fields accessed through public getter and setter methods.
  - Getter: getPropertyName() or isPropertyName() for boolean properties.
  - Setter: setPropertyName().
- Example: private String name; -> getName() / setName(String name)

2. Constructor
- Must provide a public no-argument constructor to allow instantiation by frameworks and tools.

3. Serializable
- Often implements java.io.Serializable to allow object persistence or transfer.

4. Naming Conventions
- Class names: CamelCase (e.g., UserAccount)
- Property names: camelCase (e.g., emailAddress)

Typical Usage
- Data Transfer Objects (DTOs)
- Form backing objects in web frameworks
- Configuration components
- GUI components with event listeners

Benefits
- Reusability and consistency
- Framework/tool interoperability
- Simplified maintenance due to predictable structure
- Supports introspection and automated property management

Modern Context
- JavaBeans conventions are still relevant in enterprise applications.
- Frameworks like Spring, JSF, and JSP leverage these conventions for dependency injection, property binding, and
  component wiring.
- Even if not explicitly required, following JavaBean standards improves compatibility and maintainability.

Summary
- JavaBeans are standardized Java classes for encapsulating data and behavior.
- They promote reusability, consistency, and framework interoperability.
- Key conventions: private properties, public getters/setters, no-arg constructor, optional Serializable.

Example JavaBean
- Follows all standard conventions: private properties, public getters/setters, no-arg constructor, Serializable.
*/
class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    // Properties
    private String userName;
    private String emailAddress;
    private boolean active;

    // No-argument constructor
    public UserAccount() {}

    // Optional parameterized constructor
    public UserAccount(String userName, String emailAddress, boolean active) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.active = active;
    }

    // Getters and setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return String.format("UserAccount{userName='%s', emailAddress='%s', active='%b'}",
                userName, emailAddress, active
        );
    }
}

void main() {}