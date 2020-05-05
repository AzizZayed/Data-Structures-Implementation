package dataStructures.heaps;

import dataStructures.heaps.Heap.MaxHeap;
import dataStructures.heaps.Heap.MinHeap;

public class Tester {

	public static void main(String[] args) {
		System.out.println("///// MIN HEAP CHECK \\\\\\///");
		MinHeap heap1 = new MinHeap();
		testHeap(heap1);
		
		System.out.println("///// MIN HEAP CHECK \\\\\\///");
		MaxHeap heap2 = new MaxHeap();
		testHeap(heap2);
	}

	public static void testHeap(Heap heap) {
		System.out.println(heap);

		heap.push(1);
		System.out.println(heap);
		heap.push(1);
		heap.push(1);
		System.out.println(heap);
		System.out.println("Popped: " + heap.pop());
		System.out.println(heap);
		System.out.println("Popped: " + heap.pop());
		System.out.println(heap);
		System.out.println("Popped: " + heap.pop());
		System.out.println(heap);
		try {
			heap.pop();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception: " + e);
		}

		int max = 7;
		for (int i = 0; i < max; i++) {
			int num = (int) (Math.random() * max);
			System.out.println("Added: " + num);
			heap.push(num);
		}
		System.out.println(heap);
		for (int i = 0; i < max; i++) {
			int num = (int) (Math.random() * max);
			System.out.println("Contains " + num + ": " + heap.contains(num));
		}

		System.out.println(heap);
		System.out.println("Peek: " + heap.peek());
		for (int i = heap.size(); i > 0; i--) {
			System.out.println("Popped: " + heap.pop());
			System.out.println(heap);
		}
	}
}
