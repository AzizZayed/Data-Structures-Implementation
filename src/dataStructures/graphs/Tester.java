package dataStructures.graphs;

public class Tester {

	public static void main(String[] args) {
		testGraphMatrix();
		testTries();
	}

	public static void testGraphMatrix() {
		System.out.println("//// GRAPH TESTING \\\\");
		GraphMatrix graph = new GraphMatrix();

		String[] fam = new String[] { "Aziz", "Ahmed", "Tarek", "Salsabil", "Sondos", "Saja", "Hanan" };

		for (String string : fam) {
			graph.addVertex(string);
			System.out.println(graph);
		}

		int max = 50;
		for (int i = 0; i < max; i++) {
			String a = fam[(int) (Math.random() * fam.length)];
			String b = fam[(int) (Math.random() * fam.length)];
			System.out.println("Adding " + a + " --> " + b);
			System.out.println(a + " --> " + b + ": " + graph.hasEdge(a, b)); // should always be true
			graph.addEdge(a, b);
		}
		System.out.println(graph);

		for (int i = 0; i < max; i++) {
			String a = fam[(int) (Math.random() * fam.length)];
			String b = fam[(int) (Math.random() * fam.length)];
			System.out.println(a + " --> " + b + ": " + graph.hasEdge(a, b));
		}
	}

	public static void testTries() {
		System.out.println("//// TRIE TESTING \\\\");
		
		Tries trie = new Tries();
	}
}
