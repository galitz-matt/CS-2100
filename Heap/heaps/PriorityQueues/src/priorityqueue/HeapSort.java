package priorityqueue;

public class HeapSort {
	
	public static <T extends Comparable<T>> void heapSort(T[] list) {
		MinHeap<T> mh = new MinHeap<T>();
		
		for (T item : list) {
			mh.push(item);
		}
		for (int i = 0; i < list.length; i++) {
            list[i] = mh.poll();
		}
	}
	
}
