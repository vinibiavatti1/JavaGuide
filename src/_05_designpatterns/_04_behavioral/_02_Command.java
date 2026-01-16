/*
 * Command Design Pattern
 * - This section explains the "Command" design pattern, which encapsulates a request as an object, allowing
 *   parameterization of clients with different requests, queuing, logging, and undo operations.
 *
 * Overview
 * - The Command pattern is a behavioral design pattern.
 * - It turns a request into a standalone object that contains all information needed to perform an action.
 * - This decouples the object that invokes an operation from the one that knows how to perform it.
 * - Frequently used to support undo/redo, macro commands, and command queues.
 *
 * Key Elements
 * - Command: defines an interface for executing an operation.
 * - ConcreteCommand: implements the Command interface and binds a receiver to an action.
 * - Receiver: performs the actual work associated with the command.
 * - Invoker: triggers the command execution.
 * - Client: creates and configures Command objects and associates them with receivers.
 *
 * Key Characteristics
 * - Encapsulates requests as objects.
 * - Decouples invokers from receivers.
 * - Supports undo and redo operations.
 * - Allows commands to be queued, logged, or executed at a later time.
 * - Enables macro commands by composing multiple commands.
 *
 * Usage
 * - Use Command when you want to parameterize objects with operations.
 * - Apply when you need undo/redo functionality.
 * - Useful for GUI actions, menu systems, transaction processing, and job queues.
 * - Ideal when you want to decouple UI logic from business logic.
 */

/*
 * Command
 * - Defines an interface for executing an operation.
 */
public interface Command {
    void execute();
}

/*
 * ConcreteCommand
 * - Implements the Command interface and binds a receiver to an action.
 */
public class OpenFileCommand implements Command {
    private TextEditor textEditor;

    public OpenFileCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.openFile();
    }
}
public class SaveFileCommand implements Command {
    private TextEditor textEditor;

    public SaveFileCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.saveFile();
    }
}
public class CloseFileCommand implements Command {
    private TextEditor textEditor;

    public CloseFileCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.closeFile();
    }
}

/*
 * Receiver
 * - Performs the actual work associated with the command.
 */
public class TextEditor {
    public void openFile() {
        IO.println("File opened!");
    }

    public void saveFile() {
        IO.println("File saved!");
    }

    public void closeFile() {
        IO.println("File closed!");
    }
}

/*
 * Invoker
 * - Triggers the command execution.
 */
public class ToolBar {
    private OpenFileCommand openFileCommand;
    private SaveFileCommand saveFileCommand;
    private CloseFileCommand closeFileCommand;

    public ToolBar(TextEditor textEditor) {
        openFileCommand = new OpenFileCommand(textEditor);
        saveFileCommand = new SaveFileCommand(textEditor);
        closeFileCommand = new CloseFileCommand(textEditor);
    }

    public void clickOpenFileButton() {
        openFileCommand.execute();
    }

    public void clickSaveFileButton() {
        saveFileCommand.execute();
    }

    public void clickCloseFileButton() {
        closeFileCommand.execute();
    }
}

/*
 * Client
 * - Creates and configures Command objects and associates them with receivers.
 */
public class Application {
    private TextEditor textEditor;
    private ToolBar toolBar;

    public Application() {
        this.textEditor = new TextEditor();
        this.toolBar = new ToolBar(textEditor);
    }

    public ToolBar getToolBar() {
        return toolBar;
    }
}

/*
 * Example
 * - The example below shows the usage of the Command design pattern.
 */
void main() {
    Application application = new Application();

    application.getToolBar().clickOpenFileButton();  // Output: File opened!
    application.getToolBar().clickSaveFileButton();  // Output: File saved!
    application.getToolBar().clickCloseFileButton(); // Output: File closed!
}
