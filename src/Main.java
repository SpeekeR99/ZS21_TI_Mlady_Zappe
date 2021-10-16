import javax.swing.*;
import java.util.Scanner;

public class Main {

    /** DrawingPanel to be drawn at */
    private static DrawingPanel drawingPanel;

    public static void main(String[] args) {
        setupWindow();
        run();
    }

    /**
     * Creates window
     */
    private static void setupWindow() {
        JFrame window = new JFrame();
        drawingPanel = new DrawingPanel();
        window.setTitle("NFA_Mlady_Zappe");
        window.setSize(1366, 768);
        window.add(drawingPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    /**
     * Run loop
     */
    private static void run() {
        DFA dfa = new DFA();
        Scanner sc = new Scanner(System.in);
        System.out.println("Start inputing symbols | Q (quit), R (restart), B (step back)");
        while(true) {
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
            String input = sc.next();
            char symbol = input.charAt(0);
            if(symbol == 'Q' || symbol == 'q') {
                System.out.println("Ending...");
                break;
            }
            if(symbol == 'R' || symbol == 'r') {
                dfa.restart();
                System.out.println("DFA has been restarted.");
                continue;
            }
            if(symbol == 'S' || symbol == 's') {
                System.out.println("DFA is in accepting state: " + dfa.stepBack());
                continue;
            }
            System.out.println("DFA is in accepting state: " + dfa.accept(symbol));
        }
    }

}
