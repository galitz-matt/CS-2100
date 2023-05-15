package list;

public class ListIterator<T> {
	
	protected ListNode<T> curNode;
	
	public ListIterator(ListNode<T> curNode) {
		this.curNode = curNode;
	}
	
	public boolean isPastEnd() {
		if (curNode.getData()== null) 
			return true;
		return false;
	}
	
	public boolean isPastBeginning() {
		if (curNode.getData() == null) 
			return true;
		return false;
	}

	public T value() {
		if (isPastEnd() || isPastBeginning())
			return null;
		return curNode.getData();
	}
	
	public void moveForward() {
		curNode = curNode.next;
	}
	
	public void moveBackward() {
		curNode = curNode.prev;
	}
}
