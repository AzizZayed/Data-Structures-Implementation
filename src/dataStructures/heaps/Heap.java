package dataStructures.heaps;

import java.util.ArrayList;
import java.util.Collections;

/**
 * a class representing a heap data structure. The heap will be modeled in
 * memory as a simple arraylist and not a tree. MUCH easier to deal with and
 * quicker too
 * 
 * @author Zayed
 *
 */
public abstract class Heap {

	ArrayList<Integer> list = new ArrayList<Integer>(); // the heap in the form of a list

	@Override
	public String toString() {
		return "Heap: " + list.toString();
	}

	/**
	 * get the index of the left child node if the heap was a tree
	 * 
	 * @param index - the index we wish to get the left child of
	 * @return the index of the left child
	 */
	protected int getLeftIndex(int index) {
		int left = 2 * index + 1;
		if (isValidIndex(left))
			return left;
		return -1;
	}

	/**
	 * get the index of the right child node if the heap was a tree
	 * 
	 * @param index - the index we wish to get the right child of
	 * @return the index of the right child
	 */
	protected int getRightIndex(int index) {
		int right = 2 * index + 2;
		if (isValidIndex(right))
			return right;
		return -1;
	}

	/**
	 * get the index of the parent node if the heap was a tree
	 * 
	 * @param index - the index we wish to get the parent of
	 * @return the index of the parent
	 */
	protected int getParentIndex(int index) {
		int parent = (int) ((index - 1) / 2);
		if (isValidIndex(parent))
			return parent;
		return -1;
	}

	/**
	 * check if an index is within bounds of the list
	 * 
	 * @param index - the index
	 * @return true if the index is within bounds
	 */
	protected boolean isValidIndex(int index) {
		return index >= 0 && index < list.size();
	}

	/**
	 * swap the 2 element in the list
	 * 
	 * @param i - index of first element to swap
	 * @param j - index of second element to swap
	 */
	protected void swap(int i, int j) {
		Collections.swap(list, i, j);
	}

	/**
	 * @return the first element without removing it
	 */
	public int peek() {
		if (list.size() == 0)
			throw new IndexOutOfBoundsException("Can't peak in an empty heap");
		return list.get(0);
	}

	/**
	 * checks if the heap contains a value
	 * 
	 * @param value - the value we want to check
	 * @return true if the heap contains the value
	 */
	public boolean contains(int value) {
		return list.contains(value);
	}

	/**
	 * clear the heap
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * @return the size of the heap (number of nodes)
	 */
	public int size() {
		return list.size();
	}

	/**
	 * add a value to the end of the heap
	 * 
	 * @param value - value to add
	 */
	public void push(int value) {
		list.add(value);
		if (list.size() == 1)
			return;

		resetUp();
	}

	/**
	 * pop the head of the heap (remove and return it)
	 * 
	 * @return the value at the head of the heap
	 */
	public int pop() {
		if (list.size() == 0)
			throw new IndexOutOfBoundsException("Can't pop off an empty heap");

		int value = list.get(0);
		if (list.size() == 1) {
			list.clear();
		} else {
			list.set(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			resetDown();
		}
		return value;
	}

	/**
	 * reset the heap properties from the bottom to up
	 */
	protected void resetUp() {
		int index = list.size() - 1;
		int parent = getParentIndex(index);

		while (isValidIndex(parent) && comparison(list.get(index), list.get(parent))) {
			swap(index, parent);
			index = parent;
			parent = getParentIndex(index);
		}
	}

	/**
	 * reset the heap properties from top to bottom
	 */
	protected void resetDown() {
		int index = 0;
		int left = getLeftIndex(index);

		while (isValidIndex(left)) {
			int smaller = left;
			int right = getRightIndex(index);
			if (isValidIndex(right) && comparison(list.get(right), list.get(left)))
				smaller = right;

			if (comparison(list.get(index), list.get(smaller)))
				return;

			swap(index, smaller);
			index = smaller;
			left = getLeftIndex(index);
		}
	}

	/**
	 * main difference between a max and min heap. The comparisons to reorder the
	 * array is different: for min heaps, the smaller ones move up to the top and
	 * the parents are always smaller than the children. Form max heaps, its the
	 * exact opposite, the big ones move up to the top and the parents are always
	 * bigger than the children.
	 * 
	 * @param a - first element from the list to compare
	 * @param b - second element from the list to compare
	 * @return the comparison result
	 */
	protected abstract boolean comparison(int a, int b);

	/**
	 * A minheap class is a heap where the smaller ones move up to the top and the
	 * parents are always smaller than the children
	 * 
	 * @author Zayed
	 *
	 */
	public static class MinHeap extends Heap {
		@Override
		protected boolean comparison(int a, int b) {
			return a < b;
		}
	}

	/**
	 * a maxhead is a heap where the big ones move up to the top and the parents are
	 * always bigger than the children
	 * 
	 * @author Zayed
	 *
	 */
	public static class MaxHeap extends Heap {
		@Override
		protected boolean comparison(int a, int b) {
			return a > b;
		}
	}
}
