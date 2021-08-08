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


//class to hold graphic of vertex drawing on panel
public class VertexDrawing{
	
	   int x, y, diameter, num;   // x and y coordinates of vertex on panel
	                              //diameter of vertex in pixels and vertex number
	   Color color;               //color of vertex
	   
	   //constructor
	   public VertexDrawing(int x, int y, int d, Color color, int num)
	   {
		super();
		this.x = x;
		this.y = y;
		this.diameter = d;
		this.color = color;
		this.num = num;
	   }
	   
	   //function to set color of vertex
	   public void setColor(Color color)
	   {
		   this.color = color;
	   }
	   
	   //function to draw vertex on panel
	   public void draw(Graphics g)
	    {
	      g.setColor(color);
	      g.fillOval( x, y, diameter, diameter);  //width and height of a diameter
	    }
	   
	}

