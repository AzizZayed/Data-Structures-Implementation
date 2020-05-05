package dataStructures.hashStructures;

import java.util.LinkedList;

/**
 * a hash set class. THis class allows you to add, deleted and look up elements
 * in constant time
 * 
 * @author Zayed
 *
 */
public class HashSet extends HashStructure {

	LinkedList<String>[] set; // the set in memoryf

	@Override
	@SuppressWarnings("unchecked")
	protected void initialize() {
		set = new LinkedList[CAPACITY];
		for (int i = 0; i < set.length; i++)
			set[i] = new LinkedList<String>();
	}

	@Override
	public void remove(String key) {
		keys.remove(key);
		int index = hashToIndex(key);
		if (set[index] == null)
			set[index] = new LinkedList<String>();
		set[index].remove(key);
	}

	/**
	 * add an element to the set
	 * 
	 * @param key - what we want to add
	 */
	public void add(String key) {
		int index = hashToIndex(key);
		if (set[index] == null) {
			set[index] = new LinkedList<String>();
		}

		if (set[index].contains(key))
			return;

		set[index].add(key);
		keys.add(key);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Set: { ");
		for (int i = 0; i < set.length; i++) {
			LinkedList<String> list = set[i];
			if (!list.isEmpty()) {
				builder.append("\n" + i + ": { ");
				for (String element : list)
					builder.append(element + "  ");
				builder.append("}");
			}
		}
		builder.append("\n}");

		return builder.toString();
	}

	@Override
	public boolean contains(String key) {
		int index = hashToIndex(key);
		LinkedList<String> list = set[index];
		if (list == null)
			return false;
		return list.contains(key);
	}
}