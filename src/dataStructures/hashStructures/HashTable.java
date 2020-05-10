package dataStructures.hashStructures;

import java.util.LinkedList;

/**
 * A hash table data structure. This class allows you to look up, get, add and
 * delete element in constant time
 * 
 * @author Zayed
 *
 */
public class HashTable extends HashStructure {

	/**
	 * a key-value pair
	 * 
	 * @author Zayed
	 *
	 */
	private class Pair {
		public String key;
		public int value;

		public Pair(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	LinkedList<Pair>[] table; // the table of key-value pairs in memory

	@Override
	@SuppressWarnings("unchecked")
	protected void initialize() {
		table = new LinkedList[CAPACITY];
		for (int i = 0; i < table.length; i++)
			table[i] = new LinkedList<Pair>();
	}

	@Override
	/*
	 * O(1) for regular hashtables, O(c) for this one because the size is fixed (I
	 * did that for simplicity purposes, this class is for education and by no means
	 * is meant to be the most efficient), where c is the length of the linked list
	 * at the specified index
	 */
	public void remove(String key) {
		keys.remove(key);
		int index = hashToIndex(key);
		if (table[index] == null)
			table[index] = new LinkedList<Pair>();
		for (int i = 0; i < table[index].size(); i++)
			if (table[index].get(i).key.equals(key)) {
				table[index].remove(i);
				return;
			}
	}

	/**
	 * add a key, value pair to the table
	 * 
	 * @param key   - key to add
	 * @param value - value to add with the key
	 */
	public void add(String key, int value) { // O(1) or O(c) worst case
		int index = hashToIndex(key);
		if (table[index] == null)
			table[index] = new LinkedList<Pair>();
		for (int i = 0; i < table[index].size(); i++)
			if (table[index].get(i).key.equals(key))
				return;
		table[index].add(new Pair(key, value));
		keys.add(key);
	}

	/**
	 * set the value for a given key
	 * 
	 * @param key   - key to set the value of
	 * @param value - value to set
	 */
	public void set(String key, int value) { // O(1) or O(c) worst case
		int index = hashToIndex(key);
		if (table[index] == null)
			table[index] = new LinkedList<Pair>();
		for (int i = 0; i < table[index].size(); i++) {
			Pair pair = table[index].get(i);
			if (pair.key.equals(key))
				pair.value = value;
		}
	}

	/**
	 * get the value liked to the given key
	 * 
	 * @param key - the key to find it's value
	 * @return the value linked to the given key
	 */
	public int get(String key) { // O(1) or O(c) worst case
		int index = hashToIndex(key);
		if (table[index] == null)
			table[index] = new LinkedList<Pair>();
		for (int i = 0; i < table[index].size(); i++) {
			Pair pair = table[index].get(i);
			if (pair.key.equals(key))
				return pair.value;
		}
		throw new IllegalArgumentException("Item does not exist");
	}

	@Override
	public String toString() { // O(n) whre n is the length of the table, O(cn) worst case
		StringBuilder builder = new StringBuilder();

		builder.append("Table: { ");
		for (int i = 0; i < table.length; i++) {
			LinkedList<Pair> list = table[i];
			if (!list.isEmpty()) {
				builder.append("\n" + i + ": { ");
				for (Pair element : list)
					builder.append("{" + element.key + ", " + element.value + "}");
				builder.append(" }");
			}
		}
		builder.append("\n}");

		return builder.toString();
	}

	@Override
	public boolean contains(String key) { // O(1) or O(c) worst case
		int index = hashToIndex(key);
		if (table[index] == null)
			table[index] = new LinkedList<Pair>();
		for (int i = 0; i < table[index].size(); i++)
			if (table[index].get(i).key.equals(key))
				return true;
		return false;
	}
}
