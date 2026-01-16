/*
 * Mediator Design Pattern
 * - This section explains the "Mediator" design pattern, which defines an object that encapsulates how a set of objects
 *   interact, promoting loose coupling by preventing objects from referring to each other explicitly.
 *
 * Overview
 * - The Mediator pattern is a behavioral design pattern.
 * - It centralizes complex communication and control logic between related objects.
 * - Objects communicate indirectly through the mediator instead of directly with each other.
 * - This reduces dependencies and simplifies object interactions.
 *
 * Key Elements
 * - Mediator: defines an interface for communication between colleague objects.
 * - ConcreteMediator: implements the mediator interface and coordinates interactions between colleagues.
 * - Colleague: defines objects that communicate with each other via the mediator.
 * - ConcreteColleague: implements the colleague interface and sends/receives messages through the mediator.
 *
 * Key Characteristics
 * - Promotes loose coupling between interacting objects.
 * - Centralizes control logic, making interactions easier to understand and modify.
 * - Simplifies individual colleague classes by removing communication logic.
 * - Can become complex if the mediator grows too large (risk of a "god object").
 *
 * Usage
 * - Use Mediator when many objects communicate in complex ways.
 * - Useful for UI components (dialogs, forms, widgets) that need coordinated behavior.
 * - Apply when direct object-to-object communication leads to tight coupling.
 * - Ideal when interaction logic changes frequently but object roles remain stable.
 */

/*
 * Mediator
 * - Defines an interface for communication between colleague objects.
 */
public interface Mediator {
    void notify(Component sender, String event);
}

/*
 * ConcreteMediator
 * - Implements the mediator interface and coordinates interactions between colleagues.
 */
public class ToolBar implements Mediator {
    private OpenButton openButton = new OpenButton(this);
    private SaveButton saveButton = new SaveButton(this);
    private CloseButton closeButton = new CloseButton(this);

    @Override
    public void notify(Component sender, String event) {
        String senderName = sender.getClass().getSimpleName();
        switch (event) {
            case "open" -> IO.println(senderName + " requested to open!");
            case "save" -> IO.println(senderName + " requested to save!");
            case "close" -> IO.println(senderName + " requested to close!");
        }
    }

    public OpenButton getOpenButton() {
        return openButton;
    }

    public SaveButton getSaveButton() {
        return saveButton;
    }

    public CloseButton getCloseButton() {
        return closeButton;
    }
}

/*
 * Colleague
 * - Defines objects that communicate with each other via the mediator.
 */
public class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}

/*
 * ConcreteColleague
 * - Implements the colleague interface and sends/receives messages through the mediator.
 */
public class OpenButton extends Component {
    public OpenButton(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        mediator.notify(this, "open");
    }
}
public class SaveButton extends Component {
    public SaveButton(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        mediator.notify(this, "save");
    }
}
public class CloseButton extends Component {
    public CloseButton(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        mediator.notify(this, "close");
    }
}

/*
 * Example
 * - The example below shows the usage of the Mediator design pattern.
 */
void main() {
    ToolBar toolBar = new ToolBar();

    toolBar.getOpenButton().click();  // Output: OpenButton requested to open!
    toolBar.getSaveButton().click();  // Output: SaveButton requested to save!
    toolBar.getCloseButton().click(); // Output: CloseButton requested to close!
}