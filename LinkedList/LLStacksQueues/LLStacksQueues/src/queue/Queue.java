package queue;

/* You SHOULD use your custom built linked list for this */
import list.LinkedList;

/**
 * A Linked-List based Queue
 * @author Mark Floryan
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{

	private LinkedList<T> list;
	
	public Queue(){
		list = new LinkedList<T>();
	}
	
	public int size() { 
		return this.list.size();
	}
	
	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		list.insertAtHead(data);
	}
	
	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue(){
		if (this.size() == 0) throw new NullPointerException();
		return list.removeAtHead();
		
	}
	
	
}
