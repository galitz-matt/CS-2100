package tree;

/**
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		curNode = super.insert(data, curNode);
		updateHeight(curNode);
		return balance(curNode);	
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		curNode = super.remove(data, curNode);
		 if (curNode == null) {
			    return null;
		}
		updateHeight(curNode);
		return balance(curNode);
	}
	
	private TreeNode<T> balance(TreeNode<T> curNode) {
		int bf = balanceFactor(curNode);
		if (bf < -1) {
			if (balanceFactor(curNode.left) <= 0) {
				curNode = rotateRight(curNode);
			}
			else {
				curNode.left = rotateLeft(curNode.left);
				curNode = rotateRight(curNode);
			}
		}
		if (bf > 1) {
			if (balanceFactor(curNode.right) >= 0)  {
				curNode = rotateLeft(curNode);
			}
			else {
				curNode.right = rotateRight(curNode.right);
				curNode = rotateLeft(curNode);
			}
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		TreeNode<T> leftChild = curNode.left;
		curNode.left = leftChild.right;
		leftChild.right = curNode;
		updateHeight(curNode);
		updateHeight(leftChild);
		return leftChild;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> rightChild = curNode.right;
		curNode.right = rightChild.left;
		rightChild.left = curNode;
		updateHeight(curNode);
		updateHeight(rightChild);
		return rightChild;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		return height(node.right) - height(node.left);
	}
	
	/*AUXILIARY METHODS*/
	
	// returns height of node
	protected int height(TreeNode<T> node) {
		if (node != null) {
			return node.height;
		}
		return -1;
	}
	
	// Updates height of node
	private void updateHeight(TreeNode<T> node) {
		if (height(node.left) > height(node.right)) {
			node.height = height(node.left) + 1;
		}
		else {
			node.height = height(node.right) +1;
		}
	}
	
}
