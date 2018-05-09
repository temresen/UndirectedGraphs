package UndirectedGraphs;

import java.util.NoSuchElementException;

public class Queue {
	private Node first;    // beginning of queue
	private Node last;     // end of queue
	private int N;         // number of elements on queue

	private static class Node {
		private int item;
		private Node next;
	}
	public Queue() {
		first = null;
		last  = null;
		N = 0;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;     
	}

	public void enqueue(int child) {
		Node oldlast = last;
		last = new Node();
		last.item = child;
		last.next = null;
		if (isEmpty()) first = last;
		else           oldlast.next = last;
		N++;
	}
	public int dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		int item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null; 
		return item;
	}


}