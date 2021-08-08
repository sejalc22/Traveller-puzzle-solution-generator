/*
Title:
Puzzle solution generator using graph data structure

 Name: Sejal Chaudhari
 
 
Team members:
2323_SEJAL CHAUDHARI
2309_ISHANI ATRE
2307_ANSHIKA UPADHYAY
2310_SHIVANI BHANGADE 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

//user class inherits windowadapter and implements actionlistener
//class to respond to window events and button events
public class Listener extends WindowAdapter implements ActionListener {

	MapDrawing map ;      //mapdrawing object to call methods on in response to button clicks
	JFrame f1, f2;        //jframe objects to call methods on in response to window events
	Graph g;              //graph object to call shortest path method 
		
	//add references of objects
   public void add(MapDrawing m, JFrame f1, JFrame f2, Graph g)
	{
		map = m;
		this.f1 = f1;
		this.f2 = f2;
		this.g = g;
	}
   
   //override actionperformed method of actionlistener interface
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		//loop through list of buttons placed on mapdrawing panel
			for(int i = 0; i<map.buttons.size() ; i++)
			{
				//if button has been clicked 
				if(e.getSource() == map.buttons.get(i))
				{
					//reset color of corresponding edge
					EdgeDrawing ed = map.modEdges.get(i);
					ed.setColor(Color.red);
					
					//remove edge from graph 
	                g.remEdge(ed.v1, ed.v2);
	                //repaint map drawing
					map.repaint();
				}
			}
	}
	
	//override windowclosing function of windowadapter superclass
	public void windowClosing(WindowEvent e)
	{
		//if f1 frame is closed do operations
		if(e.getSource() == f1)
		{
			g.printShortestDistance( 0, 44);                                      //calculate shortest path from start to end vertex 
			PathDrawing finalPath = new PathDrawing(map.vertices, map.edges);    //create object of pathdrawing panel
			finalPath.addPath(g.path);                                            //pass list of vertices in shortest path
			finalPath.repaint();                                                 //display shortest path
			f2.add(finalPath);                                                  //add panel to frame f2
			f2.setLocationRelativeTo(finalPath);         
			f2.setVisible(true);                                                //set frame visible
		}
		
	}

}
