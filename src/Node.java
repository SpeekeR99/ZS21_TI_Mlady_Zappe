import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Class represents drawn State on GUI
 */
public class Node {

    /** x coordinate on DrawingPanel */
    public int x;
    /** y coordinate on DrawingPanel */
    public int y;
    /** name of the state, e.g. starting state is named S */
    public String name;
    /** size of the state */
    public int size;
    /** if this is true, then the node will be highlighted */
    public boolean highlighted;

    public Node(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.size = 100;
        this.highlighted = false;
    }

    /**
     * Draws itself on the DrawingPanel
     * @param g2 graphics context
     */
    public void draw(Graphics2D g2) {
        g2.setStroke(new BasicStroke(4));
        g2.setColor(new Color(0x238D23));
        if(highlighted) g2.fill(new Ellipse2D.Double(x, y, size, size));
        g2.setColor(Color.BLACK);
        g2.draw(new Ellipse2D.Double(x, y, size, size));
        g2.setFont(new Font("Times new Roman", Font.BOLD, 32));
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(this.name, x + size / 2 - fm.stringWidth(this.name) / 2, y + size / 2 + fm.getHeight() / 4);
    }

}
