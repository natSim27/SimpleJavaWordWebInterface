/**
 * @author Nathalie Simons (Student 500324809)
 */

import java.awt.Graphics2D;
import java.util.ArrayList;

// General element of a graph (nodes and edges)

abstract public class GraphElement
{
     private double xPos;
     private double yPos;
     public boolean selected = false;
     protected String label;
     
     /**
      *A graph element is an element in the graph. These include rectangle and ellipse
      *nodes and edges.
      */    
     public GraphElement()
     {
        xPos = 0;
        yPos = 0;
     }
       
     public GraphElement(double x, double y)
     {
        xPos = x;
        yPos = y;
     }
      
     /**
      * Returns the x position of the element.
      * @return the x position.
      */
     public final double getXPos()
     {
        return xPos;
     }
       
     /**
      * Returns the y position of the element.
      * @return the y position.
      */
     public final double getYPos()
     {
        return yPos;
     }

     /**
      * Moves a graph element from its original location to new chosen location.
      * @param xLoc the new x postion of the element.
      * @param yLoc the new y position of the element.
      */
     public void moveTo (double xLoc, double yLoc)
     {
        xPos = xLoc;
        yPos = yLoc;
     }
       
     /**
      * Puts the x and y locations of the element in a string.
      * @return a string with the coordinates of the element
      */
     public String toString()
     {
        String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n";
        return str;
     }
       
     /**
      * An abstract method to ensure that the subclass draws the element itself.
      */
     abstract void draw(Graphics2D g2); 
     /**
      * An abstract method to ensure that the subclass can indicate whether or not 
      * the element is selected.
      */
     abstract boolean isSelected(double x, double y);

    /**
      * Tests if the element is an edge or not.
      * @return true or false if the element is an edge or not.
      */
    boolean isEdge(){
        return false;
    }
  
    /**
      * Returns the label text in a string.
      * @return a string containing the label text.
      */
     public String getLabel()
     {
       return label;
     }
          
     /**
      * Sets the text for a label.
      * @param label a string with the text for a label.
      */
     public void setLabel(String label)
     {
       this.label = label;
     }
     
     /**
      * Deselects an element.
      */
     public void deSelect(){
         selected = false;
     }
}