package dataStructures.linkedLists;

public abstract class LinkedList {

	/**
	 * The node class: the elements of the list
	 * 
	 * @author Zayed
	 *
	 */
	protected class Node {
		public int value;

		/**
		 * constructor
		 * 
		 * @param value - value of the node
		 */
		public Node(int value) {
			this.value = value;
		}
	}
	
	protected int size = 0; // size of the list

	/**
	 * get the size of the list
	 * 
	 * @return the size of the list
	 */
	public int getSize() { // O(1)
		return size;
	}

	/**
	 * test if the list is empty
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty() { // O(1)
		return (size == 0);
	}

	/**
	 * add value to the end of the list
	 * 
	 * @param value - value to add
	 */
	public abstract void append(int value);
	
	/**
	 * add value to the start of the list
	 * 
	 * @param value - value to add
	 */
	public abstract void prepend(int value);
	
	/**
	 * check if the list contains a value
	 * 
	 * @param value - value to add
	 * @return true if the list contains the value, false otherwise
	 */
	public abstract boolean contains(int value);
	
	/**
	 * get the value at the specified index
	 * 
	 * @param index - the index at which you want to retrieve an element
	 * @return the value at the specified index
	 */
	public abstract int get(int index);
	
	/**
	 * pop the head off the list, a NullPointerException is thrown if the head is
	 * null
	 * 
	 * @return the value at the head of the list
	 */
	public abstract int popHead();
	
	/**
	 * remove the last element in the list
	 */
	public abstract void removeLast();
	
	/**
	 * insert a value at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param value   - value to add
	 * @param index - the index at which we wish to add an element
	 */
	public abstract void insert(int value, int index);
	
	/**
	 * remove the value at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param index - the index at which we wish to remove the element
	 */
	public abstract void removeIndex(int index);
	
	/**
	 * peek to see the head/first element from the list, a NullPointerException is
	 * thrown if the head is null
	 * 
	 * @return the head/first element from the list
	 */
	public abstract int peekFirst();
	
	/**
	 * peek to see the last element from the list, a NullPointerException is thrown
	 * if the head is null
	 * 
	 * @return the last element from the list
	 */
	public abstract int peekLast();
	
	/**
	 * clear the linked list
	 */
	public abstract void clear();
	
	/**
	 * transform the linked list into an array
	 * 
	 * @return the array containing the elements of the list
	 */
	public abstract int[] toArray();
	
	/**
	 * reverse this linked list
	 */
	public abstract void internalReverse();
	
	/**
	 * sort the array using merge sort
	 */
	public abstract void sort();
}
