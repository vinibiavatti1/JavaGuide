/*
 * Observer Design Pattern
 * - This section explains the "Observer" design pattern, which defines a one-to-many dependency between objects so that
 *   when one object changes state, all its dependents are notified and updated automatically.
 *
 * Overview
 * - The Observer pattern is a behavioral design pattern.
 * - It promotes loose coupling between a subject and its observers.
 * - Observers can be added or removed at runtime.
 * - Notifications are typically triggered by state changes in the subject.
 *
 * Key Elements
 * - Subject: maintains a list of observers and provides methods to attach, detach, and notify them.
 * - ConcreteSubject: implements the Subject and stores the state of interest.
 * - Observer: defines an interface for receiving update notifications.
 * - ConcreteObserver: implements the Observer interface and reacts to updates from the subject.
 *
 * Key Characteristics
 * - Establishes a dynamic one-to-many relationship.
 * - Decouples state management from reaction logic.
 * - Supports event-driven architectures.
 * - Notification order may be undefined unless explicitly controlled.
 *
 * Usage
 * - Use Observer when changes in one object require updates to many others.
 * - Commonly used in event systems, UI listeners, and reactive programming.
 * - Ideal when observers need to stay synchronized with a subject’s state.
 * - Useful for implementing publish–subscribe mechanisms.
 */

/*
 * Subject
 * - Maintains a list of observers and provides methods to attach, detach, and notify them.
 */
public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}

/*
 * ConcreteSubject
 * - Implements the Subject and stores the state of interest.
 */
public class ErrorHandler implements Subject {
    private Set<Observer> observers = new HashSet<>();

    public void handle(Exception e) {
        IO.println(e);
        this.notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}

/*
 * Observer
 * - Defines an interface for receiving update notifications.
 */
public interface Observer {
    void update();
}

/*
 * ConcreteObserver
 * - Implements the Observer interface and reacts to updates from the subject.
 */
public class LoggerService implements Observer {
    @Override
    public void update() {
        IO.println(this.getClass().getSimpleName() + " notified!");
    }
}
public class SupportService implements Observer {
    @Override
    public void update() {
        IO.println(this.getClass().getSimpleName() + " notified!");
    }
}
public class AlertService implements Observer {
    @Override
    public void update() {
        IO.println(this.getClass().getSimpleName() + " notified!");
    }
}

/*
 * Example
 * - The example below shows the usage of the Observer design pattern.
 */
void main() {
    ErrorHandler errorHandler = new ErrorHandler();
    errorHandler.subscribe(new LoggerService());
    errorHandler.subscribe(new SupportService());
    errorHandler.subscribe(new AlertService());

    Exception exception = new RuntimeException("An error occurred!");
    errorHandler.handle(exception);
    /*
     * Output:
     * java.lang.RuntimeException: An error occurred!
     * LoggerService notified!
     * SupportService notified!
     * AlertService notified!
     */
}