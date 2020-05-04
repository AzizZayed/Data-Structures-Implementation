package dataStructures.dynamicArrays;

/**
 * The ArrayList class similar to the one in the Java Collections.
 * 
 * @author Zayed
 *
 */
public class BasicArrayList {

	private static final int MINIMUM_CAPACITY = 10; // minimum capacity for the array list
	private static final int CAPACITY_MULTIPLIER = 2; // How much to increase the capacity when full

	private int[] list; // the list with all the elements
	private int size = 0; // the size of the stored elements
	private boolean sorted = true; // if the elements are sorted

	/**
	 * constructor
	 */
	public BasicArrayList() {
		list = new int[MINIMUM_CAPACITY + 5];
	}

	/**
	 * @return the size of the array
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the capacity of the list
	 */
	public int getCapacity() {
		return list.length;
	}

	/**
	 * print the list
	 */
	public void print() { // O(n)
		System.out.print("[");
		for (int i = 0; i < size - 1; i++)
			System.out.print(list[i] + ", ");
		System.out.print((size - 1 < 0 ? "" : list[size - 1]) + "]\n");
	}

	/**
	 * change the capacity
	 * 
	 * @param newCapacity - the new wanted capacity
	 */
	public void ensureCapacity(int newCapacity) { // Ot(n), Os(n)
		if (newCapacity <= 0)
			throw new IllegalArgumentException("Capacity must be bigger than 0");

		if (newCapacity < MINIMUM_CAPACITY)
			newCapacity = MINIMUM_CAPACITY;

		int[] newList = new int[newCapacity];
		System.arraycopy(list, 0, newList, 0, Math.min(list.length, newCapacity));

		list = newList;

		if (list.length < size)
			size = list.length;
	}

	/**
	 * add element to the end of the list
	 * 
	 * @param value - the value we want to add
	 */
	public void append(int value) { // Ot(1)
		list[size] = value;
		checkCapacity();
		sorted = false;
	}

	/**
	 * add element to the beginning of the list
	 * 
	 * @param value - the value we want to add
	 */
	public void prepend(int value) { // Ot(n), Os(n)
		checkCapacity();
		System.arraycopy(list, 0, list, 1, size - 1);
		list[0] = value;
		sorted = false;
	}

	/**
	 * insert an element in the array
	 * 
	 * @param value - the value we want to insert
	 * @param index - where to add the value
	 */
	public void insert(int value, int index) { // Ot(n), Os(n)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			prepend(value);
		else if (index == size - 1)
			append(value);
		else {
			checkCapacity();
			System.arraycopy(list, index, list, index + 1, size - index - 1);
			list[index] = value;
		}
		sorted = false;
	}

	/**
	 * Check if the list contains the element
	 * 
	 * @param value - the value we want to check if present in the array
	 * @return true if element is present
	 */
	public boolean contains(int value) { // Ot(n) worst case
		for (int i = 0; i < size; i++)
			if (list[i] == value)
				return true;
		return false;
	}

	/**
	 * get element at the specified index, Throws IndexOutOfBoundsException if index
	 * is outside bounds of array
	 * 
	 * @param index - the location of the wanted value
	 * @return the value at the specified index
	 */
	public int get(int index) { // Ot(1)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		return list[index];
	}

	/**
	 * get the index of the specified value
	 * 
	 * @param value - the value we want the index for
	 * @return the index of the value
	 */
	public int getIndexOf(int value) {
		if (sorted)
			return binarySearch(list, value, 0, size - 1);
		return sequentialSearch(list, value, 0, size);
	}

	/**
	 * set the value at the index to specified value
	 * 
	 * @param value - the value we want to put
	 * @param index - the location we want to add that value
	 */
	public void set(int value, int index) { // Ot(1)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		list[index] = value;
		sorted = false;
	}

	/**
	 * remove the last element of the list
	 */
	public void removeLast() { // Ot(1)
		if (size != 0)
			size--;
	}

	/**
	 * remove the first element of the list
	 */
	public void removeFirst() { // Ot(n), Os(n)
		System.arraycopy(list, 1, list, 0, --size);
	}

	/**
	 * remove the element at the specified index
	 * 
	 * @param index - the index at which we will remove the element
	 */
	public void remove(int index) { // Ot(n), Os(n)
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index needs to be within bounds");

		if (index == 0)
			removeFirst();
		else if (index == size - 1)
			removeLast();
		else
			System.arraycopy(list, index + 1, list, index, --size - index);
	}

