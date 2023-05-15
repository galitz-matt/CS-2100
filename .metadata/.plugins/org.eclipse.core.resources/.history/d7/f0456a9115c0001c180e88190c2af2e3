package list;

import java.lang.System;
import java.lang.Math;

public class MethodTimer {
	
	public static int NUM_TESTS = 100000;
	public static int SIZE = 100000;
	
	public static void main(String[] args) {
		int rand;
		int randInd;
		long initial;
		long time;
		LinkedList<Integer> tempList;
		ListIterator<Integer> tempIt;
		
		/* insertAtTail */
		rand = (int) Math.floor(Math.random()*1000);
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) { 
			tempList.insertAtTail(rand);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("insertAtTail: " + time);
		
		/* insertAtHead */
		rand = (int) Math.floor(Math.random()*1000);
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.insertAtHead(rand);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("insertAtHead: " + time);
		
		/* insertAt */
		rand = (int) Math.floor(Math.random()*1000);
		randInd = (int) Math.floor(Math.random()*SIZE);
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.insertAt(randInd, rand);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("insertAt: " + time);
		
		/* insert */
		rand = (int) Math.floor(Math.random()*1000);
		randInd = (int) Math.floor(Math.random()*SIZE);
		tempList = generateList(SIZE);
		tempIt = tempList.front();
		for (int i = 0; i < randInd; i++) {
			tempIt.moveForward();
		}
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.insert(tempIt, rand);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("insert: " + time);
		
		/* removeAtTail */
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.removeAtTail();
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("removeAtTail: " + time);
		
		/* removeAtHead */
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.removeAtHead();
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("removeAtHead: " + time);
		
		/* remove */
		randInd = (int) Math.floor(Math.random()*SIZE);
		tempList = generateList(SIZE);
		tempIt = tempList.front();
		for (int i = 0; i < randInd; i++) {
			tempIt.moveForward();
		}
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.remove(tempIt);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("remove: " + time);
		
		/* find */
		rand = (int) Math.floor(Math.random()*1000);
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.find(rand);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("find: " + time);
		
		/* get */
		randInd = (int) Math.floor(Math.random()*SIZE);
		tempList = generateList(SIZE);
		initial = System.currentTimeMillis();
		for (int i = 0; i < NUM_TESTS; i++) {
			tempList.get(randInd);
		}
		time = System.currentTimeMillis() - initial;
		System.out.println("get: " + time);
	}
	
	public static LinkedList<Integer> generateList(int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.insertAtTail((int) Math.floor(Math.random()*1000));
		}
		return list;
	}
}
