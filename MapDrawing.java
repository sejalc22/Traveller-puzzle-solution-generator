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

import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;

//container class inheriting JPanel class to hold graphics of edges and vertices
@SuppressWarnings("serial")
public class MapDrawing extends JPanel {
	
	//lists of vertex and edge graphics to be displayed
	LinkedList<VertexDrawing> vertices ;
	LinkedList<EdgeDrawing> edges ;
	//list of edges operated by buttons
	LinkedList<EdgeDrawing> modEdges;
	//list of buttons
	LinkedList<JButton> buttons ;
	
	//initialize size of mapdrawing
	MapDrawing()
	{
		this.setSize(1500, 1000);
	}
	
	//input references of vertex and edges and buttons lists
	public void addLists(LinkedList<VertexDrawing> v, LinkedList<EdgeDrawing> e, LinkedList<JButton> b, LinkedList<EdgeDrawing> m)
	{
		vertices = v;
		edges = e;
		buttons = b;
		modEdges = m;

	}
	
	//override paintComponent method of JPanel
	public void paintComponent(Graphics g)
	{
		//draw all edges on panel
		for(EdgeDrawing e : edges)
		{
			e.draw(g);
		}
		//draw all vertices on panel
		for (VertexDrawing v : vertices)
		{
			v.draw(g);
		}
		//place all buttons on panel
		for(JButton j : buttons)
		{
		    this.add(j);
		}
	}
	
}
