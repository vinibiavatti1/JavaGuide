import javax.swing.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            IO.println(e.getMessage());
        }

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ProgressMonitor pm = new ProgressMonitor(frame, "Processing...", "note", 0, 100);
        frame.setEnabled(false);
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                pm.setProgress(i);
                pm.setNote(i + "/100");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    });

}