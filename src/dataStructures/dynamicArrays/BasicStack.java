package dataStructures.dynamicArrays;

/**
 * A Stack class similar to the Stack class in Java Collections, This class
 * extends from the BasicArrayList class to keep all the functionality of a,list
 * and just adds the peek(), pop() and push() methods we all know a stack must
 * have
 * 
 * @author Zayed
 *
 */
public class BasicStack extends BasicArrayList {

	/**
	 * push an element to the top of the stack
	 * 
	 * @param value - the value to push
	 */
	public void push(int value) { // Ot(1)
		append(value);
	}

	/**
	 * pop the element at the top of the stack
	 * 
	 * @return the top element
	 */
	public int pop() { // Ot(1)
		if (getSize() == 0)
			throw new IndexOutOfBoundsException("Can't pop from an empty stack");

		int last = get(getSize() - 1);
		removeLast();
		return last;
	}

	/**
	 * peek at the element at the top of the stack
	 * 
	 * @return the top element
	 */
	public int peek() { // Ot(1)
		if (getSize() == 0)
			throw new IndexOutOfBoundsException("Can't peek in an empty stack");
		
		return get(getSize() - 1);
	}
}