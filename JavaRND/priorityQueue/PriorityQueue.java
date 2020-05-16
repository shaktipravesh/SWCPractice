package priorityQueue;

import java.util.Iterator;

public class PriorityQueue {

	public static void main(String[] args) {
		// Creating empty priority queue
		java.util.PriorityQueue<String> pQueue = new java.util.PriorityQueue<String>();
		// PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		// Adding items to the pQueue using add()
		pQueue.add("C");
		pQueue.add("C++");
		pQueue.add("Java");
		pQueue.add("Python");

		// Printing the most priority element
		System.out.println("Head value using peek function:" + pQueue.peek());

		// Printing all elements
		System.out.println("The queue elements:");
		Iterator<String> itr = pQueue.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		// Removing the top priority element (or head) and
		// printing the modified pQueue using poll()
		pQueue.poll();
		System.out.println("After removing an element" + "with poll function:");
		Iterator<String> itr2 = pQueue.iterator();
		while (itr2.hasNext())
			System.out.println(itr2.next());

		// Removing Java using remove()
		pQueue.remove("Java");
		System.out.println("after removing Java with" + " remove function:");
		Iterator<String> itr3 = pQueue.iterator();
		while (itr3.hasNext())
			System.out.println(itr3.next());

		// Check if an element is present using contains()
		boolean b = pQueue.contains("C");
		System.out.println("Priority queue contains C " + "or not?: " + b);

		// Getting objects from the queue using toArray()
		// in an array and print the array
		Object[] arr = pQueue.toArray();
		System.out.println("Value in array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.println("Value: " + arr[i].toString());

	}

}
