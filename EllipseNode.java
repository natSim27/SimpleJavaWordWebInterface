/**
 * @author Nathalie Simons (Student #500324809) 
 */
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class EllipseNode extends GraphElement
{
    private final double ELLIPSE_WIDTH = 100;
    private final double ELLIPSE_HEIGHT = 25;
    private final int SPACE = 10;
    private Ellipse2D.Double ellip;
    
    /**
      * An ellipse node is a node in the graph in the shape of an ellipse.
      */
    public EllipseNode(){
        super();
    }
    
    public EllipseNode(double x, double y){
        super(x,y);
    }
    
    /**
      * Indicated whether or not the ellipse element is selected.
      * @param x the x-coordinate of the location to test.
      * @param y the y-coordinate of the location to test.
      * @return true or false if the location indicated is in the element 
      *  and therefore selecting the element.
      */
    public boolean isSelected(double x, double y){
        if(ellip.contains(x,y))
            selected = true;
            
        return selected;    
    }
    
    /**
     * Draws an element into the program.
     */
    public void draw(Graphics2D g2){
        ellip = new Ellipse2D.Double(getXPos(), getYPos(), ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
        
        if(selected)
            g2.setColor(Color.GREEN);
        else if(!selected)
            g2.setColor(Color.BLACK);
            
        if(label != null)
            g2.drawString(label,
                          (int)getXPos() + SPACE,
                          ((int)getYPos() + (int)ELLIPSE_HEIGHT - SPACE));
        
        g2.draw(ellip);
    }
    
    /**
     * Indicates whether or not the element is an edge.
     * @return false as this is element is not an edge.
     */
    boolean isEdge(){
        return false;
    }

}
