package dataStructures.dynamicArrays;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		testArrayList();
		testStack();

	}

	public static void printInfo(BasicArrayList list) {
		System.out.print("List: ");
		list.print();
		System.out.println("Size: " + list.getSize());
		System.out.println("Capacity: " + list.getCapacity());
	}

	public static void testStack() {
		BasicStack stack = new BasicStack();

		System.out.println(" /////////////// Stack Testing ///////////////////// ");

		int max = 10;
		for (int i = 0; i < max; i++) {
			System.out.println("Pushing " + i);
			stack.push(i);
		}
		printInfo(stack);
		System.out.println("Peeking last element: " + stack.peek());
		for (int i = 0; i < max; i++) {
			System.out.println("Poping " + stack.pop());
		}
		printInfo(stack);
	}

	public static void testArrayList() {
		BasicArrayList list;
		System.out.println(" /////////////// ArrayList Testing ///////////////////// ");

		// test constructors
		list = new BasicArrayList();
		printInfo(list);
		list.ensureCapacity(10);
		printInfo(list);

		// append and prepend
		System.out.println("Append and Prepend:");
		for (int i = 0; i < 5; i++)
			list.append(i);
		printInfo(list);

		for (int i = 0; i < 15; i++)
			list.prepend(i);
		printInfo(list);

		// insertion
		System.out.println("Insertions:");
		System.out.println("Insert 5 at index 5:");
		list.insert(5, 5);
		printInfo(list);
		System.out.println("Insert 6 at index 6:");
		list.insert(6, 6);
		printInfo(list);
		System.out.println("Insert -11 at index 11:");
		list.insert(-11, 11);
		printInfo(list);

		// toArray test
		System.out.println("To array: " + Arrays.toString(list.toArray()));

		// resize
		System.out.println("Change to capacity of 60:");
		list.ensureCapacity(60);
		printInfo(list);
		// resize
		System.out.println("Change to capacity of 16:");
		list.ensureCapacity(16);
		printInfo(list);
		// resize
		System.out.println("Change to capacity of 60:");
		list.ensureCapacity(60);
		printInfo(list);
		// resize
		System.out.println("Change to capacity of 17:");
		list.ensureCapacity(17);
		printInfo(list);
		// resize
		System.out.println("Change to capacity of 6 (should not work):");
		list.ensureCapacity(6);
		printInfo(list);

		// toArray test
		System.out.println("To array: " + Arrays.toString(list.toArray()));

		// remove last
		System.out.println("Removing last element:");
		list.removeLast();
		printInfo(list);
		// remove first
		System.out.println("Removing first element:");
		list.removeFirst();
		printInfo(list);

		// remove index
		System.out.println("Removing at index 2:");
		list.remove(2);
		printInfo(list);
		// remove index
		System.out.println("Removing at index 4:");
		list.remove(4);
		printInfo(list);

		// get
		System.out.println("At index 2: " + list.get(2));
		System.out.println("At index 1: " + list.get(1));
		System.out.println("At index 0: " + list.get(0));
		try {
			list.get(7);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception " + e.toString());
		}

		// set
		System.out.println("Set index 2 to 2: ");
		list.set(2, 2);
		list.print();
		System.out.println("Set index 1 to 1: ");
		list.set(1, 1);
		list.print();
		System.out.println("Set index 0 to 0: ");
		list.set(0, 0);
		list.print();
		try {
			list.set(7, 7);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception " + e.toString());
		}

		// contains
		for (int i = 0; i < 15; i++)
			System.out.println("List contains " + i + ": " + list.contains(i));

		// toArray test
		System.out.println("To array: " + Arrays.toString(list.toArray()));

		// searching
		System.out.println("Sequential Search:");
		for (int i = 0; i < 25; i++) {
			int num = (int) (Math.random() * 11);
			System.out.println("Index of " + num + ": " + list.getIndexOf(num));
		}

		int max = 15;
		for (int i = 0; i <= max; i++) {
			int val = (int) (Math.random() * max);
			list.prepend(val);
		}

		// sorting test
		System.out.print("New list: ");
		list.print();
		System.out.print("Sorted list: ");
		list.sort();
		list.print();

		// searching with binary search
		System.out.println("Binary Search:");
		for (int i = 0; i < 25; i++) {
			int num = (int) (Math.random() * max);
			System.out.println("Index of " + num + ": " + list.getIndexOf(num));
		}
	}
}