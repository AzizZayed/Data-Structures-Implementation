package dataStructures.linkedLists;

/**
 * a linked list with each node referencing parent and child. This is more
 * efficient than a single linked list time-wise but not space-wise
 * 
 * @author Zayed
 *
 */
public class DoublyLinkedList extends LinkedList {

	/**
	 * The double node class: the elements of the doubly linked lists
	 * 
	 * @author Zayed
	 *
	 */
	private class DoubleNode extends Node {
		public DoubleNode next, parent; // pointers to the parent node

		/**
		 * constructor
		 * 
		 * @param value - value of the node
		 */
		public DoubleNode(int value) {
			super(value);
			next = parent = null;
		}
	}

	private DoubleNode head, tail; // root and last element

	@Override
	public String toString() { // O(2n) ~ O(n), where n is the size of the list
		StringBuilder sb = new StringBuilder();
		DoubleNode current;

		sb.append("\nForward: [");
		current = head;
		while (current != null) {
			sb.append(current.value + (current.next == null ? "" : ", "));
			current = current.next;
		}
		sb.append("]");
		sb.append(" \nBackward: [");
		if (tail == null && head != null)
			sb.append(head.value);
		else {
			current = tail;
			while (current != null) {
				sb.append(current.value + (current.parent == null ? "" : ", "));
				current = current.parent;
			}
		}
		sb.append("]");

		String h = head == null ? "null" : Integer.toString(head.value);
		String t = tail == null ? "null" : Integer.toString(tail.value);
		sb.append(" \nHead: " + h + ", Tail: " + t + "\n");

		return sb.toString();
	}

	@Override
	public void append(int value) { // O(1)
		if (head == null) {
			head = new DoubleNode(value);
		} else if (tail == null) {
			tail = new DoubleNode(value);
			tail.parent = head;
			head.next = tail;
		} else {
			DoubleNode newTail = new DoubleNode(value);
			newTail.parent = tail;
			tail.next = newTail;
			tail = newTail;
		}
		size++;
	}

	@Override
	public void prepend(int value) { // O(1)
		if (head == null) {
			head = new DoubleNode(value);
		} else if (tail == null) {
			tail = head;
			head = new DoubleNode(value);
			head.next = tail;
			tail.parent = head;
		} else {
			DoubleNode newHead = new DoubleNode(value);
			newHead.next = head;
			head.parent = newHead;
			head = newHead;
		}
		size++;
	}

	@Override
	public boolean contains(int value) { // O(n) worst case
		// linear search
		if (head != null) {
			DoubleNode current = head;
			while (current != null) {
				if (current.value == value)
					return true;
				current = current.next;
			}
		}
		return false;
	}

