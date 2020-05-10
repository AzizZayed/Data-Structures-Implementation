package testers;

import dataStructures.heaps.Heap;
import dataStructures.heaps.Heap.MaxHeap;
import dataStructures.heaps.Heap.MinHeap;

public class HeapTesting {

	public static void main(String[] args) {
		System.out.println("///// MIN HEAP CHECK \\\\\\///");
		MinHeap minHeap = new MinHeap();
		testHeap(minHeap);

		System.out.println("///// MIN HEAP CHECK \\\\\\///");
		MaxHeap maxHeap = new MaxHeap();
		testHeap(maxHeap);
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
