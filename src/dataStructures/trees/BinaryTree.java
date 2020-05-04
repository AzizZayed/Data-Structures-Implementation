package dataStructures.trees;

import java.util.LinkedList;

/**
 * Class for the functions binary trees need. An example of a tree is your file
 * system
 * 
 * @author Zayed
 *
 */
public abstract class BinaryTree {

	/**
	 * The node class with reference to the left and right nodes
	 */
	protected class Node {
		public Node left, right;
		public int value;

		/**
		 * construct an empty node
		 * 
		 * @param value - the value of the node
		 */
		public Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	protected Node root; // the root node, the head of the tree

	/**
	 * Constructor
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructor with initial root value;
	 */
	public BinaryTree(int value) {
		root = new Node(value);
	}

	/**
	 * print left -> root -> right
	 */
	public void printInorder() {
		System.out.print("\nInorder: [ ");
		printInorder(root);
		System.out.println("]");
	}

	/**
	 * print root -> left -> right
	 */
	public void printPreorder() {
		System.out.print("\nPreorder: [ ");
		printPreorder(root);
		System.out.println("]");
	}

	/**
	 * print left -> right -> root
	 */
	public void printPostorder() {
		System.out.print("\nPostorder: [ ");
		printPostorder(root);
		System.out.println("]");
	}

	/**
	 * print preorder traversal recursively
	 * 
	 * @param curr - current node to print preorder
	 */
	private void printPreorder(Node curr) {
		if (curr == null)
			return;
		System.out.print(curr.value + " ");
		printPreorder(curr.left);
		printPreorder(curr.right);
	}

	/**
	 * print postorder traversal recursively
	 * 
	 * @param curr - current node to print postorder
	 */
	private void printPostorder(Node curr) {
		if (curr == null)
			return;
		printPostorder(curr.left);
		printPostorder(curr.right);
		System.out.print(curr.value + " ");
	}

	/**
	 * print inorder traversal recursively
	 * 
	 * @param curr - current node to print inorder
	 */
	private void printInorder(Node curr) {
		if (curr == null)
			return;
		printInorder(curr.left);
		System.out.print(curr.value + " ");
		printInorder(curr.right);
	}

	/**
	 * print a level order traversal: in the order at which the elements were added
	 */
	public void printLevelOrder() {
		System.out.print("\nLevel Order: [ ");

		if (root != null) {
			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node current = queue.pop();

				System.out.print(current.value + " ");

				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
		}
		System.out.println("]");
	}

	/*
	 * clear the tree
	 */
	public void clear() {
		root = null;
	}

	/**
	 * insert at the first available spot
	 * 
	 * @param value - the value we want to insert
	 */
	public abstract void insert(int value);

	/**
	 * delete a value from the tree
	 * 
	 * @param value - the value we want to delete
	 */
	public abstract void delete(int value);

	/**
	 * remove the value at the root and get the value
	 * 
	 * @return the value of the root
	 */
	public abstract int pop();

	/**
	 * checks if the tree contains a value
	 * 
	 * @return true if the tree contains the specified value
	 */
	public abstract boolean contains(int value);
}
