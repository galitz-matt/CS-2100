package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	private ArrayList<T> heap;
	
	public MinHeap() { 
		heap = new ArrayList<T>();
		heap.add(null);
	}
	
	public MinHeap(ArrayList<T> data) {
		heap = new ArrayList<T>();
		heap.add(null);
		for (T item : data) {
			heap.add(item);
		}
		heapify();
		
	}
	
	private void heapify() {
		for (int i = 0; i <= size(); i++) {
			percolateUp(i);
		}
	}
	
	private void percolateUp(int index) {
		if (index <= 1) { 
			return;
		}
		int si = index / 2;
		
		if (heap.get(index).compareTo(heap.get(si)) < 0) {
			swap(si, index);
			percolateUp(si);
		}
	}
	
	private void percolateDown(int index) {
		if (index > size() / 2 && index <= size()) { 
			return;
		}
		
		int si;
		int leftIndex = index * 2;
		int rightIndex = (index * 2) + 1;
		
		if (leftIndex <= size() && rightIndex <=size()){
			if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) < 0) {
				si = leftIndex;
			}
			else {
				si = rightIndex;
			}
			if (heap.get(si).compareTo(heap.get(index)) < 0) {
				swap(si, index);
				percolateDown(si);
			}
		}
		else if (leftIndex > size()) {
			return;
		}
		else {
			if (heap.get(leftIndex).compareTo(heap.get(index)) < 0) {
				swap(leftIndex, index);
				percolateDown(leftIndex);
			}
		}
	}
	
	@Override
	public void push(T data) {
		heap.add(data);
		percolateUp(size());
	}

	@Override
	public T poll() {
		if (size() == 0) { 
			return null;
		}
		T polling = peek();
		heap.set(1, heap.get(size()));
		heap.remove(size());
		percolateDown(1);
		return polling;
	}

	@Override
	public T peek() {
		return heap.get(1);
	}
	
	@Override
	public int size() {
		return heap.size() - 1;
	}
	
	private void swap(int index1, int index2) {
		T temp;
		temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	
}


