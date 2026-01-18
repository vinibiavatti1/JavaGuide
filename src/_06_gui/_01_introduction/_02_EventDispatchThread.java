/*
 * Event Dispatch Thread (EDT)
 * - This section explains the Event Dispatch Thread (EDT) in Java Swing, which is the dedicated thread responsible for
 *   all user interface operations, including component creation, updates, and event handling.
 *
 * Overview
 * - Swing is single-threaded and not thread-safe; any interaction with Swing components must occur on the EDT.
 * - The EDT processes user input events (mouse, keyboard), repaints components, and executes tasks scheduled via
 *   SwingUtilities.
 * - Accessing Swing components from other threads can lead to unpredictable behavior, race conditions, or visual
 *   inconsistencies.
 * - The EDT can be interacted with using:
 *   - SwingUtilities.invokeLater(Runnable): schedules a task to run asynchronously on the EDT.
 *   - SwingUtilities.invokeAndWait(Runnable): schedules a task and waits for it to complete on the EDT.
 *
 * Key Characteristics
 * - Ensures thread safety for Swing components.
 * - Responsible for rendering, event dispatch, and component updates.
 * - Tasks submitted to the EDT are executed sequentially in the order they arrive.
 * - Long-running operations should be performed outside the EDT (e.g., using background threads or SwingWorker)
 *   to avoid freezing the UI.
 *
 * Usage
 * - Always create and update Swing components on the EDT to maintain responsiveness and consistency.
 * - Use invokeLater for asynchronous tasks and invokeAndWait for tasks that require synchronous execution.
 * - Essential for building stable, responsive, and visually consistent desktop applications with Swing.
 */
import javax.swing.*;

void main() throws Exception {
    /*
     * Invoke Later
     * - Schedules a Runnable to be executed asynchronously on the Event Dispatch Thread (EDT).
     * - Ensures that Swing component creation, updates, and event handling occur on the correct thread.
     * - The calling thread returns immediately; the task is queued and executed after all pending EDT events.
     * - Ideal for safely updating the UI from background threads without blocking them.
     * - Commonly used for initializing or updating the GUI without interrupting ongoing processes.
     */
    SwingUtilities.invokeLater(() -> {
        // Swing code here...
    });

    /*
     * Invoke And Wait
     * - Schedules a Runnable to be executed synchronously on the Event Dispatch Thread (EDT).
     * - The calling thread is blocked until the task completes, guaranteeing that the Runnable has executed before
     *   continuing.
     * - Ensures thread-safe Swing component creation and updates while maintaining execution order.
     * - Must not be called from the EDT itself, or it will throw an exception (deadlock prevention).
     * - Useful when subsequent logic depends on the UI changes being applied immediately.
     */
    SwingUtilities.invokeAndWait(() -> {
        // Swing code here...
    });
}