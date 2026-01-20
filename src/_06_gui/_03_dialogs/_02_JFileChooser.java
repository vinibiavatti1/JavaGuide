/*
 * JFileChooser
 * - This section explains the JFileChooser class in Java Swing, which provides a standard dialog for selecting files
 *   and directories from the local file system.
 *
 * Overview
 * - JFileChooser is part of the javax.swing package and is used to present a file selection dialog to the user.
 * - It supports opening files, saving files, and selecting directories, depending on its configuration.
 * - The dialog is typically modal, blocking interaction with the parent window until the user approves or cancels.
 * - JFileChooser does not open, read, or write files; it only returns the user’s selection as File objects.
 *
 * Key Characteristics
 * - Can be displayed without an explicit JFrame; a null parent centers the dialog on the screen.
 * - Integrates with the operating system’s file system and respects the current Look & Feel.
 * - Highly configurable: supports file filters, selection modes, multi-selection, and custom approval button text.
 *
 * Methods
 * - showOpenDialog: Displays a dialog for selecting an existing file or directory to open.
 * - showSaveDialog: Displays a dialog for choosing a file location and name for saving.
 * - showDialog: Displays a generic file chooser dialog with a custom approval button label.
 *
 * Selection Modes
 * - JFileChooser.FILES_ONLY: Allows selection of files only (default behavior).
 * - JFileChooser.DIRECTORIES_ONLY: Allows selection of directories only.
 * - JFileChooser.FILES_AND_DIRECTORIES: Allows selection of both files and directories.
 *
 * File Filters
 * - FileNameExtensionFilter: Filters files by one or more file extensions (e.g., "png", "txt", "pdf").
 * - Custom FileFilter: Allows defining arbitrary rules for file visibility (size, name pattern, etc.).
 * - Accept All Files (*.*): Default filter that shows all files, which can be disabled if needed.
 *
 * Usage
 * - Use JFileChooser when the application needs user interaction with the local file system.
 * - Ideal for open/save workflows, import/export features, and directory selection.
 * - Always check the returned result (APPROVE_OPTION or CANCEL_OPTION) before using the selected file.
 * - Validation of file existence, permissions, size, and overwrite confirmation must be handled by the application.
 * - Output: A standard file selection dialog that returns the chosen File or Files based on user action.
 */
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

