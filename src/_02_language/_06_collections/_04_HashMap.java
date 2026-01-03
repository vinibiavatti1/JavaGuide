/*
HashMap
- This section explains the HashMap class, a hash table–backed implementation of the Map interface in Java.

Overview
- HashMap stores key-value pairs with unique keys, allowing fast retrieval, insertion, and deletion.
- Keys are unordered, and one null key and multiple null values are allowed.
- Provides average O(1) performance for basic operations using a hash table.

Key Characteristics
- Implements the Map interface, sharing methods like put(), get(), remove(), containsKey(), containsValue(),
  size(), keySet(), values(), and entrySet().
- Other Map implementations:
  - LinkedHashMap: preserves insertion or access order, slightly slower due to linked list overhead.
  - TreeMap: keeps keys sorted in natural order or by a comparator, with O(log n) operations.
- Not synchronized; use ConcurrentHashMap for thread-safe access.

Usage
- Preferred when fast key-based access is required and ordering is not important.
- Use LinkedHashMap when iteration order matters (insertion or access).
- Use TreeMap when sorted keys are required.
- Iterate over keys, values, entries, or use Map.forEach() for convenience.
- This documentation focuses on HashMap examples.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration
    - Declares a Map variable and initializes it with a concrete implementation (HashMap).
    - Maps store key-value pairs instead of positional elements.
    - Unlike arrays, maps do not have a fixed size and can dynamically grow as entries are added.
    - Keys must be unique, while values may be duplicated.
    Output: {}
    */
    Map<String, Integer> map = new HashMap<>();
    IO.println(map);

    /*
    Initialization (Immutable)
    - This declares and initializes a Map with specific key-value pairs in a single step.
    - The resulting map is immutable, meaning that entries cannot be added, removed, or modified after creation.
    - Use this approach when you need a fixed set of mappings that should not change during the program execution.
    - Output: {A=1, B=2, C=3} (order not guaranteed)
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map);

    /*
    Initialization (Mutable)
    - This declares and initializes a Map with specific key-value pairs while allowing modifications afterward.
    - By creating a HashMap from another map (such as Map.of), you obtain a mutable map that supports adding,
      removing, or updating entries.
    - Use this approach when you need an initial set of mappings but want to modify the map dynamically during
      program execution.
    - Output: {A=1, B=2, C=3} (order not guaranteed)
    */
    map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    IO.println(map);

    /*
    Nullable
    - Since the Map data type is a reference type, it can represent the absence of a value.
    - Assigning null indicates that the map reference does not point to any instance.
    - Output: null
    */
    Map<String, Integer> otherMap = null;
    IO.println(map);

    //==================================================================================================================
    // Size
    //==================================================================================================================

    /*
    Size (number of entries)
    - The "size()" method returns the number of key-value pairs currently stored in the Map.
    - Unlike arrays, maps do not have a fixed size, and the size can change as entries are added or removed.
    - Output: 3
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.size());

    /*
    Empty
    - The isEmpty() method returns true if the Map contains no key-value pairs, and false otherwise.
    - It is a convenient way to check whether the map has any content before performing operations.
    - Output: true
    */
    map = Map.of();
    IO.println(map.isEmpty());

    //==================================================================================================================
    // Accessing Elements
    //==================================================================================================================

    /*
    Getting Elements
    - Elements in a Map are accessed by their keys using the "get(key)" method.
    - Unlike lists, maps do not use positional indexes; each value is associated with a unique key.
    - If the specified key does not exist in the map, the method returns null.
    */
    map = Map.of("A", 1, "B", 2);
    IO.println(map.get("A")); // 1
    IO.println(map.get("B")); // 2

    /*
    Get or Default
    - The "getOrDefault(key, defaultValue)" method returns the value associated with the given key.
    - If the key does not exist in the map, the provided default value is returned instead of null.
    - This is useful to avoid null checks and simplify fallback logic.
    - Output: 2
    */
    map = Map.of("A", 1);
    IO.println(map.getOrDefault("B", 2));

    /*
    Get All Keys
    - The "keySet()" method returns a Set view of all keys contained in the map.
    - This allows iteration over keys or performing operations on the key set.
    - Output: [A, B, C]
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.keySet());

    /*
    Get All Values
    - The "values()" method returns a Collection view of all values contained in the map.
    - This allows iteration over values or performing operations on the collection of values.
    - Output: [1, 2, 3]
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.values());

    /*
    Get All Entries (Keys and Values)
    - The "entrySet()" method returns a Set view of all key-value pairs contained in the map.
    - Each element in the set is a Map.Entry, allowing access to both key and value.
    - This is useful for iterating over entries or performing operations on both keys and values.
    - Output: [A=1, B=2, C=3]
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.entrySet());

    //==================================================================================================================
    // Setting Elements
    //==================================================================================================================

    /*
    Putting Entries
    - Entries can be added to a Map dynamically using the "put(key, value)" method.
    - If the key does not exist, a new entry is added.
    - If the key already exists, the old value is replaced with the new value.
    - This approach is suitable for mutable maps where entries are not known in advance or may change during program
      execution.
    - Output: {A=1}
    */
    map = new HashMap<>();
    map.put("A", 0);
    map.put("A", 1); // Old value updated (0 to 1)
    IO.println(map);

    /*
    Put If Absent
    - The "putIfAbsent(key, value)" method adds the key-value pair to the map only if the key is not already present.
    - If the key exists, the map remains unchanged for that key.
    - This is useful to ensure that existing entries are not overwritten unintentionally.
    - Output: {A=1, B=2} (order not guaranteed)
    */
    map = new HashMap<>(Map.of("B", 2));
    map.putIfAbsent("A", 1);
    map.putIfAbsent("B", 0); // Value already present (no effect)
    IO.println(map);

    /*
    Adding Entries (from another map)
    - The "putAll(Map<? extends K, ? extends V> m)" method adds all key-value pairs from another map.
    - If a key already exists, its value is replaced with the value from the provided map.
    - This allows combining maps or adding multiple entries at once.
    - Output: {A=1, B=2} (order not guaranteed)
    */
    map = new HashMap<>();
    map.putAll(Map.of("A", 1, "B", 2));
    IO.println(map);

    /*
    Replace Value
    - The "replace(key, value)" method updates the value associated with the given key.
    - If the key exists, its value is replaced with the new value.
    - Output: {A=1}
    */
    map = new HashMap<>(Map.of("A", 0));
    map.replace("A", 1);
    map.replace("B", 2); // Key not present (no effect)
    IO.println(map);

    /*
    Replace If Value
    - The "replace(key, oldValue, newValue)" method updates the value for the given key only if the current value
      matches the specified oldValue.
    - If the value does not match, the map remains unchanged.
    - Output: {A=1, B=2} (order not guaranteed)
    */
    map = new HashMap<>(Map.of("A", 0, "B", 2));
    map.replace("A", 0, 1);
    map.replace("B", 1, 9); // Will not replace because current value is not 1
    IO.println(map);

    //==================================================================================================================
    // Removing Elements
    //==================================================================================================================

    /*
    Removing Entries (by key)
    - Entries in a Map can be removed using the "remove(key)" method, which deletes the entry with the specified key.
    - If the key does not exist, the map remains unchanged.
    - Output: {}
    */
    map = new HashMap<>(Map.of("A", 1));
    map.remove("A");
    IO.println(map);

    /*
    Clear
    - The "clear()" method removes all entries from the map, leaving it empty.
    - After calling "clear()", the map size becomes 0.
    - Output: {}
    */
    map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    map.clear();
    IO.println(map);

    //==================================================================================================================
    // Checking Elements
    //==================================================================================================================

    /*
    Contains Key
    - The "containsKey(key)" method checks whether a specific key exists in the map.
    - It returns true if the key is present, and false otherwise.
    - Output: true
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.containsKey("A"));

    /*
    Contains Value
    - The "containsValue(value)" method checks whether a specific value exists in the map.
    - It returns true if the value is present, and false otherwise.
    - Output: true
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(map.containsValue(2));

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
    Equality
    - Two maps are considered equal if they contain the same key-value pairs.
    - The "equals()" method compares the contents of the maps, not their references.
    - Order of entries does not matter for equality.
    - Output: true
    */
    Map<String, Integer> a = Map.of("A", 1, "B", 2, "C", 3);
    Map<String, Integer> b = Map.of("A", 1, "B", 2, "C", 3);
    IO.println(a.equals(b));

    //==================================================================================================================
    // Iteration
    //==================================================================================================================

    /*
    Iterating Keys (for each)
    - You can iterate over all keys in a map using a for-each loop on the key set.
    - This allows you to access each key individually.
    - Output: A | B | C
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    for (String key : map.keySet()) {
        IO.println(key);
    }

    /*
    Iterating Values (for each)
    - You can iterate over all values in a map using a for-each loop on the collection returned by "values()".
    - This allows you to process each value individually.
    - Output: 1 | 2 | 3
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    for (Integer value : map.values()) {
        IO.println(value);
    }

    /*
    Iterating Entries (Key + Value) (for each)
    - You can iterate over all key-value pairs in a map using a for-each loop on the entry set.
    - Each entry provides access to both the key and the associated value.
    - Output: A:1 | B:2 | C:3
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        IO.println(entry.getKey() + ":" + entry.getValue());
    }

    /*
    Iterator (unidirectional)
    - A standard Iterator can be obtained from the map's entry set to traverse all key-value pairs sequentially.
    - This allows safe removal of entries during iteration if using a mutable map.
    - Output: A:1 | B:2 | C:3
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, Integer> entry = iterator.next();
        IO.println(entry.getKey() + ":" + entry.getValue());;
    }

    //==================================================================================================================
    // Functional Methods
    //==================================================================================================================

    /*
    Functional Iteration
    - The Map interface provides a built-in "forEach()" method.
    - It allows iterating over all key-value pairs using a lambda or method reference.
    - This method is concise, expressive, and recommended for functional-style processing of maps.
    - Output: A:1 | B:2 | C:3
    */
    map = Map.of("A", 1, "B", 2, "C", 3);
    map.forEach((k, v) -> IO.println(k + ":" + v));

    /*
    Functional Replace
    - The "replaceAll()" method applies a transformation function to each entry in the map, replacing the original
      values with the results returned by the function.
    - This is useful for bulk updates using a functional approach.
    - Output: {A=2, B=4, C=6}
    */
    map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
    map.replaceAll((k, v) -> v * 2);
    IO.println(map);

    //==================================================================================================================
    // Merge
    //==================================================================================================================

    /*
    Merge
    - The "merge()" method combines a new value with an existing value for the specified key.
    - If the key is absent, the new value is inserted.
    - If the key is present, the remapping function is applied to the existing and new values, and the result replaces
      the old value.
    - Output: {A=2, B=0}
    */
    map = new HashMap<>(Map.of("A", 1));
    map.merge("A", 1, (k, v) -> v * 2); // Key exist (function performed)
    map.merge("B", 0, (k, v) -> v * 2); // Key doesn't exist (0 value added)
    IO.println(map);

    //==================================================================================================================
    // Compute Methods
    //==================================================================================================================

    /*
    Compute
    - The "compute()" method updates the value for a given key using a remapping function.
    - If the key is absent (value is null), the function can define a new value.
    - If the key is present, the function receives the current value and can update it.
    - This allows conditional or dynamic value computation in a functional style.
    - Output: {A=1, B=2}
    */
    map = new HashMap<>(Map.of("B", 1));
    map.compute("A", (k, v) -> v == null ? 1 : v * 2); // Key "A" absent = new value 1
    map.compute("B", (k, v) -> v == null ? 1 : v * 2); // Key "B" present = 1 * 2 = 2
    IO.println(map);

    /*
    Compute If Present
    - The "computeIfPresent()" method updates the value for a given key only if the key is already present in the map.
    - If the key is absent, nothing happens.
    - This is useful for conditionally updating existing entries without affecting missing keys.
    - Output: {A=2}
    */
    map = new HashMap<>(Map.of("A", 1));
    map.computeIfPresent("A", (k, v) -> v * 2);
    map.computeIfPresent("B", (k, v) -> v * 2);
    IO.println(map);

    /*
    Compute If Absent
    - The "computeIfAbsent()" method adds a new entry for the key only if it is not already present in the map.
    - If the key exists, its value remains unchanged.
    - This is useful for lazily initializing values for missing keys.
    - Output: {A=1, B=2}
    */
    map = new HashMap<>(Map.of("A", 1));
    map.computeIfAbsent("A", k -> 2);
    map.computeIfAbsent("B", k -> 2);
    IO.println(map);
}