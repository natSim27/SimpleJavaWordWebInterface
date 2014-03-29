/**
 * @author Nathalie Simons (Student #500324809) 
 */
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class RectangleNode extends GraphElement
{
    private final double RECTANGLE_WIDTH = 100;
    private final double RECTANGLE_HEIGHT = 25;
    private final int SPACE = 5;
    private Rectangle2D.Double rect;
    
    /**
     * A rectangle node is a node in the graph in the shape of a rectangle.
     */
    public RectangleNode(){
        super();
    }
    
    public RectangleNode(int x, int y){
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
        if(rect.contains(x,y))
            selected = true;
            
        return selected;    
    }
    
    /**
     * Draws an element into the program
     */
    public void draw(Graphics2D g2){
        rect = new Rectangle2D.Double(getXPos(),getYPos(), RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

        if(selected)
            g2.setColor(Color.GREEN);
        else if(!selected)
            g2.setColor(Color.BLACK);
            
        if(label != null)
            g2.drawString(label,(int)getXPos() + SPACE,((int)getYPos() + (int)RECTANGLE_HEIGHT - SPACE));
            
        g2.draw(rect);
    }
    
    /**
     * Creates a string that gives the width, height and coordinates of the rectangle.
     * @return a string with the properties of the rectangle.
     */
    public String toString(){
        String str = "Width: " + RECTANGLE_WIDTH + "\n" + 
                     "Height: " + RECTANGLE_HEIGHT + "\n" + 
                     "(x,y): (" + getXPos() + "," + getYPos() + ")" + "\n";
        return str;
    }
    
    /**
     * Indicates whether or not the element is an edge or not.
     * @return false as this element is not an edge.
     */
    boolean isEdge(){
        return false;
    }

}
