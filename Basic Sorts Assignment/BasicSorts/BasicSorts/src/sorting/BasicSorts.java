package sorting;

public class BasicSorts {
	
	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static<T> void swap(T[] list, int i, int j) {
		// didn't use it
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "bubble sort"
	 * */
	public static<T extends Comparable<T>> void bubbleSort(T[] list) {
		T temp;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}
	
	/*
	 * Updates the elements of list to be in sorted order. Uses "insertion sort"
	 * */
	public static<T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				T temp = list[j+1];
				if (temp.compareTo(list[j]) < 0) {
					list[j+1] = list[j];
					list[j] = temp;
				}
			}
		}
//		for (int i = 1; i < list.length - 1; i++) {
//			T temp = list[i];
//			int j = i - 1;
//			while (j >= 0 && temp.compareTo(list[j]) < 0) {
//				list[j+1] = list[j];
//				j--;
//			}
//			list[j+1] = temp;
//		}
	}
	
}