	@Override
	public int get(int index) { // O(index), O(n/2) ~ O(n) worst case
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
	private DoubleNode getNode(DoubleNode top, int index) { // O(n/2) worst case ~ O(n) -> when index is center element
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		DoubleNode current;
		if (index <= size / 2) {
			if (index == 0)
				return top;

			current = top.next;
			for (int i = 1; i < index; i++)
				current = current.next;
		} else {
			if (index == size - 1)
				return tail;

			current = tail.parent;
			for (int i = size - 2; i > index; i--)
				current = current.parent;
		}
		return current;
	}

	@Override
	public int popHead() { // O(1)
		if (head != null) {
			int val = head.value;
			if (tail == null) {
				head = null;
			} else {
				head = head.next;
				head.parent = null;
			}
			size--;
			if (size == 1) {
				tail = null;
			}
			return val;
		}

		throw new NullPointerException("List empty");
	}

	/**
	 * pop the tail off the list
	 * 
	 * @return the value at the head of the list
	 */
	public int popTail() { // O(1)
		if (size == 1)
			return popHead();

		int val = tail.value;
		removeLast();
		return val;
	}

	@Override
	public void removeLast() { // O(1)
		if (size == 1)
			popHead();
		else if (size == 2)
			tail = null;
		else {
			tail = tail.parent;
			tail.next = null;
		}
		size--;
	}

	@Override
	public void removeIndex(int index) { // O(n/2) worst case ~ O(n)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			popHead();
		else if (index == size - 1)
			removeLast();
		else {
			if (index <= size / 2) { // optimize for half the compute time
				DoubleNode current = head;
				for (int i = 0; i < index - 1; i++)
					current = current.next;
				current.next.next.parent = current;
				current.next = current.next.next;
			} else {
				DoubleNode current = tail;
				for (int i = size - 1; i > index + 1; i--)
					current = current.parent;
				current.parent.parent.next = current;
				current.parent = current.parent.parent;
			}
			size--;
		}
	}

	@Override
	public void insert(int value, int index) { // O(n/2) worst case ~ O(n)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			prepend(value);
		else if (index == size - 1)
			append(value);
		else {
			if (index <= size / 2) {
				DoubleNode newNode = new DoubleNode(value);

				DoubleNode current = head;
				for (int i = 0; i < index - 1; i++)
					current = current.next;

				newNode.parent = current;
				newNode.next = current.next;
				current.next.parent = newNode;
				current.next = newNode;
			} else {
				DoubleNode newNode = new DoubleNode(value);

				DoubleNode current = tail;
				for (int i = size - 1; i > index + 1; i--)
					current = current.parent;

				newNode.parent = current.parent;
				current.parent.next = newNode;
				newNode.next = current;
				current.parent = newNode;
			}
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
	public int peekLast() { // O(1)
		if (tail != null)
			return tail.value;
		else
			return peekFirst();
	}

	@Override
	public void clear() { // O(1)
		head = tail = null;
		size = 0;
	}

	@Override
	public int[] toArray() { // Ot(n), Os(n)
		if (head == null)
			throw new NullPointerException("List empty");

		int[] list = new int[size];
		int i = 0;

		DoubleNode current = head;
		list[i] = head.value;

		while (current.next != null) {
			current = current.next;
			list[++i] = current.value;
		}

		return list;
	}

	@Override
	public void internalReverse() { // Ot(n), Os(1)
		DoubleNode previous = null;
		DoubleNode current = head;
		DoubleNode next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current.parent = null;
			current = next;
			previous.parent = current;
			if (previous.next == null)
				tail = previous;
		}
		head = previous;
	}

	@Override
	public void sort() { // Ot(nlogn), Os(n)
		if (head == null || size < 2)
			return;

		head = divide(head, size);

		// find tail
		DoubleNode curr = head;
		while (curr.next != null)
			curr = curr.next;

		tail = curr;
	}

	/**
	 * divide the list, division part of merge sort
	 *
	 * @param top     - the head of the list to divide
	 * @param divSize - the size of the given list (top)
	 * @return head node of merged list
	 */
	private DoubleNode divide(DoubleNode top, int divSize) { // Ot(nlogn), Os(n)
		if (top == null || top.next == null || divSize <= 0)
			return top;

		int subSize = (divSize) / 2; // size of sub division

		DoubleNode centerNode = getNode(top, subSize - 1);
		DoubleNode rightList = centerNode.next;
		centerNode.next = null;

		DoubleNode left = divide(top, subSize);
		DoubleNode right = divide(rightList, subSize + (divSize % 2));

		return merge(left, right);
	}

	/**
	 * merge the divided lists, merge part of merge sort
	 *
	 * @param left  - left node/list to merge
	 * @param right - right node/list to merge
	 * @return head node of merged list
	 */
	private DoubleNode merge(DoubleNode left, DoubleNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		DoubleNode mergedList = null; // head of the list to return

		DoubleNode leftPtr = left;
		DoubleNode rightPtr = right;
		DoubleNode previous = null;
		while (leftPtr != null && rightPtr != null) {
			DoubleNode current;

			if (leftPtr.value > rightPtr.value) {
				current = new DoubleNode(rightPtr.value);
				rightPtr = rightPtr.next;
			} else {
				current = new DoubleNode(leftPtr.value);
				leftPtr = leftPtr.next;
			}

			if (mergedList == null) {
				mergedList = current;
			} else {
				previous.next = current;
				current.parent = previous;
			}

			previous = current;
		}

		if (leftPtr == null) {
			previous.next = rightPtr;
			rightPtr.parent = previous;
		} else {
			previous.next = leftPtr;
			leftPtr.parent = previous;
		}

		return mergedList;
	}
}
