
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.LinkedList;

//Graph stored in adjacency list representation
public class Graph {
	
	//arraylist of arraylists to hold adjacency lists
	ArrayList<ArrayList<Integer>> adjList;
	//Linked list to hold vertices forming part of shortest path in order 
	LinkedList<Integer> path;
	int e ;           //number of edges in graph
	int v ;           //number of vertices
	
	//constructor
	Graph(int e, int v)
	{
		this.e = e;
		this.v = v;
		adjList = new ArrayList<ArrayList<Integer>>();  //create lists
		path = new LinkedList<Integer>();
		
		for(int i = 0; i<v ; i++) 
			adjList.add(new ArrayList<Integer>());
	}
	
	//function to add edge between vertices
	void addEdge(int v1, int v2)
	{
		//add vertex numbers to adjacency lists of both vertices
		(adjList.get(v1)).add(v2); 
		(adjList.get(v2)).add(v1);
	}
	
	//function to remove edge from graph
	void remEdge(int v1, int v2)
	{
		ArrayList<Integer> a = adjList.get(v1);
		int i = 0;
		//delete v2 from adjacency list of v1
		while((!a.isEmpty())&&(i<a.size()))
		{
			if(a.get(i) == v2)
			{
				a.remove(i);
				break;
			}
			i++;
		}
		a = adjList.get(v2);
		i = 0;
		//delete v1 from adjacency list of v2
		while((!a.isEmpty())&&(i<a.size()))
		{
			if(a.get(i) == v1)
			{
				a.remove(i);
				break;
			}
			i++;
		}
	}

	//method to find shortest path between two vertices
	public void printShortestDistance( int v1, int v2 )
   {
	        // predecessor[i] array stores predecessor of i and distance array stores distance i from s
	        int pred[] = new int[v];
	        int dist[] = new int[v];

	        if (BFS(v1, v2, pred, dist) == false) 
	        {
	        	JOptionPane.showMessageDialog(null,"Shoot! ","No such safe path available  D: ", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	       // LinkedList to store path
	          int crawl = v2;
	          path.add(crawl);
	          
	          while (pred[crawl] != -1)
	          {
	            path.add(pred[crawl]);
	            crawl = pred[crawl];
	          }
	 
	}

	// a modified version of BFS that stores predecessor of each vertex in array pred and its distance from source in array dist
	public boolean BFS( int v1, int v2, int pred[], int dist[])
	{
	    // a queue to maintain queue of vertices whose adjacency list is to be scanned 
	     LinkedList<Integer> queue = new LinkedList<Integer>();
	 
	      // boolean array visited[] 
	       boolean visited[] = new boolean[v];
	 
	   //initialize visited array to false and distance array to -1
	        for (int i = 0; i < v; i++) {
	            visited[i] = false;
	            dist[i] = Integer.MAX_VALUE;
	            pred[i] = -1;
	        }
	 
	   //set visited of source vertex to true and distance to 0
	        visited[v1] = true;
	        dist[v1] = 0;
	        queue.add(v1);
	 
	    //perform BFS Algorithm
	        while (!queue.isEmpty())
	        {
	           int u = queue.remove();
	           for (int i = 0; i < adjList.get(u).size(); i++)
	           {
	               if (visited[adjList.get(u).get(i)] == false) 
	               {
	                   visited[adjList.get(u).get(i)] = true;
	                   dist[adjList.get(u).get(i)] = dist[u] + 1;
	                   pred[adjList.get(u).get(i)] = u;
	                   queue.add(adjList.get(u).get(i));
	 
	                  //return if destination reached
	                   if (adjList.get(u).get(i) == v2)
	                       return true;
	                }
	            }
	        }
	        return false;
	    }
	}


