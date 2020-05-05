package dataStructures.graphs;

import java.util.Map;

public class Tries {

	private class Node {
		char letter;
		Map<Character, Node> nextLetters;
		boolean isWord;

		public Node(char c, boolean word) {
			letter = c;
			isWord = word;
		}
	}

	private Node first;

}
