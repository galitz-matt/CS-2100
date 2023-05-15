package vector;

public class Vector<T> implements List<T> {
	
	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Vector(){
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public int capacity() {
		return this.data.length;
	}
	
	public void add(Object o) {
		resize();
		this.data[this.size] = (T) o;
		this.size++;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(){
		T[] newVector = (T[])new Object[capacity() * 2];
		
		if (this.size == capacity()) {
			for (int i = 0; i < this.size; i++) {
				newVector[i] = this.data[i];
			}
			this.data = newVector;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.data =  (T[])new Object[capacity()];
		this.size = 0;
	}
	
	@Override
	public void insertAtTail(T data) {
		add(data);
	}

	@Override
	public void insertAtHead(T data) {
		T[] newVector = (T[])new Object[capacity()];
		
		if (this.size == capacity()) {
			newVector = (T[])new Object[capacity() * 2];
		}
		newVector[0] = data;
		for (int i = 0; i < this.size; i++) {
			newVector[i + 1] = this.data[i];
		}
		this.size++;
		this.data = newVector;
	}

	@Override
	public void insertAt(int index, T data) {
		T[] newVector = (T[])new Object[capacity()];
		
		if (this.size == capacity()) {
			newVector = (T[])new Object[capacity() * 2];
		}
		for (int i = 0; i < index; i++) {
			newVector[i] = this.data[i];
		}
		newVector[index] = data;
		for (int i = index + 1; i < this.size + 1; i++) {
			newVector[i] = this.data[i - 1];
		}
		this.size++;
		this.data = newVector;
	}

	@Override
	public T removeAtTail() {
		this.size--;
		return null;
	}

	@Override
	public T removeAtHead() {
		T[] newVector = (T[])new Object[capacity()];
		
		for (int i = 1; i < this.size; i++) {
			newVector[i - 1] = this.data[i];
		}
		this.data = newVector;
		this.size--;
		return null;
	}

	@Override
	public int find(T data) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public T get(int index) {
		if (index < capacity()) {
			return this.data[index];
		}
		return null;
	}

}
