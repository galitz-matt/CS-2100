package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, root);
	}
	
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		if (curNode == null) {
			return  new TreeNode<T>(data);
		}
		else if (data.compareTo(curNode.data) < 0) {
			curNode.left = insert(data, curNode.left);
		}
		else if (data.compareTo(curNode.data) > 0) {
			curNode.right = insert(data, curNode.right);
		}
		else;
		return curNode;
	}

	@Override
	public boolean find(T data) {
		return find(data, root);
	}
	
	private boolean find(T data, TreeNode<T> curNode) {
		if (curNode == null) {
			return false;
		}
		else if (data.compareTo(curNode.data) < 0) {
			return find(data, curNode.left);
		}
		else if (data.compareTo(curNode.data) > 0) {
			return find(data, curNode.right);
		}
		else {
			return true;
		}
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}
	
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		if (curNode == null) { 
			return null;
		}
		if (data.compareTo(curNode.data) < 0) {
			curNode.left = remove(data, curNode.left);
		}
		else if (data.compareTo(curNode.data) > 0) {
			curNode.right = remove(data, curNode.right);
		}
		else {
			if (curNode.left == null) {
				return curNode.right;
			}
			else if (curNode.right == null) {
				return curNode.left;
			}
			curNode = (TreeNode<T>) findMin(curNode.right);
			curNode.right = remove(data, curNode.right);
		}
		return curNode;
	}
	
	public T findMax() {
		return findMax(this.root);
	}
	
	private T findMax(TreeNode<T> curNode) {
		if (curNode.right == null) { return curNode.data; }
		return findMax(curNode.right);
	}
	
	public T findMin() {
		return findMin(this.root);
	}
	
	private T findMin(TreeNode<T> curNode) {
		if (curNode.left == null) { return curNode.data; }
		return findMin(curNode.left);
	}
}