void example() {
    //==================================================================================================================
    // File Chooser Types
    //==================================================================================================================

    /*
     * Open Dialog
     * - Displays a file selection dialog using JFileChooser, allowing the user to choose an existing file or directory
     *   to open.
     * - The first parameter (null) means the dialog has no parent component and will be centered on the screen.
     * - The dialog is modal by default, blocking input to other application windows until the user approves or cancels.
     * - By default, only files can be selected, and only a single file is allowed.
     */
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null);

    /*
     * Save Dialog
     * - Displays a file selection dialog using JFileChooser, allowing the user to choose a file name and location
     *   for saving data.
     * - The first parameter (null) means the dialog has no parent component and will be centered on the screen.
     * - The dialog is modal by default, blocking input to other application windows until the user approves or cancels.
     * - The dialog does not create or write the file; it only returns the selected path.
     * - If the selected file already exists, no overwrite confirmation is performed automatically and must be
     *   handled by the application.
     */
    fileChooser = new JFileChooser();
    fileChooser.showSaveDialog(null);

    /*
     * Generic Dialog
     * - Displays a customizable file chooser dialog using JFileChooser with a custom approval button label.
     * - The first parameter (null) means the dialog has no parent component and will be centered on the screen.
     * - The second parameter defines the text shown on the approval button (e.g., "Delete!", "Select", "Import").
     * - The dialog is modal by default, blocking input to other application windows until the user approves or cancels.
     * - This method is useful for actions that are not strictly "Open" or "Save", such as delete, import, or export.
     */
    fileChooser = new JFileChooser();
    fileChooser.showDialog(null, "Delete!");

    //==================================================================================================================
    // File Chooser Operations
    //==================================================================================================================

    /*
     * Set Current Directory
     * - Initializes a JFileChooser and sets the directory that will be displayed when the dialog opens.
     * - The constructor can take a String or File parameter to set the initial directory at creation.
     * - The "setCurrentDirectory(File)" method can also be used to change the directory at any time before showing the
     *   dialog.
     */
    fileChooser = new JFileChooser("C:/");
    fileChooser.setCurrentDirectory(Path.of("C:/").toFile());
    fileChooser.showOpenDialog(null);

    /*
     * Set Selected File
     * - Initializes a JFileChooser and sets a specific file to be selected when the dialog opens.
     * - The "setSelectedFile(File)" method preselects the given file, which can be useful for suggesting a default
     *   file name in Save dialogs or highlighting a specific file in Open dialogs.
     */
    fileChooser = new JFileChooser();
    fileChooser.setSelectedFile(Path.of("C:/file.txt").toFile());
    fileChooser.showOpenDialog(null);

    /*
     * Set Mode
     * - Configures the types of items that can be selected in a JFileChooser dialog.
     * - Available selection modes:
     *   - JFileChooser.FILES_ONLY: Only files can be selected (default).
     *   - JFileChooser.DIRECTORIES_ONLY: Only directories can be selected.
     *   - JFileChooser.FILES_AND_DIRECTORIES: Both files and directories can be selected.
     * - The selection mode affects what is displayed and selectable in the dialog.
     */
    fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    fileChooser.showOpenDialog(null);

    /*
     * Return Option
     * - Demonstrates handling the return value from a JFileChooser dialog to determine the user's action.
     * - Options returned by the dialog include:
     *   - JFileChooser.APPROVE_OPTION (0): The user approved the selection (clicked "Open" or "Save").
     *   - JFileChooser.CANCEL_OPTION (1): The user canceled the dialog (clicked "Cancel" or closed the window).
     *   - JFileChooser.ERROR_OPTION (3): An error occurred or the dialog could not be displayed.
     * - Use the returned option to decide whether to process the selected file or handle cancellation/errors
     *   appropriately.
     * - Output: Option: 0 (APPROVE_OPTION) / 1 (CANCEL_OPTION) / 3 (ERROR_OPTION)
     */
    fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(null);
    IO.println("Option: " + option);

    /*
     * Get Selected File
     * - Retrieves the file selected by the user from a JFileChooser dialog.
     * - The "getSelectedFile()" method returns a File object representing the selected file or directory.
     * - For Save dialogs, the returned File can be non-existent, and null may be returned if no selection is made.
     * - Always check the return option (APPROVE_OPTION) before calling getSelectedFile() to avoid null values.
     * - Example Output: C:/documents/file.txt
     */
    fileChooser = new JFileChooser();
    option = fileChooser.showOpenDialog(null);
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        IO.println(file.getAbsolutePath());
    }

    /*
     * Get Selected Directory
     * - Retrieves a directory selected by the user using JFileChooser.
     * - Set the selection mode to choose what kind of items can be selected. This example changed the mode to accept
     *   only directories: JFileChooser.DIRECTORIES_ONLY.
     * - Always check the return option (APPROVE_OPTION) before calling getSelectedFile() to ensure a valid selection.
     * - Example Output: C:/documents
     */
    fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    option = fileChooser.showOpenDialog(null);
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        IO.println(file.getName());
    }

    /*
     * Multiple Selections
     * - The "setMultiSelectionEnabled()" enables selection of multiple files or directories in a single JFileChooser
     *   dialog.
     * - Works for both files and directories depending on the current selection mode.
     * - Always check the return option (APPROVE_OPTION) before calling getSelectedFiles() to ensure valid selections.
     * - Example Output: [C:/documents/file1.txt, C:/documents/file2.txt, ...]
     */
    fileChooser = new JFileChooser();
    fileChooser.setMultiSelectionEnabled(true);
    option = fileChooser.showOpenDialog(null);
    if (option == JFileChooser.APPROVE_OPTION) {
        File[] files = fileChooser.getSelectedFiles();
        IO.println(Arrays.toString(files));
    }

    //==================================================================================================================
    // File Extension Filters
    //==================================================================================================================

    /*
     * File Extension Filter
     * - Applies a filter to the JFileChooser to display only files with specific extensions.
     * - Uses FileNameExtensionFilter, which takes a description string and one or more extensions as parameters.
     *   - Description: Text shown in the file type dropdown (e.g., "Images (*.png, *.jpg)").
     *   - Extensions: File extensions to allow (e.g., "png", "jpg").
     * - The filter only affects visibility in the dialog; it does not validate the file content.
     */
    fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Images (*.png, *.jpg)", "png", "jpg"));
    fileChooser.showOpenDialog(null);

    /*
     * Multiple File Extension Filters
     * - Adds multiple file extension filters to a JFileChooser, allowing the user to choose which type of files to
     *   display.
     * - The first filter set with setFileFilter becomes the default active filter when the dialog opens.
     * - Additional filters can be added using addChoosableFileFilter, giving users the option to switch between them.
     * - Only one filter is active at a time; filters are not combined.
     * - This setup is useful for applications that support multiple file types, such as images, documents, and text
     *   files.
     */
    fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Images (*.png, *.jpg)", "png", "jpg")); // Default Filter
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Documents (*.doc, *.pdf)", "doc", "pdf"));
    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));
    fileChooser.showOpenDialog(null);

    /*
     * Disable All Files Filter
     * - Disables the default "All Files (*.*)" filter in JFileChooser so that only the custom filters are available.
     * - Use "setAcceptAllFileFilterUsed(false)" to prevent users from bypassing the defined file filters.
     * - After disabling, add one or more custom filters using setFileFilter or addChoosableFileFilter.
     * - This ensures that only files matching the specified extensions or rules are selectable in the dialog.
     * - Example: Only show image files with extensions "png" and "jpg".
     */
    fileChooser = new JFileChooser();
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.setFileFilter(new FileNameExtensionFilter("Images (*.png, *.jpg)", "png", "jpg"));
    fileChooser.showOpenDialog(null);

    /*
     * Custom Filter
     * - Demonstrates creating a custom file filter for JFileChooser by extending the abstract FileFilter class.
     * - The "accept()" method defines the rule for which files or directories are visible; in this example, only
     *   directories or files smaller than 1MB are shown.
     * - The "getDescription()" method provides a description displayed in the file type dropdown.
     * - Custom filters allow implementing advanced rules, such as filtering by size, name patterns, or other file
     *   attributes.
     */
    fileChooser = new JFileChooser();
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
            return !f.isDirectory() || f.length() < (1024 * 1024);
        }

        @Override
        public String getDescription() {
            return "Files smaller than 1MB";
        }
    });
    fileChooser.showOpenDialog(null);

    // Stop Program and Event Dispatch Thread (EDT)
    System.exit(0);
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