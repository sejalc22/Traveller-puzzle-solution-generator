
/*
Title:
Puzzle solution generator using graph data structure

Puzzle : 
In this scenario we have two warring kingdoms, the yellow and the blue kingdom. Both kingdoms have their capitals and
are surrounded by a network of towns. Some are loyal to the yellow kingdom and some are loyal to the blue kingdom. Relations between 
neighboring towns are often strained if their allegiances are at odds. Thankfully, political power of the castles ensures that cities
belonging to the same castle are never in war. If two neighboring towns belonging to opposite kingdoms are quarreling at a given time 
then the road connecting the two towns is blocked.
A messenger needs to travel from the capital of blue kingdom to the capital of yellow kingdom carrying an offering of peace 
as quickly as possible. He has the map of the region but to find the quickest route he needs to know which of the roads 
is blocked and plan his route accordingly. The player will act as informant with news of the local quarrels between towns and 
let the messenger know which of the roads are blocked currently. 
The shortest safe path (if such exists) will be accordingly calculated and displayed.


Name: Sejal Chaudhari
 
Team members:
2323_SEJAL CHAUDHARI
2309_ISHANI ATRE
2307_ANSHIKA UPADHYAY
2310_SHIVANI BHANGADE 
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GraphPuzzle {

	public static void main(String[] args) throws IOException {
		
		//create new jframes
	
		JFrame f0 = new JFrame("WELCOME");
        JFrame f1 = new JFrame("THE MAP");
        JFrame f2 = new JFrame("THE PATH");
        
        //create object of map drawing class
        MapDrawing map = new MapDrawing();
        
        //create object of listener class
        Listener listen = new Listener();
        
        //new jpanel
        JPanel panel = new JPanel();
        
       // read image to place in jpanel
      BufferedImage image = ImageIO.read(new File("C:\\\\Eclipse\\\\Sem2\\\\DSA2\\\\MiniProject2\\\\bin\\\\MiniProject\\\\image8.jpg"));
       JLabel label = new JLabel(new ImageIcon(image));
      panel.add(label);
        
        //create linked lists to hold vertex drawings and edge drawings and buttons
        LinkedList<VertexDrawing> vertices = new LinkedList<VertexDrawing>();
    	LinkedList<EdgeDrawing> edges = new LinkedList<EdgeDrawing>();
    	LinkedList<EdgeDrawing> modEdges = new LinkedList<EdgeDrawing>();
    	LinkedList<JButton> buttons = new LinkedList<JButton>();
		    	
    	//add vertex drawings to list and pass co ordinates as parameters
    	vertices.add( new VertexDrawing(100, 900, 40, Color.blue, 0) ); 
		vertices.add( new VertexDrawing(200,800, 20, Color.blue, 1) ); 
		vertices.add( new VertexDrawing(200,650, 20, Color.blue, 2) ); 
		vertices.add( new VertexDrawing(200,400, 20, Color.yellow, 3) ); 
		vertices.add( new VertexDrawing(250,500, 20, Color.blue, 4) ); 
		vertices.add( new VertexDrawing(250,300, 20, Color.blue, 5) ); 
		vertices.add( new VertexDrawing(300,900, 20, Color.yellow, 6) ); 
		vertices.add( new VertexDrawing(300,700, 20, Color.yellow, 7) ); 
		vertices.add( new VertexDrawing(350,600, 20, Color.yellow, 8) ); 
		vertices.add( new VertexDrawing(350,400, 20, Color.yellow, 9) ); 
		vertices.add( new VertexDrawing(350,200, 20, Color.yellow, 10) ); 
		vertices.add( new VertexDrawing(400,850, 20, Color.yellow, 11) ); 
		vertices.add( new VertexDrawing(450,700, 20, Color.blue, 12) ); 
		vertices.add( new VertexDrawing(450,300, 20, Color.blue, 13) ); 
		vertices.add( new VertexDrawing(500,900, 20, Color.blue, 14) ); 
		vertices.add( new VertexDrawing(500,400, 20, Color.yellow, 15) ); 
		vertices.add( new VertexDrawing(600,800, 20, Color.yellow, 16) ); 
		vertices.add( new VertexDrawing(600,600, 20, Color.blue, 17) ); 
		vertices.add( new VertexDrawing(650,500, 20, Color.yellow, 18) ); 
		vertices.add( new VertexDrawing(650,300, 20, Color.blue, 19) ); 
		vertices.add( new VertexDrawing(700,800, 20, Color.blue, 20) ); 
		vertices.add( new VertexDrawing(700,150, 20, Color.blue, 21) ); 
		vertices.add( new VertexDrawing(750,650, 20, Color.yellow, 22) ); 
		vertices.add( new VertexDrawing(750,400, 20, Color.yellow, 23) ); 
		vertices.add( new VertexDrawing(800,900, 20, Color.blue, 24) ); 
		vertices.add( new VertexDrawing(800,200, 20, Color.yellow, 25) ); 
		vertices.add( new VertexDrawing(850,750, 20, Color.yellow, 26) ); 
		vertices.add( new VertexDrawing(850,500, 20, Color.blue, 27) ); 
		vertices.add( new VertexDrawing(850,300, 20, Color.yellow, 28) ); 
		vertices.add( new VertexDrawing(900,600, 20, Color.yellow, 29) ); 
		vertices.add( new VertexDrawing(950,800, 20, Color.blue, 30) ); 
		vertices.add( new VertexDrawing(950,400, 20, Color.blue, 31) ); 
		vertices.add( new VertexDrawing(950,200, 20, Color.blue, 32) ); 
		vertices.add( new VertexDrawing(1000,500, 20, Color.blue, 33) ); 
		vertices.add( new VertexDrawing(1050,850, 20, Color.yellow, 34) ); 
		vertices.add( new VertexDrawing(1050,600, 20, Color.yellow, 35) ); 
		vertices.add( new VertexDrawing(1100,400, 20, Color.yellow, 36) ); 
		vertices.add( new VertexDrawing(1100,150, 20, Color.blue, 37) ); 
		vertices.add( new VertexDrawing(1150,800, 20, Color.blue, 38) ); 
		vertices.add( new VertexDrawing(1150,500, 20, Color.yellow, 39) ); 
		vertices.add( new VertexDrawing(1150,300, 20, Color.yellow, 40) ); 
		vertices.add( new VertexDrawing(1200,650, 20, Color.blue, 41) ); 
		vertices.add( new VertexDrawing(1250,400, 20, Color.blue, 42) ); 
		vertices.add( new VertexDrawing(1250,200, 20, Color.yellow, 43) ); 
		vertices.add( new VertexDrawing(1300,100, 40, Color.yellow, 44) );
		
		
		//add edge drawings to edges list
		edges.add( new EdgeDrawing(vertices.get(0), vertices.get(1)));
		edges.add( new EdgeDrawing(vertices.get(0), vertices.get(6)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(1), vertices.get(2)));
		edges.add( new EdgeDrawing(vertices.get(1), vertices.get(6)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(2), vertices.get(7)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(2), vertices.get(8)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(3), vertices.get(5)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(4), vertices.get(5)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(4), vertices.get(8)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(5), vertices.get(9)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(5), vertices.get(10)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(5), vertices.get(13)));
		edges.add( new EdgeDrawing(vertices.get(6), vertices.get(7)));
		edges.add( new EdgeDrawing(vertices.get(6), vertices.get(11)));
		edges.add( new EdgeDrawing(vertices.get(7), vertices.get(8)));
		edges.add( new EdgeDrawing(vertices.get(7), vertices.get(12)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(8), vertices.get(15)));
		edges.add( new EdgeDrawing(vertices.get(11), vertices.get(14)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(12), vertices.get(15)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(12), vertices.get(16)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(12), vertices.get(17)));
		edges.add( new EdgeDrawing(vertices.get(13), vertices.get(15)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(14), vertices.get(16)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(15), vertices.get(18)));
		edges.add( new EdgeDrawing(vertices.get(15), vertices.get(19)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(16), vertices.get(20)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(16), vertices.get(22)));
		edges.add( new EdgeDrawing(vertices.get(17), vertices.get(18)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(17), vertices.get(29)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(18), vertices.get(19)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(18), vertices.get(27)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(19), vertices.get(21)));;
		edges.add( new EdgeDrawing(vertices.get(19), vertices.get(23)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(20), vertices.get(24)));
		edges.add( new EdgeDrawing(vertices.get(22), vertices.get(26)));
		edges.add( new EdgeDrawing(vertices.get(22), vertices.get(27)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(23), vertices.get(28)));
		edges.add( new EdgeDrawing(vertices.get(24), vertices.get(26)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(24), vertices.get(30)));
		edges.add( new EdgeDrawing(vertices.get(25), vertices.get(28)));
		edges.add( new EdgeDrawing(vertices.get(25), vertices.get(32)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(26), vertices.get(29)));
		edges.add( new EdgeDrawing(vertices.get(27), vertices.get(28)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(27), vertices.get(31)));
		edges.add( new EdgeDrawing(vertices.get(28), vertices.get(32)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(29), vertices.get(35)));
		edges.add( new EdgeDrawing(vertices.get(30), vertices.get(34)));
		edges.add( new EdgeDrawing(vertices.get(30), vertices.get(35)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(31), vertices.get(33)));
		edges.add( new EdgeDrawing(vertices.get(31), vertices.get(40)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(32), vertices.get(37)));
		edges.add( new EdgeDrawing(vertices.get(32), vertices.get(40)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(33), vertices.get(35)));
		edges.add( new EdgeDrawing(vertices.get(33), vertices.get(36)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(34), vertices.get(35)));
		edges.add( new EdgeDrawing(vertices.get(34), vertices.get(38)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(36), vertices.get(39)));
		edges.add( new EdgeDrawing(vertices.get(37), vertices.get(40)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(37), vertices.get(44)));
		modEdges.add(edges.getLast());		
		edges.add( new EdgeDrawing(vertices.get(38), vertices.get(41)));
		edges.add( new EdgeDrawing(vertices.get(39), vertices.get(42)));
		modEdges.add(edges.getLast());
		edges.add( new EdgeDrawing(vertices.get(40), vertices.get(42)));
		edges.add( new EdgeDrawing(vertices.get(40), vertices.get(43)));
		edges.add( new EdgeDrawing(vertices.get(41), vertices.get(42)));
		edges.add( new EdgeDrawing(vertices.get(43), vertices.get(44)));
		
		
		//add buttons to buttons list
		for(int m = 0 ; m<modEdges.size() ; m++)
		{
			JButton b = new JButton();
			modEdges.get(m).setColor(Color.gray);
			//set size of buttons
			b.setBounds(modEdges.get(m).bx, modEdges.get(m).by, 20, 20);
			b.setBackground(Color.red);
			//add actionlistener to buttons
			b.addActionListener(listen);
			buttons.add(b);
		}
		
		//create new graph object 
		Graph graph=new Graph(edges.size(),vertices.size());
		
		//add edges to graph based on edge graphics
		for(int i=0;i<edges.size();i++) {
			graph.addEdge( edges.get(i).v1, edges.get(i).v2 );
		}
    
		//add lists to map object
		map.addLists(vertices, edges, buttons, modEdges);
		listen.add(map, f1, f2, graph);
	
		//add listener to final frame displaying shortest path
		f2.addWindowListener(listen);
		f2.setLayout(null);
        f2.setSize(1500, 1000);
        f2.setResizable(false);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //add listener to interactive map frame
		f1.addWindowListener(listen);
        f1.setLayout(null);
        f1.setSize(1500, 1000);
        f1.add(map);
        f1.setLocationRelativeTo(map);
        f1.setResizable(false);
        f1.setVisible(true);
        
        //add opening frame
        f0.setSize(1500, 1000);
        f0.add(panel);
        f0.setLocationRelativeTo(panel);
        f0.setResizable(false);
        f0.setVisible(true);

	}

}
