package dataStructures.graphs;

/**
 * A graph data structure implemented as a matrix of connections. The dimensions
 * of the graph is fixed for simplicity
 * 
 * @author Zayed
 *
 */
public class GraphMatrix extends Graph {

	private final int CAPACITY = 15; // size of the graph / max number of vertices
	private String[] vertices = new String[CAPACITY]; // the vertices
	private boolean[][] connections = new boolean[CAPACITY][CAPACITY]; // the connections matrix
	private int size = 0; // the actual number of verticesF

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Vertices: [ ");
		for (int i = 0; i < size; i++) {
			sb.append(vertices[i]);
			sb.append(" ");
		}
		sb.append("]\n");

		sb.append("Connections: [\n");
		for (int i = 0; i < size; i++) {
			sb.append("\t");
			sb.append(vertices[i]);
			sb.append(" --> ");
			for (int j = 0; j < size; j++)
				if (connections[i][j]) {
					sb.append(vertices[j]);
					sb.append(" ");
				}
			sb.append("\n");
		}
		sb.append("]\n");

		return sb.toString();
	}

	@Override
	public void addVertex(String str) {
		if (size == CAPACITY)
			return;

		vertices[size] = str;
		size++;
	}

	/**
	 * add an edge
	 * 
	 * @param a  - vertex to add an edge
	 * @param b  - vertex to add an edge
	 * @param bi - if we add edges in both direction
	 */
	private void addEdge(String a, String b, boolean bi) {
		int aIndex = indexOf(a);
		int bIndex = indexOf(b);

		if (aIndex == bIndex)
			return;

		if (aIndex < 0 || bIndex < 0)
			throw new IllegalArgumentException("Element does not exist in the graph");

		connections[aIndex][bIndex] = true;
		if (bi)
			connections[bIndex][aIndex] = true;
	}

	@Override
	public void addEdge(String a, String b) {
		addEdge(a, b, false);
	}

	@Override
	public void addBothEdges(String a, String b) {
		addEdge(a, b, true);
	}

	/**
	 * get the index of a vertex
	 * 
	 * @param s - the vertex data
	 * @return the index of the vertex, -1 if it does not exist
	 */
	private int indexOf(String s) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(s))
				return i;
		return -1;
	}

	@Override
	public int getVertexCount() {
		return size;
	}

	@Override
	public boolean contains(String key) {
		return indexOf(key) >= 0;
	}

	@Override
	public boolean hasEdge(String a, String b) {
		int aIndex = indexOf(a);
		int bIndex = indexOf(b);

		if (aIndex == bIndex)
			return false;

		if (aIndex < 0 || bIndex < 0)
			throw new IllegalArgumentException("Element does not exist in the graph");

		return connections[aIndex][bIndex];
	}
}