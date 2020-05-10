package testers;

import dataStructures.graphs.GraphMatrix;

public class GraphTesting {

	public static void main(String[] args) {
		testGraphMatrix();
	}

	public static void testGraphMatrix() {
		System.out.println("//// GRAPH TESTING \\\\");
		GraphMatrix graph = new GraphMatrix();

		String[] fam = new String[] { "Aziz", "Ahmed", "Tarek", "Salsabil", "Sondos", "Saja", "Hanan" };

		System.out.println("Test adding vertices");
		for (String string : fam) {
			graph.addVertex(string);
		}
		System.out.println(graph);

		System.out.println("Test adding edges");
		int max = 50;
		for (int i = 0; i < max; i++) {
			String a = fam[(int) (Math.random() * fam.length)];
			String b = fam[(int) (Math.random() * fam.length)];
			System.out.println("Adding " + a + " --> " + b);
			graph.addEdge(a, b);
			System.out.println(a + " --> " + b + ": " + graph.hasEdge(a, b)); // should always be true
		}
		System.out.println(graph);

		System.out.println("Test random edges, see if they exist");
		for (int i = 0; i < max; i++) {
			String a = fam[(int) (Math.random() * fam.length)];
			String b = fam[(int) (Math.random() * fam.length)];
			System.out.println(a + " --> " + b + ": " + graph.hasEdge(a, b));
		}
	}
}
