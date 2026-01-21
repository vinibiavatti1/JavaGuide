/*
 * ProgressMonitor
 * - This section demonstrates the use of the ProgressMonitor class in Java Swing, which provides a dialog with a
 *   progress bar and a Cancel button for long-running tasks.
 *
 * Overview
 * - ProgressMonitor is part of the javax.swing package.
 * - It automatically delays showing the dialog until a default threshold of 500 milliseconds of inactivity is reached.
 * - The dialog shows a progress bar, an optional note, and a Cancel button for user interruption.
 * - Can be used for tasks like file processing, downloads, or any background computation.
 * - Updates should be made from a background thread to keep the GUI responsive.
 *
 * Key Characteristics
 * - Automatically shows after a small delay (default: 500ms) to avoid flashing for very fast tasks.
 * - Progress can range between specified min and max values.
 * - User can cancel the operation at any time by pressing the Cancel button, which can be detected with isCanceled().
 * - Allows displaying descriptive notes with setNote() to inform the user about the current progress or stage.
 * - Supports optional configuration of minimum and maximum progress values, as well as custom messages.
 *
 * Usage
 * - Initialize a ProgressMonitor instance.
 * - Periodically call setProgress() to update the progress bar and setNote() to update descriptive text.
 * - Always check isCanceled() during processing to stop the operation promptly if the user cancels.
 * - Suitable for long-running operations where user feedback and the option to cancel are desired.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring ProgressMonitor
     * - Creates a ProgressMonitor dialog to track the progress of a long-running task.
     * - The first parameter (null) specifies no parent, so the dialog is centered on the screen.
     * - Other parameters define the main message, initial note, minimum value, and maximum value for the progress bar.
     * - The dialog will appear automatically if the task takes longer than the default delay (500ms).
     */
    ProgressMonitor progressMonitor = new ProgressMonitor(null, "Processing...", "0/100", 0, 100);

    /*
     * Set Custom Delays
     * - Allows configuring when the ProgressMonitor dialog appears.
     * - The "setMillisToPopup()" method is used to set the delay (in milliseconds) before the dialog is shown once the
     *   task starts.
     * - The "setMillisToDecideToPopup()" method is used to set the delay (in milliseconds) the monitor waits to decide
     *   whether to show the dialog, useful for very short or fast tasks to avoid flashing dialogs.
     * - Adjust these values to control the responsiveness and appearance of the progress dialog for different task
     *   durations.
     * - Note: The example below sets both delays to zero to display the dialog immediately.
     */
    progressMonitor.setMillisToPopup(0);         // Default: 2000ms
    progressMonitor.setMillisToDecideToPopup(0); // Default: 500ms

    /*
     * Background Task
     * - Runs a long-running task in a separate thread to keep the GUI responsive.
     * - Updates the progress every 200 milliseconds (simulated task delay).
     * - Demonstrates cancellation handling, progress updates, and note updates.
     */
    new Thread(() -> {
        try {
            for (int i = 0; i <= 100; i++) {
                if (progressMonitor.isCanceled()) {
                    IO.println("Operation Canceled");
                    System.exit(0);
                }
                progressMonitor.setProgress(i);
                progressMonitor.setNote(i + "/100");
                Thread.sleep(200);
            }
            IO.println("Operation Finished");
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }).start();
}

/*
 * EDT Initialization
 * - Launches the Swing application safely by scheduling the GUI initialization on the Event Dispatch Thread (EDT).
 */
void main() {
    SwingUtilities.invokeLater(() -> {
        example();
    });
}