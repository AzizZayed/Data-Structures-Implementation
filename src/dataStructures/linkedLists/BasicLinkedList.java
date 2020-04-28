package dataStructures.linkedLists;

import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

/**
 * This is a basic LinkedList class with all the necessary functions a
 * LinkedList class - or any data structure - would have. All the time and space
 * complexities are written beside the functions. Some optimizations can be done
 * to this class. For example, if it had a pointer to the last element of the
 * list, the append() and peekLast() functions would run in constant time
 * instead of linear time. The removeLast() method can also be optimized if we
 * had this pointer and also a pointer to the parent node. Most of these
 * performance issues are solved with a double linked list with a pointer to the
 * last Node.
 * 
 * @author Zayed
 *
 */
public class BasicLinkedList {

	/**
	 * The node class: the elements of the list
	 * 
	 * @author Zayed
	 *
	 */
	private class Node {
		public Node next;
		public int value;

		public Node(int value) {
			this.value = value;
			next = null;
		}

		/**
		 * print the node and the children
		 */
		public void print() {
			System.out.print(value + ", ");
			if (next != null)
				next.print();
		}

		/**
		 * Add the value to the end
		 * 
		 * @param val - value to add
		 */
		public void add(int val) {
			if (next == null) {
				next = new Node(val);
			} else {
				next.add(val);
			}
		}

		/**
		 * check if a value is present in the children
		 * 
		 * @param val - value to check
		 * @return true if the value is present, false otherwises
		 */
		public boolean check(int val) {
			if (value == val) {
				return true;
			} else if (next != null) {
				return next.check(val);
			}

			return false;
		}

		/**
		 * remove the first occurrence of a value from the children
		 * 
		 * @param val - value to remove
		 * @return true if value found and removed, false otherwise
		 */
		public boolean removeValue(int val) {
			if (next == null)
				return false;
			else if (next.value == val) {

				if (next.next == null)
					next = null;
				else
					next = next.next;

				return true;
			} else
				return next.removeValue(val);
		}
	}

	private Node head; // root
	private int size = 0;

	/**
	 * print linked list
	 */
	public void print() { // O(n)
		if (head != null) {
			head.print();
		}
		System.out.println();
	}

	/**
	 * add value to the end of the list
	 * 
	 * @param val - value to add
	 */
	public void append(int val) { // O(n)
		if (head == null) {
			head = new Node(val);
		} else {
			head.add(val);
		}

		size++;
	}

	/**
	 * add value to the start of the array
	 * 
	 * @param val - value to add
	 */
	public void prepend(int val) { // O(1)
		if (head == null) {
			head = new Node(val);
		} else {
			Node newHead = new Node(val);
			newHead.next = head;
			head = newHead;
		}

		size++;
	}

	/**
	 * check if the list contains a value
	 * 
	 * @param val - value to add
	 * @return true if the list contains the value, false otherwise
	 */
	public boolean contains(int val) { // O(n) worst case
		if (head != null) {
			return head.check(val);
		}

		return false;
	}

	/**
	 * get the value at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param index - the index at which you want to retrieve an element
	 * @return the value at the specified indexF
	 */
	public int get(int index) { // O(index), O(n) worst case
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			return head.value;

		Node current = head.next;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}

		return current.value;
	}

	/**
	 * pop the head off the list, a NullPointerException is thrown if the head is
	 * null
	 * 
	 * @return the value at the head of the list
	 */
	public int pop() { // O(1)
		if (head != null) {
			Node poppedHead = head;
			head = head.next;
			size--;
			return poppedHead.value;
		}

		throw new NullPointerException("List empty");
	}

	/**
	 * remove the last element in the list
	 */
	public void removeLast() { // O(n)
		if (head == null)
			return;

		if (size == 1)
			head = null;
		else if (size == 2)
			head.next = null;
		else {
			Node current = head;
			while (current.next.next != null)
				current = current.next;

			current.next = null;
		}

		size--;
	}

	/**
	 * remove the first occurrence of a value in the list
	 * 
	 * @param val - value to add
	 */
	public void removeValue(int val) { // O(index), O(n) worst case
		if (head == null)
			return;

		if (head.value == val)
			pop();
		else if (head.removeValue(val))
			size--;
	}

	/**
	 * remove the value at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param index - the index at which we wish to remove the element
	 */
	public void removeIndex(int index) { // O(index), O(n) worst case
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			pop();
		else if (index == size - 1)
			removeLast();
		else {
			Node current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			current.next = current.next.next;
			size--;
		}
	}

	/**
	 * insert a value at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param val   - value to add
	 * @param index - the index at which we wish to add an element
	 */
	public void insert(int val, int index) { // O(index), O(n) worst case
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			prepend(val);
		else if (index == size - 1)
			append(val);
		else {
			Node newNode = new Node(val);

			Node current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			newNode.next = current.next;
			current.next = newNode;
		}

		size++;
	}

	/**
	 * peek to see the head/first element from the list, a NullPointerException is
	 * thrown if the head is null
	 * 
	 * @return the head/first element from the list
	 */
	public int peekFirst() { // O(1)
		if (head != null)
			return head.value;

		throw new NullPointerException("List empty");
	}

	/**
	 * peek to see the last element from the list, a NullPointerException is thrown
	 * if the head is null
	 * 
	 * @return the last element from the list
	 */
	public int peekLast() { // O(n)
		if (head == null)
			throw new NullPointerException("List empty");

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		return current.value;
	}

	/**
	 * clear the linked list
	 */
	public void clear() { // O(1)
		head = null;
		size = 0;
	}

	/**
	 * get the size of the list
	 * 
	 * @return the size of the list
	 */
	public int getSize() { // O(1)
		return size;
	}

	/**
	 * transform the linked list into an array
	 * 
	 * @return the array containing the elements of the list
	 */
	public int[] toArray() { // Ot(n), Os(n)
		if (head == null)
			throw new NullPointerException("List empty");

		int[] list = new int[size];
		int i = 0;

		Node current = head;
		list[i] = head.value;

		while (current.next != null) {
			current = current.next;
			list[++i] = current.value;
		}

		return list;
	}

	/**
	 * reverse the linked list
	 * 
	 * @return the reversed linked list
	 */
	public BasicLinkedList reverse() { // Ot(n), Os(n)
		BasicLinkedList reversedList = new BasicLinkedList();

		if (head == null)
			return reversedList;

		Node current = head;
		while (current != null) {
			reversedList.prepend(current.value);
			current = current.next;
		}

		return reversedList;
	}

	/**
	 * reverse this linked list
	 */
	public void internalReverse() { // Ot(n), Os(n)
		head = reverse().head;
	}
}