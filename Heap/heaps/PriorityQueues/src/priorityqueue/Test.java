package priorityqueue;

public class Test {
	public static void main(String[] args) {
		MinHeap<Integer> mh = new MinHeap<Integer>();
		VectorHeap<Integer> vmh = new VectorHeap<Integer>();
		int NUM = 100000;
		long time;
		
		time = System.currentTimeMillis();
		for (int i = NUM; i >= 0; i--) {
			mh.push(i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("MinHeap push(): " + time + " ms");
		
		time =System.currentTimeMillis();
		for (int i = NUM; i >= 0; i--) {
			vmh.push(i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("VectorHeap push(): " + time + " ms");
		
		time = System.currentTimeMillis();
		for (int i = 0; i <= mh.size(); i++) {
			mh.poll();
		}
		time = System.currentTimeMillis() - time;
		System.out.println("MinHeap poll(): " + time + " ms");
		
		time = System.currentTimeMillis();
		for (int i = 0; i <= vmh.size(); i++) {
			vmh.poll();
		}
		time = System.currentTimeMillis() - time;
		System.out.println("VectorHeap poll(): " + time + " ms");
	}
}
