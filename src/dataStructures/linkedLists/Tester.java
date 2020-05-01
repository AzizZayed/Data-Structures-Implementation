package dataStructures.linkedLists;

import java.util.Arrays;

/**
 * This is a tester class, yes it's messy, it's only use is to test all the data
 * structure methods and functions and see if they work as intended
 * 
 * @author Zayed
 *
 */
public class Tester {
	public static void main(String[] args) {
		BasicLinkedList list = new BasicLinkedList();

		// test append, size and print
		System.out.println("Append:");
		list.append(5);
		list.append(6);
		list.append(5);
		list.append(9);

		printInfo(list);

		list.append(9);
		list.append(0);
		list.append(-342);
		list.append(3453);

		printInfo(list);

		// test prepend
		System.out.println("Prepend:");
		list.prepend(50);
		list.prepend(60);
		list.prepend(50);
		list.prepend(90);

		printInfo(list);

		// test contains
		for (int i = 0; i <= 10; i++)
			System.out.println("Contains " + i + ": " + list.contains(i));

		// test removeLast
		System.out.println("Removing last element:");
		list.removeLast();
		printInfo(list);

		// test pop
		System.out.println("Testing popHead:");
		System.out.println("First element removed: " + list.popHead());
		printInfo(list);

		for (int i = 0; i < 10; i++) {
			System.out.println("First element removed: " + list.popHead());
			printInfo(list);
		}

		// test exception throwing if we pop from the empty list
		try {
			list.popHead();
		} catch (NullPointerException e) {
			System.out.println("Exception " + e.toString());
		}

		// test exception throwing if we peekfirst the empty list
		try {
			list.peekFirst();
		} catch (NullPointerException e) {
			System.out.println("Exception " + e.toString());
		}

		// test exception throwing if we peeklast the empty list
		try {
			list.peekLast();
		} catch (NullPointerException e) {
			System.out.println("Exception " + e.toString());
		}

		for (int i = 0; i <= 10; i++)
			list.append(i);

		// test peekfirst and peeklast
		System.out.print("The List before peeks: ");
		list.print();

		System.out.println("Testing peeks:");
		System.out.println("First: " + list.peekFirst());
		System.out.println("Last: " + list.peekLast());

		// test toArray
		System.out.println("List to Array: " + Arrays.toString(list.toArray()));

		for (int i = 0; i <= 10; i++)
			list.append(i);

		printInfo(list);

		// test get via index
		for (int i = 0; i <= 15; i++) {
			int index = (int) (Math.random() * list.getSize());
			System.out.println("At index " + index + ": " + list.get(index));
		}

		// test insertion
		System.out.println("Insertions:");
		list.insert(-11, 0);
		list.print();

		list.insert(-11, list.getSize() - 1);
		list.print();

		list.insert(-11, 5);
		list.print();

		// test removal with index
		printInfo(list);

		System.out.println("Removing at index 0:");
		list.removeIndex(0);
		printInfo(list);

		System.out.println("Removing at index 4:");
		list.removeIndex(4);
		printInfo(list);

		System.out.println("Removing at index " + (list.getSize() - 1) + ":");
		list.removeIndex(list.getSize() - 1);
		printInfo(list);

		// test removal with value
		System.out.println("Removing value 0:");
		list.removeValue(0);
		printInfo(list);

		System.out.println("Removing value -11:");
		list.removeValue(-11);
		printInfo(list);

		list.prepend(0);

		// test reversing list
		printInfo(list);

		System.out.print("The Reversed List: ");
		list.reverse().print();

		System.out.print("The Internally Reversed List: ");
		list.internalReverse();
		list.print();
		
		list.clear();
		
		for (int i = 0; i <= 15; i++) {
			int val = (int) (Math.random() * 15);
			list.prepend(val);
		}

		//sorting test
		System.out.print("New list: ");
		list.print();
		System.out.print("Sorted list: ");
		list.sort();
		list.print();
	}

	public static void printInfo(BasicLinkedList list) {
		System.out.print("The List: ");
		list.print();
		System.out.println("Size: " + list.getSize());
	}
}