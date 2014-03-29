/**
 * @author Nathalie Simons (Student 500324809)
 */
import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComponent;


import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class GraphComponents extends JComponent
{
    ArrayList<GraphElement> geList = new ArrayList<GraphElement>();
    
    int startX;
    int startY;
    int endX;
    int endY;
    
    boolean createRectangle = false;
    boolean createEllipse = false;
    boolean createEdge = false;
    boolean addLabel = false;
    
    String labelString;
    
    /**
     * The graph components are all controlled and manipulated in this class.
     */
    public GraphComponents(){
       class MousePressListener implements MouseListener{
           
            /**
             *Performes actions when the mouse buttons are pressed.
             *@param event a registered event of the mouse.
             */
            public void mousePressed(MouseEvent event){
                int x = event.getX();
                int y = event.getY();
                int leftRightButton = event.getButton();
                
                //Creates rectangles if the rectangle button is pressed.
                if(createRectangle){
                    RectangleNode r = new RectangleNode(x,y);
                    geList.add(r);
                    createRectangle = false;
                    deSelectAll();
                }
                
                //Creates ellipses if the ellipse button is pressed.
                else if(createEllipse){
                    EllipseNode e = new EllipseNode(x,y);
                    geList.add(e);
                    createEllipse = false;
                    deSelectAll();
                }
                
                //Stores the coordinates of the starting point of an edge if the 
                //edge button has been pressed and deselects any elements previously selected.
                else if(createEdge){
                    startX = x;
                    startY = y;
                    deSelectAll();
                }
                
                //Indicates whether or not the right mouse button was clicked and if an element
                //is selected deletes it from the element array and the program.
                else if(leftRightButton == 3){
                    for(int i = 0; i < geList.size(); i++){
                        if(geList.get(i).selected){
                           delete(i);
                            deSelectAll();
                        }
                    }
                }
                
                //If no buttons are pressed the program checks if any new elements 
                //are being selected and deselects an element if blank space is clicked.
                else{
                  for(int i=0; i < geList.size(); i++){
                      GraphElement e = geList.get(i);
                      if(geList != null && geList.get(i).selected == true){
                          deSelectAll();
                      }
                      e.isSelected(x,y);
                      
                  }
                }
                
                repaint();
            }
            
            /**
             *Performes actions when a mouse button is released.
             *@param event a registered event of the mouse.
             */
            public void mouseReleased(MouseEvent event){
                
                //Creates an edge if the edge button has been pressed and the mouse is released. 
                //Collects the starting and end point of the edge from when the 
                //mouse was clicked and when the mouse was dragged to.
                if(createEdge){
                    Edge e = new Edge(startX, startY, endX, endY);
                    geList.add(e);
                    createEdge = false;
                }
                repaint();
                
            }
            
            public void mouseClicked(MouseEvent event){}
            public void mouseEntered(MouseEvent event){}
            public void mouseExited(MouseEvent event){}
        }
    
        MouseListener mListener = new MousePressListener();
        addMouseListener(mListener);
        

        class MouseMotion implements MouseMotionListener{
            
            /**
             *Performes actions when the mouse buttons are pressed and dragged.
             *@param event a registered event of the mouse. 
             */
            public void mouseDragged(MouseEvent event){
                int x = event.getX();
                int y = event.getY();
                
                //Collects the coordinates of the end point of the an edge if 
                //the edge button has been pressed.
                if(createEdge){
                    endX = x;
                    endY = y;
                }
                
                //Checks if an element has been selected and then moves it to a desired location.
                else{
                    for(int i = 0; i < geList.size(); i++){
                        if(geList.get(i).selected && !geList.get(i).isEdge()){
                            geList.get(i).moveTo(x,y);
                        }
                    }
                }
                
                repaint();
            }
            
            public void mouseMoved(MouseEvent event){}
        }
        MouseMotion motionListener = new MouseMotion();
        addMouseMotionListener(motionListener);
    }

    /**
     * Indicates when the rectangle button is pressed and the program must create a rectangle.
     */
    public void createRectangle(){
        createRectangle = true;
    }
    
    /**
     * Indicates when the ellipse button is pressed and the program must create a ellipse.
     */
    public void createEllipse(){
        createEllipse = true;
    }
    
    /**
     * Indicates when the edge button is pressed and the program must create a edge.
     */
    public void createEdge(){
        createEdge = true;
    }
    
    /**
     * Indicates when the label button is pressed and add a label to a selected 
     * rectangle or ellipse node.
     */
    public void addLabel(){
        for(int i = 0; i < geList.size(); i++){
            if(geList.get(i).selected && geList.get(i).isEdge() == false){
                geList.get(i).setLabel(labelString);
                deSelectAll();
            }
        }
        repaint();
    }
    
    /**
     * Gets the text for a label.
     * @param s a string for a label. 
     */
    public void getLabelString(String s){
        labelString = s;
    }
    
    /**
     * Deletes an element from the element array and program.
     */
    public void delete(int i){
        if(geList.get(i) != null)
            geList.remove(i);
        repaint();
    }
    
    /**
     * Deselects all the elements from the array.
     */
    public void deSelectAll(){
        if(geList != null){
            for(int i = 0; i < geList.size(); i++){
                geList.get(i).deSelect();
            }
        }
    }
    
    /**
     * Paints the elements on the program.
     */
    public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i < geList.size(); i++)
      {
          GraphElement e = geList.get(i);
          e.draw(g2);
      }
    }
}
