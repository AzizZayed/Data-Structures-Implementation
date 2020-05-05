package dataStructures.trees;

/**
 * This is a tree where every left node is smaller than it's parent node and every
 * right node is bigger than its parent node. This order is called Inorder.
 * 
 * @author Zayed
 *
 */
public class BinarySearchTree extends BinaryTree {

	@Override
	public void insert(int value) {
		if (root == null)
			root = new Node(value);
		else
			insert(root, value);
	}

	/**
	 * Insert in binary search tree, left nodes always smaller
	 * 
	 * @param current - current node to attempt inserting the value
	 * @param value   - the value we want to insert in the tree
	 */
	private void insert(Node current, int value) {
		if (value < current.value)
			if (current.left == null)
				current.left = new Node(value);
			else
				insert(current.left, value);
		else if (value > current.value)
			if (current.right == null)
				current.right = new Node(value);
			else
				insert(current.right, value);
	}

	@Override
	public void delete(int value) {
		if (root == null)
			throw new NullPointerException("Tree is empty. There is no root.");
		root = removeNode(root, value);
	}

	/**
	 * remove the node with the specified key
	 * 
	 * @param current - the current node we are recursively removing from
	 * @param value   - the value we want to remove
	 * @return
	 */
	private Node removeNode(Node current, int value) {
		/* Base Case: If the tree is empty */
		if (current == null)
			return current;

		if (value < current.value)
			current.left = removeNode(current.left, value);
		else if (value > current.value)
			current.right = removeNode(current.right, value);
		else {
			if (current.left == null)
				return current.right;
			else if (current.right == null)
				return current.left;

			int successor = getInorderLast(current.right).value;
			current.value = successor;
			current.right = removeNode(current.right, successor);
		}
		return current;
	}

	/**
	 * get the last left node of the given tree
	 * 
	 * @param current - given tree
	 * @return the last left node
	 */
	private Node getInorderLast(Node current) {
		if (current.left != null)
			return getInorderLast(current.left);
		return current;
	}

	@Override
	public boolean contains(int value) {
		if (root == null)
			throw new NullPointerException("Tree is empty. There is no root.");
		return contains(root, value);
	}

	/**
	 * check if node children contains the value
	 * 
	 * @param current - the node we want to test, we test its children too
	 * @param value   - the value we are looking for
	 * @return true if the value is found
	 */
	private boolean contains(Node current, int value) {
		if (current.value == value)
			return true;

		if (value < current.value)
			if (current.left != null)
				return contains(current.left, value);
			else if (current.right != null)
				return contains(current.right, value);
		return false;
	}
}
