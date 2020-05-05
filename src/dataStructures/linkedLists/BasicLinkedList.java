package dataStructures.linkedLists;

/**
 * This is a basic LinkedList class with all the necessary functions a
 * LinkedList class - or any data structure - would have. All the time and space
 * complexities are written beside the functions. Some optimizations can be done
 * to this class. For example, if it had a pointer to the last element of the
 * list, the append() and peekLast() functions would run in constant time
 * instead of linear time. The removeLast() method can also be optimized if we
 * had this pointer and also a pointer to the parent node. Most of these
 * performance issues are solved with a double linked list with a pointer to the
 * last SingleNode.
 * 
 * @author Zayed
 * 
 */
public class BasicLinkedList extends LinkedList {

	/**
	 * The node class: the elements of the list
	 * 
	 * @author Zayed
	 *
	 */
	protected class SingleNode extends Node {
		public SingleNode next;

		/**
		 * constructor
		 * 
		 * @param value - value of the node
		 */
		public SingleNode(int value) {
			super(value);
			next = null;
		}
	}

	protected SingleNode head; // root

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SingleNode current = head;

		sb.append("[");
		while (current != null) {
			sb.append(current.value + (current.next == null ? "" : ", "));
			current = current.next;
		}
		sb.append("]");
		String h = head == null ? "null" : Integer.toString(head.value);
		sb.append(" \nHead: " + h + "\n");

		return sb.toString();
	}

	@Override
	public void append(int value) { // O(n)
		if (head == null) {
			head = new SingleNode(value);
		} else {
			SingleNode current = head;
			while (current.next != null)
				current = current.next;
			current.next = new SingleNode(value);
		}
		size++;
	}

	@Override
	public void prepend(int value) { // O(1)
		if (head == null) {
			head = new SingleNode(value);
		} else {
			SingleNode newHead = new SingleNode(value);
			newHead.next = head;
			head = newHead;
		}
		size++;
	}

	@Override
	public boolean contains(int value) { // O(n) worst case
		if (head != null) {
			SingleNode current = head;
			while (current != null) {
				if (current.value == value)
					return true;
				current = current.next;
			}
		}
		return false;
	}

	@Override
	public int get(int index) { // O(index), O(n) worst case
		return getNode(head, index).value;
	}

	/**
	 * get the node at the specified index, this method throws a
	 * IndexOutOfBoundsException if the index is not bounded to between 0 and the
	 * size of the list
	 * 
	 * @param top   - the head of the list to divide
	 * @param index - the index at which you want to retrieve the node
	 * @return the node at the specified index
	 */
	private SingleNode getNode(SingleNode top, int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			return top;

		SingleNode current = top.next;
		for (int i = 1; i < index; i++)
			current = current.next;

		return current;
	}

	@Override
	public int popHead() { // O(1)
		if (head != null) {
			SingleNode poppedHead = head;
			head = head.next;
			size--;
			return poppedHead.value;
		}

		throw new NullPointerException("List empty");
	}

	@Override
	public void removeLast() { // O(n)
		if (head == null)
			return;

		if (size == 1)
			head = null;
		else if (size == 2)
			head.next = null;
		else {
			SingleNode current = head;
			while (current.next.next != null)
				current = current.next;
			current.next = null;
		}
		size--;
	}

	@Override
	public void removeIndex(int index) { // O(index), O(n) worst case
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			popHead();
		else if (index == size - 1)
			removeLast();
		else {
			SingleNode current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			current.next = current.next.next;
			size--;
		}
	}

	@Override
	public void insert(int value, int index) { // O(index), O(n) worst case
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			prepend(value);
		else if (index == size - 1)
			append(value);
		else {
			SingleNode newSingleNode = new SingleNode(value);

			SingleNode current = head;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			newSingleNode.next = current.next;
			current.next = newSingleNode;
			size++;
		}
	}

	@Override
	public int peekFirst() { // O(1)
		if (head != null)
			return head.value;

		throw new NullPointerException("List empty");
	}

	@Override
	public int peekLast() { // O(n)
		if (head == null)
			throw new NullPointerException("List empty");

		SingleNode current = head;
		while (current.next != null) {
			current = current.next;
		}

		return current.value;
	}

	@Override
	public void clear() { // O(1)
		head = null;
		size = 0;
	}

	@Override
	public int[] toArray() { // Ot(n), Os(n)
		if (head == null)
			throw new NullPointerException("List empty");

		int[] list = new int[size];
		int i = 0;

		SingleNode current = head;
		list[i] = head.value;

		while (current.next != null) {
			current = current.next;
			list[++i] = current.value;
		}

		return list;
	}

	@Override
	public void internalReverse() { // Ot(n), Os(1)
		SingleNode previous, current, next;

		previous = null;
		current = head;
		next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		head = previous;
	}

	@Override
	public void sort() { // Ot(nlogn), Os(n)
		if (head == null || size < 2)
			return;

		head = divide(head, size);
	}

	/**
	 * divide the list, division part of merge sort
	 *
	 * @param top     - the head of the list to divide
	 * @param divSize - the size of the given list (top)
	 * @return head node of merged list
	 */
	private SingleNode divide(SingleNode top, int divSize) {
		if (top == null || top.next == null || divSize <= 0)
			return top;

		int subSize = (divSize) / 2; // size of sub division

		SingleNode centerNode = getNode(top, subSize - 1);
		SingleNode rightList = centerNode.next;
		centerNode.next = null;

		SingleNode left = divide(top, subSize);
		SingleNode right = divide(rightList, subSize + (divSize % 2));

		return merge(left, right);
	}

	/**
	 * merge the divided lists, merge part of merge sort
	 *
	 * @param left  - left node/list to merge
	 * @param right - right node/list to merge
	 * @return head node of merged list
	 */
	private SingleNode merge(SingleNode left, SingleNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		SingleNode mergedList = null; // head of the list to return

		SingleNode leftPtr = left;
		SingleNode rightPtr = right;
		SingleNode previous = null;
		while (leftPtr != null && rightPtr != null) {
			SingleNode current;

			if (leftPtr.value > rightPtr.value) {
				current = new SingleNode(rightPtr.value);
				rightPtr = rightPtr.next;
			} else {
				current = new SingleNode(leftPtr.value);
				leftPtr = leftPtr.next;
			}

			if (mergedList == null) {
				mergedList = current;
			} else {
				previous.next = current;
			}

			previous = current;
		}

		if (leftPtr == null) {
			previous.next = rightPtr;
		} else {
			previous.next = leftPtr;
		}

		return mergedList;
	}
}