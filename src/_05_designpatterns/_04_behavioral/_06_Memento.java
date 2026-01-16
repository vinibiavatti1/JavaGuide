/*
 * Memento Design Pattern
 * - This section explains the "Memento" design pattern, which captures and externalizes an object's internal state so
 *   that the object can be restored to this state later, without violating encapsulation.
 *
 * Overview
 * - The Memento pattern is a behavioral design pattern.
 * - It enables undo and rollback mechanisms.
 * - The internal state of an object is saved without exposing its implementation details.
 * - The saved state can be restored at a later point in time.
 *
 * Key Elements
 * - Originator: the object whose state needs to be saved and restored.
 * - Memento: stores the internal state of the Originator.
 * - Caretaker: manages and stores mementos without inspecting their contents.
 *
 * Key Characteristics
 * - Preserves encapsulation by preventing direct access to internal state.
 * - Supports undo, redo, and state history mechanisms.
 * - Separates state persistence from business logic.
 * - Can consume significant memory if many states are stored.
 *
 * Usage
 * - Use Memento when implementing undo/redo functionality.
 * - Commonly used in text editors, drawing applications, and transactional systems.
 * - Ideal when state restoration is required without exposing internal structure.
 * - Use carefully when object state is large or frequently changing.
 */

/*
 * Originator
 * - The object whose state needs to be saved and restored.
 */
public class TextEditor {
    private String title = "(empty)";
    private String content = "(empty)";

    public void append(String text) {
        this.content += text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void print() {
        IO.println(title);
        IO.println(content);
    }
}

/*
 * Memento
 * - Stores the internal state of the Originator.
 */
public record Snapshot(TextEditor textEditor, String title, String content) {
    public void restore() {
        textEditor.setTitle(title);
        textEditor.setContent(content);
    }
}

/*
 * Caretaker
 * - Manages and stores mementos without inspecting their contents.
 */
public class TextEditorHistory {
    private TextEditor textEditor;
    private Deque<Snapshot> history = new ArrayDeque<>(); // Stack - LIFO (Last-In, First-Out)

    public TextEditorHistory(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.save();
    }

    public void save() {
        Snapshot snapshot = new Snapshot(textEditor, textEditor.getTitle(), textEditor.getContent());
        history.push(snapshot);
    }

    public void undo() {
        if (history.isEmpty()) return;
        Snapshot snapshot = history.pop();
        textEditor.setTitle(snapshot.title());
        textEditor.setContent(snapshot.content());
    }
}

/*
 * Example
 * - The example below shows the usage of the Memento design pattern.
 */
void main() {
    TextEditor textEditor = new TextEditor();
    TextEditorHistory textEditorHistory = new TextEditorHistory(textEditor);

    // Version 1
    textEditor.setTitle("Memento");
    textEditor.setContent("The Memento pattern is a behavioral design pattern");
    textEditorHistory.save();

    // Version 2
    textEditor.setTitle("Memento Design Pattern");
    textEditor.append(" that enables undo and rollback mechanisms!");
    textEditor.print();
    /*
     * Output:
     * Memento Design Pattern
     * The Memento pattern is a behavioral design pattern that enables undo and rollback mechanisms!
     */

    // Rollback Version 2
    textEditorHistory.undo();
    textEditor.print();
    /*
     * Output:
     * Memento
     * The Memento pattern is a behavioral design pattern
     */

    // Rollback Version 1
    textEditorHistory.undo();
    textEditor.print();
    /*
     * Output:
     * (empty)
     * (empty)
     */
}