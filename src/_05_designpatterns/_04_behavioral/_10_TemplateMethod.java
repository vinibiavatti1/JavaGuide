/*
 * Template Method Design Pattern
 * - This section explains the "Template Method" design pattern, which defines the skeleton of an algorithm in a base
 *   class, allowing subclasses to override specific steps without changing the overall structure.
 *
 * Overview
 * - The Template Method pattern is a behavioral design pattern.
 * - It promotes code reuse by factoring common algorithm structure into a superclass.
 * - Variable steps are deferred to subclasses.
 * - The overall algorithm flow is fixed and controlled by the base class.
 *
 * Key Elements
 * - AbstractClass: defines the template method and declares abstract or hook methods.
 * - Template Method: a concrete method that defines the algorithm’s structure.
 * - Primitive Operations: abstract methods implemented by subclasses.
 * - Hook Methods: optional methods with default behavior that subclasses may override.
 * - ConcreteClass: implements the variable parts of the algorithm.
 *
 * Key Characteristics
 * - Enforces a consistent algorithm structure.
 * - Allows customization of specific steps.
 * - Avoids code duplication.
 * - Uses inheritance rather than composition.
 *
 * Usage
 * - Use Template Method when multiple classes share the same algorithm structure.
 * - Ideal for frameworks where base classes control execution flow.
 * - Commonly used in data processing pipelines, lifecycle management, and algorithms with fixed steps.
 * - Prefer hooks to provide optional extension points.
 */

/*
 * AbstractClass
 * - Defines the template method and declares abstract or hook methods.
 */
public abstract class EnemyAI {
    /*
     * Template Method
     * - A concrete method that defines the algorithm’s structure.
     */
    public void turn() {
        this.createUnits();
        this.buildStructures();
        this.collectResources();
    }

    /*
     * Primitive Operations
     * - Abstract methods implemented by subclasses.
     */
    public abstract void createUnits();

    /*
     * Hook Methods
     * - Optional methods with default behavior that subclasses may override.
     */
    public void buildStructures() {
        IO.println("House Built!");
    }
    public void collectResources() {
        IO.println("Gold Collected!");
    }
}

/*
 * ConcreteClass
 * - Implements the variable parts of the algorithm.
 */
public class OrcsAI extends EnemyAI {
    @Override
    public void buildStructures() {
        IO.println("Orc Fort Built!");
    }

    @Override
    public void createUnits() {
        IO.println("Orc Warrior Created!");
    }
}
public class HumansAI extends EnemyAI {
    @Override
    public void createUnits() {
        IO.println("Human Warrior Created!");
    }

    @Override
    public void collectResources() {
        IO.println("Food Collected!");
    }
}
public class MonstersAI extends EnemyAI {
    @Override
    public void turn() {
        this.createUnits();
    }

    public void createUnits() {
        IO.println("Natural Monster Spawned!");
    }
}

/*
 * Strategy
 * - The example below shows the usage of the Template Method design pattern.
 */
void main() {
    new OrcsAI().turn();
    /*
     * Output:
     * Orc Warrior Created!
     * Orc Fort Built!
     * Gold Collected!
     */

    new HumansAI().turn();
    /*
     * Output:
     * Human Warrior Created!
     * House Built!
     * Food Collected!
     */

    new MonstersAI().turn();
    /*
     * Output:
     * Natural Monster Spawned!
     */
}