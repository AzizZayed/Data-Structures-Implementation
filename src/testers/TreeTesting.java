package testers;

import dataStructures.trees.BinarySearchTree;
import dataStructures.trees.BinaryTree;
import dataStructures.trees.LevelBinaryTree;

public class TreeTesting {
	public static void main(String[] args) {
		testLBT();
		testBST();
	}

	public static void printTree(BinaryTree tree) {
		tree.printInorder();
		tree.printLevelOrder();
		if (tree instanceof LevelBinaryTree) {
			tree.printPreorder();
			tree.printPostorder();
		}
	}

	public static void testLBT() {
		System.out.println("///////// Level Binary Tree \\\\\\\\");
		LevelBinaryTree tree = new LevelBinaryTree();

		for (int i = 1; i <= 15; i++)
			tree.insert(i);
		printTree(tree);

		System.out.println("\nDeleting 2: ");
		tree.delete(2);
		printTree(tree);
		System.out.println("\nDeleting 4: ");
		tree.delete(4);
		printTree(tree);
		System.out.println("\nDeleting top: " + tree.pop());
		printTree(tree);
		System.out.println("\nDeleting 3: ");
		tree.delete(3);
		printTree(tree);
		System.out.println("\nDeleting 5: ");
		tree.delete(5);
		printTree(tree);

		for (int i = 1; i <= 15; i++) {
			int num = (int) (Math.random() * 15);
			System.out.println("Tree contains " + num + " :" + tree.contains(num));
		}
	}

	public static void testBST() {
		System.out.println("\n///////// Binary Search Tree \\\\\\\\");
		BinarySearchTree tree = new BinarySearchTree();

		for (int i = 1; i <= 5; i++) {
			tree.insert(i);
		}
		printTree(tree);

		tree.clear();

		tree.insert(2);
		for (int i = 1; i <= 15; i++) {
			tree.insert((int) (Math.random() * 15));
		}
		printTree(tree);

		for (int i = 1; i <= 15; i++) {
			int num = (int) (Math.random() * 15);
			System.out.println("Tree contains " + num + " :" + tree.contains(num));
		}

		printTree(tree);
		System.out.println("\nDeleting 2: ");
		tree.delete(2);
		printTree(tree);
		System.out.println("\nDeleting 4: ");
		tree.delete(4);
		printTree(tree);
		System.out.println("\nDeleting top: " + tree.pop());
		printTree(tree);
		System.out.println("\nDeleting 3: ");
		tree.delete(3);
		printTree(tree);
		System.out.println("\nDeleting 5: ");
		tree.delete(5);
		printTree(tree);
	}
}
