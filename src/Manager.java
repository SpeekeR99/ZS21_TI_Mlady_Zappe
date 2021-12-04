import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Originally this class was just the input panel and buttons
 * But it turned out this class controls the whole app
 */
public class Manager extends JPanel {

    /** text input from user */
    public JTextField text;
    /** automata */
    public DFA dfa;
    /** DrawingPanel to be drawn at */
    public DrawingPanel drawingPanel;

    public Manager() {
        int width = 1366;
        int height = 50;
        this.setPreferredSize(new Dimension(width, height));
        text = new JTextField(20);
        this.dfa = new DFA();
        this.drawingPanel = new DrawingPanel();
        drawingPanel.nodes[0].highlighted = true;
        drawingPanel.isAccepted = false;
        this.add(text);
        createButtons();
        text.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                drawingPanel.isAccepted = dfa.accept(text.getText().charAt(text.getText().length() - 1));
                repaintPanel();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                drawingPanel.isAccepted = dfa.stepBack();
                repaintPanel();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    /**
     * Copyright in the right bottom corner
     * @param g Graphics context
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        FontMetrics fm = g2.getFontMetrics();
        String s = "© Dominik Zappe, Jakub Mladý, 2021";
        g2.drawString(s, this.getWidth() - fm.stringWidth(s), this.getHeight() - fm.getHeight() / 2);
    }

    /**
     * Sets up the basic buttons
     */
    private void createButtons() {
        JButton reset = new JButton("Restart");
        JButton quit = new JButton("Ukončit");
        this.add(reset);
        reset.addActionListener(e -> {
            dfa.restart();
            text.setText("");
        });
        reset.setFont(new Font("Arial", Font.BOLD, 12));
        reset.setBackground(new Color(0x2D2D2D));
        reset.setForeground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setFocusable(false);
        this.add(quit);
        quit.addActionListener(e -> Main.window.dispose());
        quit.setFont(new Font("Arial", Font.BOLD, 12));
        quit.setBackground(new Color(0x2D2D2D));
        quit.setForeground(Color.WHITE);
        quit.setFocusPainted(false);
        quit.setFocusable(false);
    }

    /**
     * Repaints the DrawingPanel with current state being highlighted
     */
    private void repaintPanel() {
        for(Node n : drawingPanel.nodes) {
            n.highlighted = false;
        }
        switch(dfa.currentState) {
            case S: drawingPanel.nodes[0].highlighted = true;
                break;
            case S1A1: drawingPanel.nodes[1].highlighted = true;
                drawingPanel.nodes[3].highlighted = true;
                break;
            case B: drawingPanel.nodes[4].highlighted = true;
                break;
            case BC1: drawingPanel.nodes[4].highlighted = true;
                drawingPanel.nodes[7].highlighted = true;
                break;
            case B1: drawingPanel.nodes[5].highlighted = true;
                break;
            case B1C2: drawingPanel.nodes[5].highlighted = true;
                drawingPanel.nodes[8].highlighted = true;
                break;
            case C: drawingPanel.nodes[6].highlighted = true;
                break;
            case C1: drawingPanel.nodes[7].highlighted = true;
                break;
            case C2: drawingPanel.nodes[8].highlighted = true;
                break;
            case CB1: drawingPanel.nodes[6].highlighted = true;
                drawingPanel.nodes[5].highlighted = true;
                break;
            case ERR: drawingPanel.nodes[9].highlighted = true;
                break;
        }
        drawingPanel.repaint();
    }

}
