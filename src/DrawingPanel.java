import javax.swing.*;
import java.awt.*;

/**
 * Drawing part of the window GUI
 */
public class DrawingPanel extends JPanel {

    /** array of states (Nodes) on GUI */
    public Node[] nodes;

    public DrawingPanel() {
        int width = 1366;
        int height = 768;
        this.setPreferredSize(new Dimension(width, height));
        Node temp = new Node(0, 0, "temp");
        this.nodes = new Node[] {                                                                            // index = state
                new Node(3 * width / 5 - temp.size / 2, 3 * height / 5 - temp.size / 2, "S"),    // 0 = S
                new Node(3 * width / 5 - temp.size / 2, height / 5 - temp.size / 2, "S1"),       // 1 = S1
                new Node(width / 5 - temp.size / 2,     height / 5 - temp.size / 2, "A"),        // 2 = A
                new Node(width / 5 - temp.size / 2,     3 * height / 5 - temp.size / 2, "A1"),   // 3 = A1
                new Node(2 * width / 5 - temp.size / 2, 2 * height / 5 - temp.size / 2, "B"),    // 4 = B
                new Node(2 * width / 5 - temp.size / 2, 4 * height / 5 - temp.size / 2, "B1"),   // 5 = B1
                new Node(4 * width / 5 - temp.size / 2, height / 5 - temp.size / 2, "C"),        // 6 = C
                new Node(4 * width / 5 - temp.size / 2, 3 * height / 5 - temp.size / 2, "C1"),   // 7 = C1
                new Node(4 * width / 5 - temp.size / 2, 4 * height / 5 - temp.size / 2, "C2"),   // 8 = C2
                new Node(3 * width / 5 - temp.size / 2, 4 * height / 5 - temp.size / 2, "ERR")   // 9 = ERR
        };
    }

    /**
     * Drawing
     * @param g graphics context
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // better Graphics
        Graphics2D g2 = (Graphics2D) g;
        for(Node n : nodes) {
            n.draw(g2);
        }
    }


}