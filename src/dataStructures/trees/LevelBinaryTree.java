package dataStructures.trees;

import java.util.LinkedList;

/**
 * class that represents a binary tree that is ordered by levels. Every new
 * element goes to the first available spot. The order is called Level Order
 * 
 * @author Zayed
 *
 */
public class LevelBinaryTree extends BinaryTree {

	@Override
	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}

		LinkedList<Node> queue = new LinkedList<Node>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.pop();

			if (current.left == null) {
				current.left = new Node(value);
				return;
			} else
				queue.add(current.left);
			if (current.right == null) {
				current.right = new Node(value);
				return;
			} else
				queue.add(current.right);
		}
	}

	@Override
	public void delete(int value) {
		if (root == null)
			throw new NullPointerException("Tree is empty. There is no root.");

		if (root.value == value && root.left == null && root.right == null) {
			root = null;
			return;
		}

		Node toDelete = null;

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);

		Node current = null;
		while (!queue.isEmpty()) {
			current = queue.pop();

			if (current.value == value)
				toDelete = current;

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		if (toDelete != null) {
			int val = current.value;
			deleteNode(current);
			toDelete.value = val;
		}
	}

	/**
	 * delete the specified target node
	 * 
	 * @param target - node to be deleted
	 */
	private void deleteNode(Node target) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.pop();

			if (current == target) {
				current = null;
				return;
			}

			if (current.left != null)
				if (current.left == target) {
					current.left = null;
					return;
				} else
					queue.add(current.left);

			if (current.right != null)
				if (current.right == target) {
					current.right = null;
					return;
				} else
					queue.add(current.right);
		}
	}

	@Override
	public boolean contains(int value) {
		if (root == null)
			throw new NullPointerException("Tree is empty. There is no head.");

		LinkedList<Node> queue = new LinkedList<Node>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.pop();

			if (current.value == value)
				return true;

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		return false;
	}
}