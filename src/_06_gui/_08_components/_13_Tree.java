/*
 * Tree (JTree)
 * - This section explains the JTree component in Swing, which represents hierarchical data in a tree structure,
 *   allowing nodes to be expanded and collapsed by the user.
 *
 * Overview
 * - JTree is part of the javax.swing package.
 * - It extends JComponent and displays data using a tree-based hierarchy.
 * - The tree data is managed by a TreeModel, which defines the structure and relationships between nodes.
 * - By default, JTree uses DefaultTreeModel together with DefaultMutableTreeNode.
 *
 * Model and Nodes
 * - DefaultMutableTreeNode represents a mutable node in the tree structure.
 * - Each node can contain a user object (typically a String or domain object).
 * - Nodes can have parent–child relationships and be dynamically inserted or removed.
 * - The root node acts as the entry point of the tree hierarchy.
 *
 * Key Characteristics
 * - Supports single and multiple selection modes.
 * - Nodes can be expanded or collapsed to show or hide children.
 * - Root handles can be displayed to improve navigation.
 * - The number of visible rows can be configured to control the preferred height.
 * - Fully integrates with the current Look and Feel for consistent rendering.
 *
 * Usage
 * - Use JTree to represent hierarchical data such as file systems, menus, or organizational structures.
 * - Combine with JScrollPane to ensure all nodes remain accessible.
 * - Custom renderers can be used to control node appearance and icons.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.tree.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Tree");
    frame.setSize(750, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Tree
     * - Demonstrates a basic JTree built using DefaultMutableTreeNode.
     * - The root node represents the top-level element of the hierarchy.
     * - Child nodes are inserted explicitly to form parent–child relationships.
     * - Root handles are enabled to display expand/collapse controls.
     * - The visible row count defines how many rows are shown before scrolling is required.
     */
    DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Folder");
    DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("File 1");
    DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("File 2");
    DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("File 3");
    parent.insert(child1, 0);
    parent.insert(child2, 1);
    parent.insert(child3, 2);
    JTree tree1 = new JTree(parent);
    tree1.setShowsRootHandles(true);
    tree1.setVisibleRowCount(10);
    JScrollPane scrollPane1 = new JScrollPane(
            tree1,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    tree1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Editable Tree
     * - Demonstrates a JTree with editable nodes enabled.
     * - Allows the user to rename nodes directly in the tree.
     * - Editing affects the underlying TreeModel and node user objects.
     */
    JTree tree2 = new JTree(parent);
    tree2.setEditable(true);
    tree2.setVisibleRowCount(10);
    tree2.setShowsRootHandles(true);
    JScrollPane scrollPane2 = new JScrollPane(
            tree2,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane2);

    /*
     * Tree With Single Selection
     * - Demonstrates a JTree restricted to selecting only one node at a time.
     * - This is the default selection mode for JTree.
     * - Controlled via TreeSelectionModel.SINGLE_TREE_SELECTION.
     */
    JTree tree3 = new JTree(parent);
    tree3.setVisibleRowCount(10);
    tree3.setShowsRootHandles(true);
    tree3.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    JScrollPane scrollPane3 = new JScrollPane(
            tree3,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane3);

    /*
     * Tree With Contiguous Selection
     * - Demonstrates a JTree allowing selection of adjacent nodes.
     * - Users can select a continuous range of nodes.
     * - Useful for operations applied to grouped tree items.
     */
    JTree tree4 = new JTree(parent);
    tree4.setVisibleRowCount(10);
    tree4.setShowsRootHandles(true);
    tree4.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    JScrollPane scrollPane4 = new JScrollPane(
            tree4,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane4);

    /*
     * Disabled Tree
     * - Demonstrates a JTree in a disabled state.
     * - Disabled trees are visible but do not allow user interaction.
     * - Commonly used to indicate unavailable hierarchical data.
     */
    JTree tree5 = new JTree(parent);
    tree5.setVisibleRowCount(10);
    tree5.setShowsRootHandles(true);
    tree5.setEnabled(false);
    JScrollPane scrollPane5 = new JScrollPane(
            tree5,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane5);

    /*
     * Tree With Custom Icons
     * - Demonstrates customizing node icons using a TreeCellRenderer.
     * - DefaultTreeCellRenderer allows configuring icons for leaf, open, and closed nodes.
     * - Useful for visually distinguishing node types (e.g., folders and files).
     */
    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    renderer.setLeafIcon(new ImageIcon(this.getClass().getResource("/gui/page_white.png")));
    renderer.setClosedIcon(new ImageIcon(this.getClass().getResource("/gui/folder.png")));
    renderer.setOpenIcon(new ImageIcon(this.getClass().getResource("/gui/folder.png")));
    JTree tree6 = new JTree(parent);
    tree6.setCellRenderer(renderer);
    tree6.setShowsRootHandles(true);
    tree6.setVisibleRowCount(10);
    JScrollPane scrollPane6 = new JScrollPane(
            tree6,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane6);

    /*
     * Tree Listener
     * - Demonstrates adding a TreeSelectionListener to a JTree.
     * - The listener is triggered whenever the selected node changes.
     * - The selected node can be retrieved using getLastSelectedPathComponent().
     */
    tree1.addTreeSelectionListener(evt -> IO.println(tree1.getLastSelectedPathComponent()));

    /*
     * Set Visible
     * - Makes the frame visible on the screen to demonstrate the component in action.
     */
    frame.setVisible(true);
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
