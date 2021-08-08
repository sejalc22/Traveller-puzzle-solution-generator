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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


//class to hold graphic of an edge of graph image
public class EdgeDrawing 
{
   int x1, x2, y1, y2;  //co-ordinates of start and end vertices of edge
   int v1, v2;          //vertex numbers of start and end vertices
   int bx, by;          //positions co-ordinates for button
  
   Color color;         //color of edge
   
   //constructor
   EdgeDrawing(VertexDrawing v1, VertexDrawing v2)       //input vertexdrawing objects
   {
	   //calculate co ordinates based on vertex co ordinates and vertex diameter in pixels
	   x1 = v1.x + (v1.diameter)/2;
	   y1 = v1.y + (v1.diameter)/2;
	   
	   x2 = v2.x + (v2.diameter)/2;
	   y2 = v2.y + (v2.diameter)/2;
	   
	   this.v1 = v1.num;
	   this.v2 = v2.num;
	   
	   //calculate button co ordinates in pixels
	   bx = ((x1 + x2)/2) - 10 ;
	   by = ((y1 + y2)/2) - 10 ;
	   color = Color.blue;
   }
   
   //function to set color of edge
   public void setColor(Color c)
   {
	color = c;
   }
  
   //function to draw edge on panel
   public void draw(Graphics e)
   {
	   Graphics2D g = (Graphics2D) e;
	   g.setColor(color);
	   g.setStroke(new BasicStroke(5));
       g.drawLine(x1,y1,x2,y2); 
   }
}