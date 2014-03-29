/**
 * @author Nathalie Simons (Student #500324809) 
 */
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class Edge extends GraphElement
{
    private double x2Pos;
    private double y2Pos;
    private Point2D.Double pointOne;
    private Point2D.Double pointTwo;
    private Line2D.Double segment;

    /**
     * Edges are line segments in the graph.
     */
    public Edge(){
        super();
        x2Pos = 0;
        y2Pos = 0;
      
    }
    
    public Edge(double x1, double y1, double x2, double y2){
        super(x1,y1);
        x2Pos = x2;
        y2Pos = y2;
        
    }
    
    /**
     * Draws an element into the program.
     */
    public void draw(Graphics2D g2){
        pointOne = new Point2D.Double(getXPos(), getYPos());
        pointTwo = new Point2D.Double(x2Pos, y2Pos);
        segment = new Line2D.Double(pointOne, pointTwo);
        
        if(selected)
            g2.setColor(Color.RED);
        else if(!selected)
            g2.setColor(Color.BLACK);
            
        g2.draw(segment);
    }
    
    /**
      * Indicated whether or not the ellipse element is selected.
      * @param x the x-coordinate of the location to test.
      * @param y the y-coordinate of the location to test.
      * @return true or false if the location indicated is a neglibible distance from 
      *  the edge element and therefore selecting the element.
      */
    public boolean isSelected(double x, double y){
        if(segment.ptLineDist(x,y) < 1.0)
             selected = true;
            
        return selected;    
    }
    
    /**
     * Indicates whether or not the element is an edge.
     * @return true as this element is an edge
     */
    boolean isEdge(){
        return true;
    }

}
