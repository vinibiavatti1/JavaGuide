/*
 * Look and Feel (LaF)
 * - This section explains the Look and Feel mechanism in Swing, which defines the visual appearance and behavioral
 *   styling of Swing components without changing application logic.
 *
 * Overview
 * - Look and Feel controls how components are rendered, including colors, fonts, borders, icons, spacing, and basic
 *   interaction behavior.
 * - Swing supports pluggable Look and Feel, allowing the UI style to be changed at runtime.
 * - The Look and Feel system is managed centrally by the UIManager class.
 * - A Look and Feel implementation affects all Swing components created after it is applied.
 *
 * Key Characteristics
 * - UIManager is responsible for installing and managing the active Look and Feel.
 * - The Look and Feel can be set programmatically using UIManager.setLookAndFeel(...).
 * - Look and Feel may be specified by class name or via UIManager.LookAndFeelInfo metadata.
 * - Changing the Look and Feel at runtime requires updating existing components
 *   (e.g., SwingUtilities.updateComponentTreeUI).
 *
 * Built-in Look and Feels
 * - Metal (Default)
 *   - Default cross-platform Look and Feel historically shipped with Swing.
 *   - Fully implemented in Java and behaves consistently across all operating systems.
 * - Nimbus (Recommended)
 *   - Modern, polished Look and Feel introduced in Java 6.
 *   - Cross-platform and implemented entirely in Java.
 *   - Focuses on improved visuals, gradients, and better default spacing.
 * - System Look and Feel
 *   - Delegates rendering to the native operating system theme.
 *   - Appearance adapts to the host OS (e.g., Windows, macOS, Linux).
 *   - Provides better visual integration with the desktop environment.
 * - Motif (Legacy)
 *   - Older UNIX-style Look and Feel.
 *   - Included mainly for backward compatibility.
 *   - Rarely used in modern applications.
 *
 * Operating System Support
 * - Cross-platform Look and Feels (Metal, Nimbus) behave identically on all supported systems.
 * - System Look and Feel varies by OS and desktop environment:
 *   - Windows: Windows Look and Feel
 *   - macOS: Aqua Look and Feel
 *   - Linux: GTK-based Look and Feel (when available)
 * - Availability and behavior may differ depending on the JVM and OS configuration.
 *
 * Usage
 * - Use cross-platform Look and Feel when consistent appearance across systems is required.
 * - Use System Look and Feel for better native integration and user familiarity.
 * - Configure Look and Feel early in application startup, preferably before creating UI components.
 * - Avoid frequent runtime changes unless explicitly required by the application design.
 */
import javax.swing.*;

void main() {
    /*
     * List Native Look and Feels
     * - Uses UIManager.getInstalledLookAndFeels() to query Look and Feels registered at runtime.
     * - Each LookAndFeelInfo provides a user-friendly name and its fully qualified class name.
     * - The available Look and Feels depend on the operating system and the installed JVM.
     * - Output:
     *   Metal: javax.swing.plaf.metal.MetalLookAndFeel
     *   Nimbus: javax.swing.plaf.nimbus.NimbusLookAndFeel
     *   CDE/Motif: com.sun.java.swing.plaf.motif.MotifLookAndFeel
     *   Windows: com.sun.java.swing.plaf.windows.WindowsLookAndFeel
     *   Windows Classic: com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
     */
    for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
        IO.println(laf.getName() + ": " + laf.getClassName());
    }

    /*
     * Set Look and Feel
     * - Uses UIManager.setLookAndFeel to install a Look and Feel by its fully qualified class name.
     * - Executed inside SwingUtilities.invokeLater to guarantee execution on the Event Dispatch Thread (EDT).
     * - Must be executed before creating any UI components to ensure consistent styling.
     * - Can throw checked exceptions if the Look and Feel is not available, supported, or fails to initialize.
     */
    SwingUtilities.invokeLater(() -> {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    });

    /*
     * Set System Look and Feel
     * - Uses UIManager.getSystemLookAndFeelClassName() to resolve the appropriate implementation at runtime.
     * - Executed inside SwingUtilities.invokeLater to guarantee execution on the Event Dispatch Thread (EDT).
     * - Should be called before creating any Swing components to ensure consistent styling.
     * - Can throw checked exceptions if the Look and Feel is not available, supported, or fails to initialize.
     */
    SwingUtilities.invokeLater(() -> {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    });
}