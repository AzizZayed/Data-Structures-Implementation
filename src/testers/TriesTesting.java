package testers;

import java.util.Arrays;

import dataStructures.tries.Tries;

public class TriesTesting {

	public static void main(String[] args) {
		testTries();
	}

	public static void testTries() {
		System.out.println("\n//// TRIE TESTING \\\\");

		Tries trie = new Tries();
		String[] fam = new String[] { "Aziz", "Azizo", "Ahmed", "Ahmedi", "Tarek", "Tareko", "Salsabil", "Salsabila",
				"Sondos", "Sondosin", "Saja", "Sajaja", "Hanan", "Hanano" };
		String[] otherfam = new String[] { "Abdel", "Zizou", "Mazen", "Raouf", "Moe", "Sarje", "Bob" };

		System.out.println("Test adding: ");
		for (String string : fam) {
			trie.addWord(string);
		}
		for (String string : fam) {
			trie.addWord(string);
		}
		System.out.println(trie);

		System.out.println("Test word searching: ");
		for (String string : fam) {
			System.out.println(string + " in trie: " + trie.isWord(string));
		}
		for (String string : otherfam) {
			System.out.println(string + " in trie: " + trie.isWord(string));
		}
		System.out.println();
		System.out.println("Test prefix searching: ");
		for (String string : fam) {
			System.out.println(string.substring(0, string.length() - 1) + " in trie: " + trie.isPrefix(string));
		}
		for (String string : otherfam) {
			System.out.println(string.substring(0, string.length() - 2) + " in trie: " + trie.isPrefix(string));
		}
		System.out.println();
		System.out.println("Test all words with prefix: ");
		for (String string : fam) {
			String s = string.substring(0, (int) (Math.random() * string.length()));
			System.out.println("All entities with prefix " + s + ": " + Arrays.toString(trie.getWordsFromPrefix(s)));
		}
		for (String string : otherfam) {
			String s = string.substring(0, (int) (Math.random() * string.length()));
			System.out.println("All entities with prefix " + s + ": " + Arrays.toString(trie.getWordsFromPrefix(s)));
		}
	}
}
