package dataStructures.graphs;

/**
 * a graph structure with a bunch of nodes connected to eachother
 * 
 * @author Zayed
 *
 */
public abstract class Graph {

	/**
	 * add a vertex to the graph
	 * 
	 * @param str - vertex data to add
	 */
	public abstract void addVertex(String str);

	/**
	 * add an edge between 2 vertices
	 * 
	 * @param a - vertex to add an edge
	 * @param b - vertex to add an edge
	 */
	public abstract void addEdge(String a, String b);

	/**
	 * @return the number of vertices in the graph
	 */
	public abstract int getVertexCount();

	/**
	 * check if the graph has a vertex
	 * 
	 * @param key - data of the vertex to look for
	 * @return true if the graph contains the vertex
	 */
	public abstract boolean contains(String key);

	/**
	 * checks if there is an edge linking the 2 specified vertices
	 * 
	 * @param a - data of the first vertex
	 * @param b - data of the second vertex
	 * @return true if there is an edge
	 */
	public abstract boolean hasEdge(String a, String b);
}
