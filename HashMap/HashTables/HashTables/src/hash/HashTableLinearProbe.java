package hash;

import java.lang.Math;

public class HashTableLinearProbe<K,V> implements Map<K,V> {
	private HashNode<K, V>[] table;
	private int size;
	private double loadFactor = 0;
	private int elements = 0;
	private HashNode<K,V> sentinel;
	
	public HashTableLinearProbe() {
		table = (HashNode<K, V>[]) new HashNode[10];
		size = 0;
	}
	
	public HashTableLinearProbe(int initialCapacity) {
		table = (HashNode<K, V>[]) new HashNode[10];
		size = table.length;
		sentinel = new HashNode<K,V>(null, null);
	}
	
	public int hashFunction(K key) {
		int hashValue = Math.abs(key.hashCode()) % this.size;
		return hashValue;
	}
	
	@Override
	public void insert(K key, V value) {
		int index = hashFunction(key);
		while (index+1 != hashFunction(key)) {
			if (table[index] != null && table[index].getKey().equals(key)) {
				table[index].setValue(value);
				break;
			}
			else if (table[index] == null || table[index] == sentinel) {
				HashNode<K,V> newNode = new HashNode<K,V>(key, value);
				table[index] = newNode;
				elements++;
				break;
			}
			index = index++ % size;
		}
		loadFactor = elements / size;
		if (loadFactor > 0.75) {
			HashNode<K,V>[] oldTable = table.clone();
			table = new HashNode[size*2];
			for (int i = 0; i < oldTable.length; i++) {
				if (oldTable[i] != null || oldTable[i] != sentinel) {
					insert(oldTable[i].getKey(), oldTable[i].getValue());
				}
			}
		}
	}
	
	@Override
	public V retrieve(K key) {
		int tableLoca = hashFunction(key);
		if (key == null) {
			return null;
		}
		while (table[tableLoca] == sentinel || table[tableLoca] != null) {
			if (table[tableLoca] != sentinel && table[tableLoca].getKey().equals(key)) {
				return table[tableLoca].getValue();
			}
			tableLoca = tableLoca++ % size;
			if (tableLoca == hashFunction(key)) {
				break;
			}
		}
		return null;
	}
	
	@Override
	public boolean contains(K key) {
		return retrieve(key) != null;
	}
	
	@Override
	public void remove(K key ) {
		int tableLoca = hashFunction(key);
		while (table[tableLoca] != null) {
			if (table[tableLoca] != sentinel && table[tableLoca].getKey().equals(key)) {
				table[tableLoca] = sentinel;
				elements--;
				break;
			}
			tableLoca = tableLoca++ % size;
		}
	}
	
	public String toString() {
		String s = new String("{");
		for (int i = 0; i < size; i++) {
			if (table[i] != null) {
				s += table[i].toString();
			}
			if (i < size && table[i] != null) {
				s += ", ";
			}
		}
		s += "}";
		return s;
	}
	
	public static void main(String[] args) {
		
	}
}