	/**
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * clear the list
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * @return an array equivalent of the list
	 */
	public int[] toArray() { // O(n), Os(n)
		int[] compressed = new int[size];
		System.arraycopy(list, 0, compressed, 0, size);
		return compressed;
	}

	/**
	 * Sort the array using the appropriate methods of sorting
	 */
	public void sort() {
		if (size < 2)
			return;

		if (size < 64)
			insertionSort(list, 0, size - 1);
		else if (size < 256)
			quicksort(list, 0, size - 1);
		else
			System.arraycopy(mergeSort(list, 0, size - 1), 0, list, 0, size);

		sorted = true;
	}

	/**
	 * check if the size exceeds the capacity, if yes, increase it
	 */
	private void checkCapacity() {
		if (++size == list.length)
			ensureCapacity(list.length * CAPACITY_MULTIPLIER);
	}

	/**
	 * binary search algorithm
	 * 
	 * @param a      - the array to search through
	 * @param target - the value we're looking for
	 * @param start  - the start index of the search
	 * @param stop   - the end index of the search
	 * @return the index of the target, -1 if the target does not exist
	 */
	private int binarySearch(int[] a, int target, int start, int stop) {
		while (start <= stop) {
			int mid = (start + stop) / 2;

			if (target == a[mid])
				return mid;
			else if (target < a[mid])
				stop = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	/**
	 * sequential search algorithm
	 * 
	 * @param listToSearch - the array to search through
	 * @param target       - the value we're looking for
	 * @param start        - the start index of the search
	 * @param listSize     - the size of the list
	 * @return the index of the target, -1 if the target does not exist
	 */
	private int sequentialSearch(int[] listToSearch, int target, int start, int listSize) { // Ot(n)
		int i = start;
		int lastIndex = listSize - 1;
		int last = listToSearch[lastIndex];

		listToSearch[lastIndex] = target;

		while (listToSearch[i] != target)
			i++;

		listToSearch[lastIndex] = last;

		if (i < lastIndex || last == target)
			return i;

		return -1;
	}

	/**
	 * QuickSort algorithm
	 * 
	 * @param a     - the list we want to sort
	 * @param start - start index of the subArray
	 * @param stop  - end index of the subArray
	 */
	private void quicksort(int[] a, int start, int stop) {
		if (start < stop) {
			int pivot = division(a, start, stop);
			quicksort(a, start, pivot - 1);
			quicksort(a, pivot + 1, stop);
		}
	}

	/**
	 * divide the array around the pivot
	 * 
	 * @param a     - the list we want to sort
	 * @param start - start index of the subArray
	 * @param stop  - end index of the subArray
	 * @return the pivot
	 */
	private int division(int[] a, int start, int stop) {
		int pivot = a[stop];
		int i = start;
		for (int j = start; j <= stop; j++)
			if (a[j] < pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		int temp = a[stop];
		a[stop] = a[i];
		a[i] = temp;
		return i;
	}

	/**
	 * InsertionSort algorithm
	 * 
	 * @param start - start index of the array
	 * @param stop  - end index of the array
	 */
	private void insertionSort(int[] a, int start, int stop) {
		for (int i = start + 1; i <= stop; i++)
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
	}

	/**
	 * MergeSort algorithm
	 * 
	 * @param listToSort - the list we want to sort
	 * @param start      - start index of the subArray
	 * @param stop       - end index of the subArray
	 * @return the merged array
	 */
	private int[] mergeSort(int[] listToSort, int start, int stop) {
		if (start == stop)
			return new int[] { listToSort[start] };

		int middle = (start + stop) / 2;

		int[] left = mergeSort(listToSort, start, middle);
		int[] right = mergeSort(listToSort, middle + 1, stop);

		return merge(left, right);
	}

	/**
	 * merge the two given arrays in sorted order
	 * 
	 * @param a - the first array to merge
	 * @param b - the second array to merge
	 * @return the merged array
	 */
	private int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];

		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				merged[i + j] = a[i];
				i++;
			} else {
				merged[i + j] = b[j];
				j++;
			}
		}

		while (i < a.length) {
			merged[i + j] = a[i];
			i++;
		}
		while (j < b.length) {
			merged[i + j] = b[j];
			j++;
		}
		return merged;
	}
}