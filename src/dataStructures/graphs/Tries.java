package dataStructures.graphs;

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
		public HashMap<Character, Node> nextLetters = new HashMap<Character, Node>(); // children
		public boolean isWord = false; // if it's the node ending a word
	}

	private Node root = new Node(); // the root of the tree

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		loadAsString(root, sb, "");
		return sb.toString();
	}

	/**
	 * load every word into the string builder object
	 * 
	 * @param current - current node the recursion is at
	 * @param full    - string builder object where we will load all the words
	 * @param stack   - building prefix for every group of words with same prefix
	 */
	private void loadAsString(Node current, StringBuilder full, String stack) {
		if (current.isWord) {
			full.append(stack);
			full.append("\n");
			return;
		}
		current.nextLetters.forEach((k, v) -> loadAsString(v, full, stack + k));
	}

	/**
	 * add a new word to the trie
	 * 
	 * @param newWord - the new word we want to add
	 */
	public void addWord(String newWord) {
		addWord(root, newWord);
	}

	/**
	 * recursive algorithm that adds new word to data structure
	 * 
	 * @param current - current node the recursion is at
	 * @param word    - the substring of the initial word to add under current node
	 */
	private void addWord(Node current, String word) {
		if (word.length() == 0) {
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
	 * delete a word from the trie
	 * 
	 * @param word - word to delete
	 */
	public void deleteWord(String word) {
		
	}

	/**
	 * check if the string is a word in the trie
	 * 
	 * @param word - the word to check
	 * @return true if the word is in the trie
	 */
	public boolean isWord(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			current = current.nextLetters.get(word.charAt(i));
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
	public boolean isPrefix(String prefix) {
		Node current = root;
		for (int i = 0; i < prefix.length(); i++) {
			current = current.nextLetters.get(prefix.charAt(i));
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
	public String[] getWordsFromPrefix(String prefix) {
		Node current = root;
		for (int i = 0; i < prefix.length(); i++) {
			current = current.nextLetters.get(prefix.charAt(i));
			if (current == null) // means prefix does not exist
				return new String[0];
		}
		ArrayList<String> words = new ArrayList<String>();
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
		if (current.isWord) {
			words.add(prefix + stack);
			return;
		}
		current.nextLetters.forEach((k, v) -> loadWords(v, prefix, words, stack + k));
	}
}
