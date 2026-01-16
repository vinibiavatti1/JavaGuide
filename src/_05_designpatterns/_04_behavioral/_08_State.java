/*
 * State Design Pattern
 * - This section explains the "State" design pattern, which allows an object to alter its behavior when its internal
 *   state changes, making the object appear to change its class.
 *
 * Overview
 * - The State pattern is a behavioral design pattern.
 * - It encapsulates state-specific behavior into separate classes.
 * - The context delegates behavior to the current state object.
 * - It eliminates large conditional statements based on state.
 *
 * Key Elements
 * - Context: maintains a reference to the current State and delegates behavior to it.
 * - State: defines a common interface for all concrete states.
 * - ConcreteState: implements behavior associated with a particular state.
 *
 * Key Characteristics
 * - Replaces conditional logic with polymorphism.
 * - Encapsulates state-specific behavior and transitions.
 * - Makes state transitions explicit and easier to manage.
 * - Increases the number of classes, but improves clarity and maintainability.
 *
 * Usage
 * - Use State when an object’s behavior depends on its state and must change at runtime.
 * - Ideal for workflows, state machines, and lifecycle-driven objects.
 * - Commonly used in parsers, UI components, game entities, and protocol implementations.
 * - Prefer State to conditionals when state logic becomes complex or scattered.
 */

/*
 * Context
 * - Maintains a reference to the current State and delegates behavior to it.
 */
public class Post {
    private PostState state = new DraftState(this);
    private String content = "";

    public void edit(String content) {
        state.edit(content);
    }

    public void publish() {
        state.publish();
    }

    public void unpublish() {
        state.unpublish();
    }

    public PostState getState() {
        return state;
    }

    public void setState(PostState state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

/*
 * State
 * - Defines a common interface for all concrete states.
 */
public interface PostState {
    void edit(String content);
    void publish();
    void unpublish();
}

/*
 * ConcreteState
 * - Implements behavior associated with a particular state.
 */
public class DraftState implements PostState {
    private Post post;

    public DraftState(Post post) {
        this.post = post;
    }

    @Override
    public void edit(String content) {
        post.setContent(content);
        IO.println("Post edited!");
    }

    @Override
    public void publish() {
        post.setState(new PublishedState(post));
        IO.println("Post published!");
    }

    @Override
    public void unpublish() {
        IO.println("Cannot unpublish a draft post!");
    }
}
public class PublishedState implements PostState {
    private Post post;

    public PublishedState(Post post) {
        this.post = post;
    }

    @Override
    public void edit(String content) {
        IO.println("Cannot edit a published post!");
    }

    @Override
    public void publish() {
        IO.println("Post is already published!");
    }

    @Override
    public void unpublish() {
        post.setState(new DraftState(post));
        IO.println("Post unpublished!");
    }
}

/*
 * Example
 * - The example below shows the usage of the State design pattern.
 */
void main() {
    Post post = new Post();       // Output:
    post.edit("Hello World!");    // Post edited!
    post.publish();               // Post published!
    post.edit("Hello Galaxy!");   // Cannot edit a published post!
    post.unpublish();             // Post unpublished!
    post.edit("Hello Universe!"); // Post edited!
    post.publish();               // Post published!
    post.publish();               // Post is already published!
}