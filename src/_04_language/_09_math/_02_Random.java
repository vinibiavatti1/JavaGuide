/*
 * Random
 * - This section explains the "Random" class in Java, which provides pseudorandom number generation using a seed-based
 *   algorithm.
 *
 * Overview
 * - The "Random" class is part of the java.util package.
 * - It generates sequences of pseudorandom numbers that appear statistically random, but are actually deterministic if
 *   the seed is known.
 * - Introduced in early Java versions to support simulations, games, testing, and any application requiring random-like
 *   behavior.
 * - Widely used for generating integers, doubles, booleans, or for shuffling and sampling data.
 *
 * Key Characteristics
 * - Seed-based: the sequence of numbers is determined by an initial value called a "seed". Using the same seed always
 *   produces the same sequence of numbers, which is useful for reproducible results in testing.
 * - Provides methods to generate different types of random values: nextInt(), nextDouble(), nextFloat(), nextLong(),
 *   nextBoolean(), and nextBytes().
 * - Can be used with Math.random(), which internally uses a Random instance.
 * - All instances of Random are independent unless explicitly seeded with the same value.
 *
 * Usage
 * - Use Random when you need pseudorandom numbers for simulations, testing, or games.
 * - For reproducible sequences, always set a seed using the constructor: new Random(seed).
 * - Example sequences in this documentation use the seed 1L to ensure the output is always the same.
 * - Avoid using Random for cryptographic purposes; use SecureRandom instead for secure random numbers.
 */
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
     * Random Number Generator
     * - Creates a new instance of the Random class, which can generate pseudorandom numbers.
     * - If no seed is provided, the generator uses a default seed based on the current time, producing different
     *   sequences on each run.
     */
    Random random = new Random();

    /*
     * Random Number Generator With Seed
     * - Creates a new instance of the Random class using a specific seed (1L in this case).
     * - Using a seed ensures that the sequence of generated numbers is reproducible and always the same.
     * - The seed can also be reset later using the "setSeed(long seed)" method to restart the sequence.
     */
    random = new Random(1L);

    //==================================================================================================================
    // Operations
    //==================================================================================================================

    /*
     * Next Boolean
     * - Returns the next pseudorandom boolean value from this Random instance.
     * - The value is either true or false, determined by the internal pseudorandom algorithm.
     * - Output: true
     */
    random = new Random(1L);
    IO.println(random.nextBoolean());

    /*
     * Next Int
     * - Returns the next pseudorandom int value from this Random instance.
     * - The value can be any valid int, determined by the internal pseudorandom algorithm.
     * - Output: -1155869325
     */
    random = new Random(1L);
    IO.println(random.nextInt());

    /*
     * Next Double
     * - Returns the next pseudorandom double value from this Random instance.
     * - The value is between 0.0 (inclusive) and 1.0 (exclusive), determined by the internal pseudorandom algorithm.
     * - Output: 0.7308781907032909
     */
    random = new Random(1L);
    IO.println(random.nextDouble());

    /*
     * Next Gaussian
     * - Returns the next pseudorandom double value drawn from a Gaussian (normal) distribution with mean 0.0 and
     *   standard deviation 1.0.
     * - Gaussian distribution is a bell-shaped probability distribution commonly used to model natural phenomena and
     *   statistical data.
     * - Output: 1.561581040188955
     */
    random = new Random(1L);
    IO.println(random.nextGaussian());

    //==================================================================================================================
    // Stream
    //==================================================================================================================

    /*
     * Ints
     * - Returns a stream of pseudorandom int values from this Random instance.
     * - In this example, the stream is limited to 3 values and printed directly.
     * - Overloads: you can specify a stream size and an optional origin and bound to generate values within a specific
     *   range.
     * - Output: -1155869325 | 431529176 | 1761283695
     */
    random = new Random(1L);
    random.ints(3).forEach(IO::println);

    /*
     * Doubles
     * - Returns a stream of pseudorandom double values between 0.0 (inclusive) and 1.0 (exclusive) from this Random
     *   instance.
     * - In this example, the stream is limited to 3 values and printed directly.
     * - Overloads: you can specify a stream size and an optional origin and bound to generate values within a specific
     *   range.
     * - Output: 0.7308781907032909 | 0.41008081149220166 | 0.20771484130971707
     */
    random = new Random(1L);
    random.doubles(3).forEach(IO::println);
}