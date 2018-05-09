package UndirectedGraphs;

import java.util.ArrayList;
import java.util.List;

public class BFS {
	//To keep track of the nodes we check so we know if it connects to the source.
	//If a node was checked, then there is a path to the node from a source
	private boolean[] checked;
	//To keep track of the parents that each child is connected to 
	private int[] connectedTo;
	//Where we start our search from in the graph 
	private final int SOURCE;  

	public 	BFS(Graph g, int rootVertex)
	{
		//Initialize arrays with the size of the graph
		checked = new boolean[g.citiesInGraph()];
		connectedTo = new int[g.citiesInGraph()];

		SOURCE = rootVertex;

		BFS(g, rootVertex);
	}

	//Go over the graph selecting the best parent-child connections
	private void BFS(Graph g, int source)
	{
		Queue parentsQueue = new Queue();     //Create a queue
		//We check the source passed in as a parameter and mark it as checked
		checked[source] = true;         
		parentsQueue.enqueue(source); //We add our parent to the queue

		while(!parentsQueue.isEmpty())
		{
			// We hold the parentVertex or source in this variable 
			int parentVertex =  parentsQueue.dequeue();   

			//For every child connected to the parent           
			for(Object child : g.getCitiesConnectedTo(parentVertex))  
			{
				if(!checked[(Integer) child])
				{
					// child is connected to the parent vertex
					connectedTo[(Integer) child] = parentVertex;
					//So we don't check this node again
					checked[(Integer) child] = true;
					//We add the next parent to the queue   
					parentsQueue.enqueue((Integer) child);
				}
			}
		}
	}

	//This method just allows us to check if a vertex is connected to the source.
	//If a vertex has been checked then it is connected
	public boolean hasPathTo(int vertex)
	{
		return checked[vertex];
	}

	//This method returns the path from the SOURCE to a given vertex
	public List pathTo(int vertex)
	{
		if (!hasPathTo(vertex)) 
			return null;

		List path = new ArrayList();

		//First add the vertex passed in to the method
		path.add(vertex);

		//Since we are iterating through a queue, 
		//we check form vertex(goal) to source       
		while (connectedTo[vertex] != SOURCE)                                     
		{
			vertex = connectedTo[vertex];
			path.add(vertex);
		}
		path.add(SOURCE); //Now we add the source at the very end

		return path;    //We return a path from the vertex to the source
	}
}
