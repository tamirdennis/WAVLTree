/**
 *
 * WAVLTree
 *
 * An implementation of a WAVL Tree with distinct integer keys and info
 *
 */

public class WAVLTree {
	private WAVLNode root;
	private int size;
	private WAVLNode min;
	private WAVLNode max;
	private final WAVLNode external = createExternalNode();
	/**
	 * public boolean empty()
	 *
	 * returns true if and only if the tree is empty
	 *
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * public String search(int k)
	 *
	 * returns the info of an item with key k if it exists in the tree
	 * otherwise, returns null
	 */
	public String search(int key) {
		WAVLNode node = findNearestNode(key, root);
		if (node == null || node.key != key) {
			return null;
		}

		return node.info;
	}

	/**
	 * public int insert(int k, String i)
	 *
	 * inserts an item with key k and info i to the WAVL tree. the tree must
	 * remain valid (keep its invariants). returns the number of rebalancing
	 * operations, or 0 if no rebalancing operations were necessary. returns -1
	 * if an item with key k already exists in the tree.
	 */
	public int insert(int k, String i) {
		return 42; // to be replaced by student code
	}

	/**
	 * public int delete(int k)
	 *
	 * deletes an item with key k from the binary tree, if it is there; the tree
	 * must remain valid (keep its invariants). returns the number of
	 * rebalancing operations, or 0 if no rebalancing operations were needed.
	 * returns -1 if an item with key k was not found in the tree.
	 */
	public int delete(int k) {
		return 42; // to be replaced by student code
	}

	private WAVLNode findNearestNode(int key, WAVLNode node) {
		if (node == null) {
			return null;
		}

		while (true) {
			if (node.key == key) {
				return node;
			}

			if (node.key > key) {
				if (node.left.rank == -1) {
					return node;
				}
				node = node.left;
			} else {
				if (node.right.rank == -1) {
					return node;
				}
				node = node.right;
			}
		}
	}
	
	private WAVLNode findNearestNodeRecursive(int key, WAVLNode node){
		if(node == null){
			return null;
		}
		
		if(node.key == key){
			return node;
		}
		
		if(node.key > key){
			if(node.left.rank == -1){
				return node;
			}
			
			return findNearestNodeRecursive(key, node.left);
		}
		
		if(node.right.rank == -1){
			return node;
		}
		
		return findNearestNodeRecursive(key, node.right);
		
	}
	/**
	 * public String min()
	 *
	 * Returns the info of the item with the smallest key in the tree, or null
	 * if the tree is empty
	 */
	public String min() {
		return min.info;
	}

	/**
	 * public String max()
	 *
	 * Returns the info of the item with the largest key in the tree, or null if
	 * the tree is empty
	 */
	public String max() {
		return max.info;
	}

	/**
	 * public int[] keysToArray()
	 *
	 * Returns a sorted array which contains all keys in the tree, or an empty
	 * array if the tree is empty.
	 */
	public int[] keysToArray() {
		if (empty()) {
			return new int[0];
		}

		int[] keys = new int[size];
		keysToArrayRecursive(root, keys, 0);
		return keys;
	}

	private int keysToArrayRecursive(WAVLNode node, int[] array, int index) {
		if (node.rank == -1) {
			return index;
		}

		index = keysToArrayRecursive(node.left, array, index);

		array[index++] = node.key;

		return keysToArrayRecursive(node.right, array, index);
	}

	/**
	 * public String[] infoToArray()
	 *
	 * Returns an array which contains all info in the tree, sorted by their
	 * respective keys, or an empty array if the tree is empty.
	 */
	public String[] infoToArray() {
		if (empty()) {
			return new String[0];
		}

		String[] arr = new String[size];
		infoToArrayRecursive(root, arr, 0);
		return arr;
	}

	private int infoToArrayRecursive(WAVLNode node, String[] array, int index) {
		if (node.rank == -1) {
			return index;
		}

		index = infoToArrayRecursive(node.left, array, index);

		array[index++] = node.info;

		return infoToArrayRecursive(node.right, array, index);
	}

	private void promote(WAVLNode node) {
		if(node == null || node.rank == -1){
			return;
		}
		
		node.rank++;
	}

	private void demote(WAVLNode node) {
		if(node == null || node.rank == -1){
			return;
		}
		
		node.rank--;
	}

	private void leftRotate(WAVLNode node) {
		
	}

	private void rightRotate(WAVLNode node) {

	}

	private void leftRightRotate(WAVLNode node) {

	}

	private void rightLeftRotate(WAVLNode node) {

	}

	/**
	 * public int size()
	 *
	 * Returns the number of nodes in the tree.
	 *
	 * precondition: none postcondition: none
	 */
	public int size() {
		return size;
	}

	/**
	 * public class WAVLNode
	 *
	 * If you wish to implement classes other than WAVLTree (for example
	 * WAVLNode), do it in this file, not in another file. This is an example
	 * which can be deleted if no such classes are necessary.
	 */
	private class WAVLNodeBase {
		public int rank = -1;
	}

	public WAVLNode createExternalNode() {
		return new WAVLNode(0, null, -1);
	}
	
	private class WAVLNode extends WAVLNodeBase {
		public WAVLNode(int key, String info){
			this(key, info, 0);
		}
		
		public WAVLNode(int key, String info, int rank) {
			this.parent = null;
			this.left = external;
			this.right = external;
			this.rank = 0;
			this.key = key;
			this.info = info;
		}
		
		
		public WAVLNode parent;
		public WAVLNode left;
		public WAVLNode right;
		public int key;
		public String info;

	}

}
