/*
Control Flow Statements (break and continue)
The break and continue statements are used to alter the normal flow of loops in Java.

- break: Immediately exits the nearest enclosing loop or switch statement. It can also be used with a label to exit an
  outer loop from within nested loops. It is commonly used to stop a loop early when a condition is met.
- continue: Skips the current iteration of the nearest enclosing loop and proceeds to the next iteration. It is commonly
  used to bypass specific cases without exiting the loop entirely.

Key characteristics:
- Both statements affect the flow only within the loop or switch they belong to.
- break can be used in for, while, do-while loops, and switch statements.
- continue can be used in for, while, and do-while loops.
- Proper use improves readability and control in loops, but excessive use can make
  code harder to follow.
*/
void main() {
    /*
    Control Flow Statement (break)
    The break statement immediately exits the nearest enclosing loop or switch statement.
    It is commonly used to stop a loop early when a specific condition is met.
    Output: 0 | 1 | 2
    */
    for (int i = 0; i < 10; i++) {
        if (i == 3) {
            break; // Exits the loop when i == 3
        }
        IO.println(i);
    }

    /*
    Loop Skip (continue)
    The continue statement skips the current iteration of the nearest enclosing loop and proceeds to the next iteration.
    It is commonly used to bypass specific cases without exiting the loop entirely.
    Output: 0 | 2
    */
    for (int i = 0; i < 3; i++) {
        if (i == 1) {
            continue; // Skips this iteration when i == 1
        }
        IO.println(i);
    }

    /*
    Control Flow Statement (break with label)
    The break statement can be used with a label to exit an outer loop from within nested loops. This allows breaking
    out of multiple levels of loops at once instead of just the innermost loop.
    Output: i:0 j:0 | i:0 j:1 | i:0 j:2
    */
    label: for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 3) {
                break label; // Exits the outer loop when j == 3
            }
            IO.println("i:" + i + " j:" + j);
        }
    }

    /*
    Control Flow Statement (label with block)
    A labeled block allows the use of break to exit a specific block of code immediately.
    This can be useful for skipping the remainder of a block based on a condition, even if it is not a loop.
    Note: Using labeled blocks in this way is rare in practice and generally not recommended, as it can reduce code
    readability. Methods or early returns are usually preferred.
    Output: Before
    */
    block: {
        IO.println("Before");
        if (true) break block;
        IO.println("After"); // skipped
    }
}