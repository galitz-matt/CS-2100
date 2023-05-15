package main;

import java.util.Vector;

public class BigOh {
	
	public static boolean binarySearch(int[] a, int item) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int pivot = (high + low) / 2;
			if (item > a[pivot]) { low = pivot + 1; }
			else if (item < a[pivot]) { high = pivot - 1; }
			else { return true; }
		}
		return false;
	}
	
	public static int max(int[] a) {
		int globalMax = a[0];
		int max;
		for (int num : a) {
			max = num;
			if (max > globalMax) { globalMax = max; }
		}
		return globalMax;
	}
	
	public static int multipleBinarySearch(int[] a) {
		int count = 0;
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			n += 1;
			if (binarySearch(a, n) == true) { count += 1; }
		}
		return count;
	}
	
	public static int allPairs(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((a[i] + a[j]) % 5 == 0) { count += 1; }
			}
		}
		return count;
	}
	
	public static int allTriads(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					if (a[i] + a[j] == a[k]) { count += 1; };
				}
			}
		}
		return count;
	}
	
	public static void allSubsets(int[] a, int i, Vector<Integer> sol) {
		if(i >= a.length) {
			//Found another subset, but not printing because printing is really slow.\
			allSubsets(a, i+1, sol);
			sol.add(a[i]);
			allSubsets(a, i+1, sol);
			sol.remove(sol.size()-1);
		}
	}
}
