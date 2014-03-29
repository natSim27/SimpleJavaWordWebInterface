/**
 * @author Nathalie Simons (Student 500324809)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphViewer
{
    /**
     * Creates the GUI of the graph drawing program.
     */
    public static void main (String[] args){
        JFrame frame = new JFrame();
        
        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 650;
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Graph Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        final GraphComponents gComp = new GraphComponents();
        frame.add(gComp,BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.NORTH);
        
        //Creates a rectangle button and draws a rectangle at a desired location.
        JButton rectangleButton = new JButton("Rectangle");
        class RectangleListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                gComp.createRectangle();
            }
        }
        ActionListener rectangleButtonListener = new RectangleListener();
        rectangleButton.addActionListener(rectangleButtonListener);
        panel.add(rectangleButton);
        
        //Creates an ellipse button and draws an ellipse at a desired location.
        JButton ellipseButton = new JButton("Ellipse");
        class EllipseListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                gComp.createEllipse();
            }
        }
        ActionListener ellipseButtonListener = new EllipseListener();
        ellipseButton.addActionListener(ellipseButtonListener);
        panel.add(ellipseButton);
        
        //Creates an edge button and draws an edge from one point to another.
        JButton edgeButton = new JButton("Edge");
        class EdgeListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                gComp.createEdge();
            }
        }
        ActionListener edgeButtonListener = new EdgeListener();
        edgeButton.addActionListener(edgeButtonListener);
        panel.add(edgeButton);
        
        //Creates a label button and add a label to a selected rectangle or ellipse element.
        //Also creates a text field in which the user can enter the text for the label.
        JButton labelButton = new JButton("Label");
        final int FIELD_WIDTH = 10;
        final JTextField labelField = new JTextField(FIELD_WIDTH);
        class LabelListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                String labelString = labelField.getText();      
                gComp.getLabelString(labelString);
                gComp.addLabel();
            }
        }
        ActionListener labelButtonListener = new LabelListener();
        labelButton.addActionListener(labelButtonListener);
        panel.add(labelButton);
        panel.add(labelField);
        
        frame.setVisible(true);
    }
}
