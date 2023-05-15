package queue;

import java.util.LinkedList;
import java.util.concurrent.locks.*;
/**
 * A Linked-List based Queue
 * Is concurrent (i.e., can modify front and back in parallel)
 *
 * @param <T>
 */
public class ConcurrentQueue<T> implements IQueue<T>{

	private LinkedList<T> queue;
	private Lock queueLock;
	private Condition nonEmptyCondition;
	
	public ConcurrentQueue(){
		queue = new LinkedList<T>();
		queueLock = new ReentrantLock();
		nonEmptyCondition = queueLock.newCondition();
	}
	
	public int size() { 
		return queue.size();
	}
	
	public void enqueue(T data) {
		queueLock.lock();
		
		try {
			queue.addLast(data);
			nonEmptyCondition.signalAll();
		}
		finally {
			queueLock.unlock();
		}
	}
	
	public T dequeue() {	
		queueLock.lock();
		
		try {
			while (size() == 0) {
				nonEmptyCondition.await();
			}
		} 
		catch (InterruptedException e) {}
		finally {
			queueLock.unlock();
		}
		return queue.removeFirst();
	}
	
	
}
