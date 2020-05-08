package dataStructures.graphs;

import java.util.Arrays;

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
		System.out.println("\n//// TRIE TESTING \\\\");

		Tries trie = new Tries();
		String[] fam = new String[] { "Aziz", "Ahmed", "Tarek", "Salsabil", "Sondos", "Saja", "Hanan" };
		String[] otherfam = new String[] { "Abdel", "Zizou", "Mazen", "Raouf", "Moe", "Sarje", "Bob" };

		for (String string : fam) {
			trie.addWord(string);
		}

		System.out.println(trie);

		for (String string : fam) {
			System.out.println(string + " in trie: " + trie.isWord(string));
		}
		for (String string : otherfam) {
			System.out.println(string + " in trie: " + trie.isWord(string));
		}
		System.out.println();
		for (String string : fam) {
			System.out.println(string.substring(0, string.length() - 1) + " in trie: " + trie.isPrefix(string));
		}
		for (String string : otherfam) {
			System.out.println(string.substring(0, string.length() - 2) + " in trie: " + trie.isPrefix(string));
		}
		System.out.println();
		for (String string : fam) {
			String s = string.substring(0, 3);
			System.out.println("All entities with prefix " + s + ": " + Arrays.toString(trie.getWordsFromPrefix(s)));
		}
		for (String string : otherfam) {
			String s = string.substring(0, 2);
			System.out.println("All entities with prefix " + s + ": " + Arrays.toString(trie.getWordsFromPrefix(s)));
		}
	}
}
