
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
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

//container class inheriting JPanel class to hold graphics of edges and vertices in the final path
@SuppressWarnings("serial")
public class PathDrawing extends JPanel {

	LinkedList<VertexDrawing> vertices ;   //list of vertices to be printed
	LinkedList<EdgeDrawing> edges ;        //list of edges to be printed
	LinkedList<Integer> path;               //list holding the shortest path
	
	//constructor
	PathDrawing(LinkedList<VertexDrawing> vertices, LinkedList<EdgeDrawing> edges)
	{
		//set size of panel
		this.setSize(1500, 1000);
		this.vertices = vertices;
		this.edges = edges;
	}
	
	//input list holding shortest path
	void addPath(LinkedList<Integer> path)
	{
		this.path = path;
	}
	
	//override paintComponent method of JPanel
	public void paintComponent(Graphics g)
	{
		//draw all edges
		for(EdgeDrawing e : edges)
		{
			e.draw(g);
		}
		//draw all vertices
		for (VertexDrawing v : vertices)
		{
			v.draw(g);
		}
		//draw all edges that form part of shortest path
		for(int i = path.size() - 1 ; i>0 ; i-- )
		{
			int v2 = path.get(i);
			int v1 = path.get(i-1);
			
			EdgeDrawing e = new EdgeDrawing(vertices.get(v1), vertices.get(v2));
			//set color of shortest path to green
			e.setColor(Color.green);
			e.draw(g);
		}
	
	}
}
