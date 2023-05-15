package hash;

public class HashTable<K,V> implements Map<K,V>{

	
	/* The array of objects and related things */
	public ListNode<K,V>[] table;
	private static int INITIAL_CAP = 10;
	private int capacity;
	private int size;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		table = (ListNode<K, V>[]) new ListNode[INITIAL_CAP];
		capacity = INITIAL_CAP;
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int initialCapacity) {
		table = (ListNode<K,V>[]) new ListNode[initialCapacity];
		capacity = initialCapacity;
		size = 0;
	}
	
	public int getIndex(K key) {
		int index = key.hashCode() % capacity;
		if (index < 0 ) { 
			return index * -1;
		}
		return index;
	}
	
	@Override
	public void insert(K key, V value) {
		int index = getIndex(key);
		ListNode<K,V> newNode = new ListNode<K,V>(new HashNode<K,V>(key, value));
		ListNode<K,V> top = table[index];
		
		while (top != null) {
			if (top.data.getKey().equals(key)) {
				top.data.setValue(value);
				return;
			}
			top = top.next;
		}
		size++;
		top = table[index];
		newNode.next = top;
		table[index] = newNode;
		
		if (((float) size / capacity) >= 0.8) {
			ListNode<K,V>[] temp = table;
			table = (ListNode<K,V>[]) new ListNode[capacity * 2];
			capacity *= 2;
			size = 0;
			
			for (int i = 0; i < capacity; i++) {
				table[i] = null;
			}
			for (ListNode<K, V> topNode : temp) {
				while (topNode != null) {
					insert(topNode.data.getKey(), topNode.data.getValue());
					topNode = topNode.next;
				}
			}
		}
	}

	@Override
	public V retrieve(K key) {
		int index = getIndex(key);
		ListNode<K,V> top = table[index];
		
		while (top != null) {
			if (key.equals(top.data.getKey())) {
				return top.data.getValue();
			}
			top = top.next;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return retrieve(key) != null;
	}

	@Override
	public void remove(K key) {
		int index = getIndex(key);
		ListNode<K,V> top = table[index];
		ListNode<K,V> prev = null;
		
		while (top != null) {
			if (top.data.getKey().equals(key)) {
				break;
			}
			prev = top;
			top = top.next;
		}
		
		if (top == null) {
			return;
		}
		if (prev != null) {
			prev.next = top.next;
		}
		else {
			table[index] = top.next;
		}
		size--;
		return;
	}
	
//	public String toString() {
//		String s = "{";
//		boolean begin = true;
//		for (int i = 0; i < table.length; i++) {
//			if (table[i] != null) {
//				if (begin == true) {
//					s += table[i].data.getKey() + "=" + table[i].data.getValue();
//					begin = false;
//				}
//				else {
//					s += ", " + table[i].data.getKey() + "=" + table[i].data.getValue();
//				}
//			}
//		}
//		s += "}";
//		return s;
//	}
	
}

class ListNode<T,E> {
	public HashNode<T,E> data;
	public ListNode<T,E> next;
	
	public ListNode() {
		data = null;
		next = null;
	}
	
	public ListNode(HashNode<T,E> node) {
		data = node;
		next = null;
	}
}
