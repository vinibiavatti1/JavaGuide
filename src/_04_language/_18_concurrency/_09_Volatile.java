/*
Volatile Keyword
- This section explains the "volatile" keyword in Java and how it ensures visibility of variables across multiple
  threads.

Overview
- "volatile" is used to mark a variable so that all reads and writes go directly to main memory.
- Ensures that changes made by one thread are immediately visible to other threads.
- Unlike synchronization, "volatile" does not provide atomicity for compound actions (e.g., incrementing a variable).
- Typically used for flags or signals shared between threads.

Key Characteristics
- Applies to instance or static variables (not local variables).
- Guarantees visibility but does not guarantee exclusive access or atomic updates.
- Useful for simple state or control variables in concurrent applications.
- Avoid using "volatile" for complex operations that require atomicity; prefer "synchronized" or atomic classes.

Usage
- Use "volatile" for shared flags, signals, or state indicators that are read and written by multiple threads.
- Ideal for stopping threads or notifying threads of state changes.
- Do not use for compound operations like "count++"—use atomic types or synchronization instead.

Example:
- The example demonstrates a "volatile" boolean "running" used to control a loop across threads.
- One thread executes the loop, and another thread sets the variable to false.
- Using "volatile" ensures that the loop thread sees the updated value immediately and terminates correctly.
*/
void main() {
    
}