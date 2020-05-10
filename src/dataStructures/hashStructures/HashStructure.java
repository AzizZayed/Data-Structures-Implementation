package dataStructures.hashStructures;

import java.util.ArrayList;

/**
 * abstract class, subclassing all the data structures that use hashing, so
 * HashSets and HashTables
 * 
 * @author Zayed
 *
 */
public abstract class HashStructure {

	/**
	 * the length of the array data structures. This is a fixed length.
	 */
	protected final int CAPACITY = 45;
	protected ArrayList<String> keys; // a list of the keys

	/**
	 * default constructor
	 */
	public HashStructure() {
		keys = new ArrayList<String>(CAPACITY);
		initialize();
	}

	/**
	 * the hash function
	 * 
	 * @param input - the input to hash
	 * @return the hash code of the input
	 */
	private int hash(String input) { // O(1) or O(i) where i is the length of the input string
		int code = 0;
		for (int i = 0; i < input.length(); i++)
			code += input.charAt(i);
		return code;
	}

	/**
	 * transforms the Hash code of the input into an index
	 * 
	 * @param input - the input to hash and then get an index
	 * @return the index the element should go in
	 */
	protected int hashToIndex(String input) {
		return hash(input) % CAPACITY;
	}

	/**
	 * @return the number of keys
	 */
	public int getKeyCount() {
		return keys.size();
	}

	/**
	 * @return true if the structure is empty
	 */
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	/**
	 * clear the data structure
	 */
	public void clear() {
		keys.clear();
		initialize();
	}

	/**
	 * @return an array with the keys
	 */
	public String[] getKeys() {
		String[] keysArray = new String[0];
		keysArray = keys.toArray(keysArray);
		return keysArray;
	}

	/**
	 * @return a string representation of the keys
	 */
	public String keysToString() {
		return keys.toString();
	}

	/**
	 * initialize the structure
	 */
	protected abstract void initialize();

	/**
	 * checks if the list contains the given key
	 * 
	 * @param key - the key to test
	 * @return true if the list contains the key
	 */
	public abstract boolean contains(String key);

	/**
	 * remove the given key
	 * 
	 * @param key - key to remove
	 */
	public abstract void remove(String key);
}