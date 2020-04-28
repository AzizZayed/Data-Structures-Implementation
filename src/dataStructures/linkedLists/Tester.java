package dataStructures.linkedLists;

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
		list.append(5);
		list.append(6);
		list.append(5);
		list.append(9);

		System.out.println("Size: " + list.getSize());

		System.out.print("The List: ");
		list.print();

		list.append(9);
		list.append(0);
		list.append(-342);
		list.append(3453);

		System.out.println("Size: " + list.getSize());

		System.out.print("The List: ");
		list.print();

		// test prepend
		list.prepend(50);
		list.prepend(60);
		list.prepend(50);
		list.prepend(90);

		System.out.println("Size: " + list.getSize());

		System.out.print("The List: ");
		list.print();

		// test contains
		for (int i = 0; i <= 10; i++)
			System.out.println("Contains " + i + ": " + list.contains(i));

		// test removeLast
		System.out.println("Size before removal: " + list.getSize());

		System.out.print("The List before: ");
		list.print();

		list.removeLast();
		System.out.println("Last element removed.");
		System.out.println("Size after last element removed: " + list.getSize());

		System.out.print("The List after last element removed: ");
		list.print();

		// test pop
		System.out.println("First element removed: " + list.pop());
		System.out.println("Size after pop: " + list.getSize());

		System.out.print("The List after pop: ");
		list.print();

		for (int i = 0; i < 10; i++) {
			System.out.println("First element removed: " + list.pop());
			System.out.println("Size after pop: " + list.getSize());

			System.out.print("The List after pop: ");
			list.print();
		}

		// test exception throwing if we pop from the empty list
		try {
			list.pop();
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

		System.out.println("First: " + list.peekFirst());
		System.out.println("Last: " + list.peekLast());

		// test toArray
		System.out.print("List to Array: ");
		int[] array = list.toArray();
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();

		// test clear
		System.out.println("Size before clear: " + list.getSize());
		System.out.print("The List before clear: ");
		list.print();

		list.clear();

		System.out.println("Size after clear: " + list.getSize());
		System.out.print("The List after clear: ");
		list.print();

		for (int i = 0; i <= 10; i++)
			list.append(i);

		System.out.print("The List: ");
		list.print();

		// test get via index
		for (int i = 0; i <= 15; i++) {
			int index = (int) (Math.random() * list.getSize());
			System.out.println("Index " + index + ": " + list.get(index));
		}

		// test out of bounds exception
		try {
			list.get(list.getSize());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception " + e.toString());
		}

		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception " + e.toString());
		}

		// test insertion
		System.out.print("The List: ");
		list.print();

		list.insert(-11, 0);
		list.print();

		list.insert(-11, list.getSize() - 1);
		list.print();

		list.insert(-11, 5);
		list.print();

		// test removal with index
		System.out.print("The List: ");
		list.print();
		System.out.println("Size before removal: " + list.getSize());

		list.removeIndex(0);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		list.removeIndex(4);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		list.removeIndex(list.getSize() - 1);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		// test removal with value
		System.out.print("The List: ");
		list.print();
		System.out.println("Size before removal: " + list.getSize());

		list.removeValue(0);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		list.removeValue(4);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		list.removeValue(list.getSize() - 1);
		list.print();
		System.out.println("Size after removal: " + list.getSize());

		// test reversing list
		System.out.print("The List: ");
		list.print();

		System.out.print("The Reversed List: ");
		list.reverse().print();

		System.out.print("The List: ");
		list.print();

		System.out.print("The Internally Reversed List: ");
		list.internalReverse();
		list.print();
	}
}