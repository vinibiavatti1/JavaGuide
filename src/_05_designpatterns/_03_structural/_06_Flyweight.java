/*
 * Flyweight Design Pattern
 * - This section explains the "Flyweight" design pattern, which reduces memory usage by sharing as much data as
 *   possible with similar objects.
 *
 * Overview
 * - The Flyweight pattern is a structural design pattern.
 * - It allows a large number of fine-grained objects to be shared efficiently.
 * - Objects are split into intrinsic (shared) and extrinsic (context-specific) state.
 * - Commonly used when many similar objects are needed, such as in graphics, text editors, or game development.
 *
 * Key Elements
 * - Flyweight: defines an interface for objects that can be shared.
 * - ConcreteFlyweight: implements the Flyweight interface and stores intrinsic state.
 * - UnsharedConcreteFlyweight: stores state that cannot be shared.
 * - FlyweightFactory: creates and manages Flyweight objects, ensuring sharing when possible.
 * - Client: maintains extrinsic state and interacts with Flyweight objects.
 *
 * Key Characteristics
 * - Reduces memory usage by sharing objects with identical intrinsic state.
 * - Separates intrinsic state (shared) from extrinsic state (unique per context).
 * - Promotes object reuse and efficient resource management.
 * - Particularly useful in systems with large numbers of similar objects.
 *
 * Usage
 * - Use Flyweight when you need to support a large number of similar objects efficiently.
 * - Apply when many objects share common state that can be centralized.
 * - Ideal for text editors (characters), UI elements, graphical objects, or game entities.
 * - Be careful to manage extrinsic state properly to avoid incorrect behavior.
 */

/*
 * Flyweight
 * - Defines an interface for objects that can be shared.
 */
public abstract class Texture {
    private byte[] data;

    public Texture(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}

/*
 * ConcreteFlyweight
 * - Implements the Flyweight interface and stores intrinsic state.
 */
public class TreeTexture extends Texture {
    public TreeTexture() {
        super(new byte[] {1, 2, 3});
    }
}
public class RockTexture extends Texture {
    public RockTexture() {
        super(new byte[] {4, 5, 6});
    }
}

/*
 * UnsharedConcreteFlyweight
 * - Stores state that cannot be shared.
 */
public class Sprite {
    private int x;
    private int y;
    private Texture texture;

    public Sprite(int x, int y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}

/*
 * FlyweightFactory
 * - Creates and manages Flyweight objects, ensuring sharing when possible.
 */
public class TextureFactory {
    private Map<Class<? extends Texture>, Texture> cache = new HashMap<>();

    {
        cache.put(TreeTexture.class, new TreeTexture());
        cache.put(RockTexture.class, new RockTexture());
    }

    public Texture get(Class<? extends Texture> clazz) {
        return cache.getOrDefault(clazz, null);
    }
}

/*
 * Client
 * - Maintains extrinsic state and interacts with Flyweight objects.
 */
public class Game {
    TextureFactory textureFactory = new TextureFactory();

    public void renderLevel() {
        Sprite tree1 = new Sprite(0, 0, textureFactory.get(TreeTexture.class));
        Sprite tree2 = new Sprite(0, 1, textureFactory.get(TreeTexture.class));

        Sprite rock1 = new Sprite(1, 0, textureFactory.get(RockTexture.class));
        Sprite rock2 = new Sprite(1, 1, textureFactory.get(RockTexture.class));

        IO.println(tree1.getTexture().equals(tree2.getTexture())); // true
        IO.println(rock1.getTexture().equals(rock2.getTexture())); // true
    }
}

/*
 * Example
 * - The example below shows the usage of the Flyweight design pattern.
 */
void main() {
    Game game = new Game();
    game.renderLevel();
}