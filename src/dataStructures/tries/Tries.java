package dataStructures.tries;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representation of tries data structure used in text autocomplete. It's a tree
 * data structure that holds characters
 * 
 * @author Zayed
 *
 */
public class Tries {

	/**
	 * Node class containing the children trees
	 * 
	 * @author Zayed
	 *
	 */
	private class Node {
		public HashMap<Character, Node> nextLetters = new HashMap<>(); // children
		public boolean isWord = false; // if it's the node ending a word
	}

	private Node root = new Node(); // the root of the tree
	private int nWords = 0;

	@Override
	public String toString() { // O(n), where n is the number of nodes
		StringBuilder sb = new StringBuilder("Words inside trie: {\n");
		sb.ensureCapacity((nWords + 1) * 8); // capacity estimate
		loadAsString(root, sb, "");
		sb.append("} Size: ");
		sb.append(nWords);
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * load every word into the string builder object
	 * 
	 * @param current - current node the recursion is at
	 * @param full    - string builder object where we will load all the words
	 * @param stack   - building prefix for every group of words with same prefix
	 */
	private void loadAsString(Node current, StringBuilder full, String stack) { // depth-first search
		if (current.isWord) {
			full.append("\t");
			full.append(stack);
			full.append("\n");
		}
		current.nextLetters.forEach((k, v) -> loadAsString(v, full, stack + k));
	}

	/**
	 * @return the number of words in the trie
	 */
	public int getSize() {
		return nWords;
	}

	/**
	 * add a new word to the trie
	 * 
	 * @param newWord - the new word we want to add
	 */
	public void addWord(String newWord) { // O(m), where m is the length of the string
		addWord(root, newWord);
	}

	/**
	 * recursive algorithm that adds new word to data structure
	 * 
	 * @param current - current node the recursion is at
	 * @param word    - the substring of the initial word to add under current node
	 */
	private void addWord(Node current, String word) {
		if (word.isEmpty()) {
			if (!current.isWord)
				nWords++;
			current.isWord = true;
			return;
		}
		char c = word.charAt(0);
		Node next = current.nextLetters.get(c);
		if (next == null) {
			next = new Node();
			current.nextLetters.put(c, next);
		}
		addWord(next, word.substring(1));
	}

	/**
	 * check if the string is a word in the trie
	 * 
	 * @param word - the word to check
	 * @return true if the word is in the trie
	 */
	public boolean isWord(String word) { // O(m) worst case
		Node current = root;
		char[] chars = word.toCharArray();
		for (char c : chars) {
			current = current.nextLetters.get(c);
			if (current == null) // means word does not exist
				return false;
		}
		return current.isWord;
	}

	/**
	 * check if the string is a prefix in the trie
	 * 
	 * @param prefix - the prefix to check
	 * @return true if the prefix is in the trie
	 */
	public boolean isPrefix(String prefix) { // O(m) worst case
		Node current = root;
		char[] chars = prefix.toCharArray();
		for (char c : chars) {
			current = current.nextLetters.get(c);
			if (current == null) // means prefix does not exist
				return false;
		}
		return true;
	}

	/**
	 * get all the words with the given prefix
	 * 
	 * @param prefix - the prefix
	 * @return a string array of all the words with the given prefix
	 */
	public String[] getWordsFromPrefix(String prefix) { // O(nm) worst case
		Node current = root;
		char[] chars = prefix.toCharArray();
		for (char c : chars) {
			current = current.nextLetters.get(c);
			if (current == null) // means prefix does not exist
				return new String[0];
		}
		ArrayList<String> words = new ArrayList<String>(nWords);
		loadWords(current, prefix, words, "");
		return words.toArray(new String[0]);
	}

	/**
	 * load every word with the prefix into the string list
	 * 
	 * @param current - current node the recursion is at
	 * @param prefix  - the prefix of the words we want to load into the list
	 * @param words   - the list we will load with words
	 * @param stack   - building prefix for every group of words with same prefix
	 */
	private void loadWords(Node current, String prefix, ArrayList<String> words, String stack) {
		if (current.isWord)
			words.add(prefix + stack);
		current.nextLetters.forEach((k, v) -> loadWords(v, prefix, words, stack + k));
	}
}
