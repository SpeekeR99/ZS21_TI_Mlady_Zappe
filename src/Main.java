import javax.swing.*;
import java.awt.*;

/**
 * Main class
 */
public class Main {

    /** Window */
    public static JFrame window;

    /**
     * Entry point, just setsup the window
     * @param args arguments from cmd, unused
     */
    public static void main(String[] args) {
        setupWindow();
    }

    /**
     * Creates window
     */
    private static void setupWindow() {
        window = new JFrame();
        Manager manager = new Manager();
        DrawingPanel drawingPanel = manager.drawingPanel;
        window.setTitle("NFA_Mlady_Zappe");
        window.setSize(1366, 768);
        window.add(drawingPanel);
        window.add(manager, BorderLayout.SOUTH);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

}
