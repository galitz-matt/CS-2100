package list;

public class LinkedList<T> implements List<T>{

	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		this.size = 0;
		this.head = new ListNode<T>(null);
		this.tail = new ListNode<T>(null);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void insertAtTail(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
	}
	
	public void insertAtHead(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		size++;
	}
	
	public void insertAt(int index, T data) {
		ListIterator<T> it = new ListIterator(head.next);
		ListNode<T> newNode = new ListNode<T>(data);
		for (int i = 0; i < index; i++) it.moveForward();
		newNode.next = it.curNode;
		newNode.prev = it.curNode.prev;
		it.curNode.prev.next = newNode;
		it.curNode.prev = newNode;
		size++;
	}
	
	public void insert(ListIterator<T> it, T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.prev = it.curNode;
		newNode.next = it.curNode.next;
		it.curNode.next.prev = newNode;
		it.curNode.next = newNode;
		size++;
	}
	
	public T removeAtTail() {
		if (size == 0) return null;
		T nodeData = tail.prev.getData();
		tail.prev.prev.next = tail;
		tail.prev = tail.prev.prev;
		size--;
		return nodeData;
	}
	
	public T removeAtHead() {
		if (size == 0) return null;
		T nodeData = head.next.getData();
		head.next.next.prev = head;
		head.next = head.next.next;
		size--;
		return nodeData;
	}
	
	public T remove(ListIterator<T> it) {
		try {
			T nodeData = it.curNode.getData();
			it.curNode.next.prev = it.curNode.prev;
			it.curNode.prev.next = it.curNode.next;
			it.moveForward();
			size--;
			return nodeData; 
		}
		catch (Exception nullPointerException) { return null; }
	}

	public int find(T data) {
		ListIterator<T> it = front();
		for (int i = 0; i < size; i++) {
			if (it.curNode.getData().equals(data)) { return i; }
			it.moveForward();
		}
		return -1;
	}
	
	public T get(int index) { 
		if (index >= size)
			return null;
		ListIterator<T> it = new ListIterator<T>(head);
		for(int i = 0; i <= index; i++) it.moveForward();
		return it.curNode.getData();
	}
	
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	 
	public ListIterator<T> front(){ 
		ListIterator<T> it = new ListIterator<T>(head.next);
		return it;
	}

	public ListIterator<T> back(){
		ListIterator<T> it = new ListIterator <T>(tail.prev);
		return it;
	}
	
}
