package priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Spliterator;

public class MyPriorityQueue {

	public static void main(String[] args) {

		Example example = new Example();
		example.myExample();

		// Creating a list of Integers
		List<Integer> list = Arrays.asList(5, -10, 7, -18, 23);

		System.out.println("The sorted stream according " + "to provided Comparator is : ");

		// Displaying the list of Strings in
		// reverse order after sorting
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		list.sort(Comparator.naturalOrder());

		// Creating an empty PriorityQueue
		PriorityQueue<String> queue = new PriorityQueue<String>();

		// Use add() method to add elements into the Queue

		queue.add("Welcome");
		queue.add("To");
		queue.add("Geeks");
		queue.add("For");
		queue.add("Geeks");

		// Displaying the PriorityQueue
		System.out.println("Initial PriorityQueue: " + queue);

		// Fetching and removing the element at the head of the queue
		System.out.println("The element at the head of the" + " queue is: " + queue.remove());

		// Displaying the Queue after the Operation
		System.out.println("Final PriorityQueue: " + queue);

		// Creating an empty PriorityQueue
		PriorityQueue<Integer> queueInt = new PriorityQueue<Integer>();

		// Use add() method to add elements into the Queue
		queueInt.add(10);
		queueInt.add(15);
		queueInt.add(30);
		queueInt.add(20);
		queueInt.add(5);

		// Displaying the PriorityQueue
		System.out.println("Initial PriorityQueue: " + queueInt);

		// Fetching the element at the head of the queue
		System.out.println("The element at the head of the" + " queue is: " + queueInt.poll());

		// Displaying the Queue after the Operation
		System.out.println("Final PriorityQueue: " + queueInt);

		// Creating an empty PriorityQueue Test Offer
		PriorityQueue<String> queueOffer = new PriorityQueue<String>();

		// Use add() method to add elements into the Queue
		queueOffer.add("Welcome");
		queueOffer.add("To");
		queueOffer.add("Geeks");
		queueOffer.add("4");
		queueOffer.add("Geeks");

		// Displaying the PriorityQueue
		System.out.println("Initial PriorityQueue: " + queueOffer);

		// Inserting using offer()
		queueOffer.offer("The");
		queueOffer.offer("Priority");
		queueOffer.offer("Class");

		// Displaying th final Queue
		System.out.println("Priority queue after Insertion: " + queueOffer);

		PriorityQueue<Integer> queueOfferInt = new PriorityQueue<Integer>();

		// Use add() method to add elements into the Queue
		queueOfferInt.add(10);
		queueOfferInt.add(15);
		queueOfferInt.add(30);
		queueOfferInt.add(20);
		queueOfferInt.add(5);

		// Displaying the PriorityQueue
		System.out.println("Initial PriorityQueue: " + queueOfferInt);

		// Inserting using offer()
		queueOfferInt.offer(100);
		queueOfferInt.offer(120);
		queueOfferInt.offer(150);

		// Displaying th final Queue
		System.out.println("Priority queue after Insertion: " + queueOfferInt);

		// create an PriorityQueue which going to
		// contain list of names
		PriorityQueue<String> queueSpliterator = new PriorityQueue<String>();

		// Add String object to queue
		queueSpliterator.add("Aman");
		queueSpliterator.add("Amar");
		queueSpliterator.add("Sanjeet");
		queueSpliterator.add("Josh");
		queueSpliterator.add("Ron");
		queueSpliterator.add("Kevin");

		// using spliterator() method
		Spliterator<String> spt = queueSpliterator.spliterator();

		// print result from Spliterator
		System.out.println("list of String Object:");

		// forEachRemaining method of Spliterator
		spt.forEachRemaining((n) -> print(n));

		
	      // Creating an empty PriorityQueue 
        PriorityQueue<String> queueTmove = new PriorityQueue<String>(); 
  
        // Use add() method to add elements into the Queue 
        queueTmove.add("Welcome"); 
        queueTmove.add("To"); 
        queueTmove.add("Geeks"); 
        queueTmove.add("For"); 
        queueTmove.add("Geeks"); 
  
        // Displaying the PriorityQueue 
        System.out.println("Initial PriorityQueue: " + queueTmove); 
  
        // Removing elements using remove() method 
        queueTmove.remove("Geeks"); 
        queueTmove.remove("For"); 
        queueTmove.remove("Welcome"); 
  
        // Displaying the PriorityQueue after removal 
        System.out.println("PriorityQueue after removing "
                           + "elements: " + queueTmove); 
		

		
		
		
		
		
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

	public static void print(String s) {
		System.out.println("Student Name: " + s);
	}

}

class Example {
	public void myExample() {
		Scanner in = new Scanner(System.in);
		// Creating Priority queue constructor having
		// initial capacity=5 and a StudentComparator instance
		// as its parameters
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());

		// Invoking a parameterized Student constructor with
		// name and cgpa as the elements of queue
		Student student1 = new Student("Nandini", 3.2);

		// Adding a student object containing fields
		// name and cgpa to priority queue
		pq.add(student1);
		Student student2 = new Student("Anmol", 3.1);
		pq.add(student2);
		Student student3 = new Student("Palak", 4.0);
		pq.add(student3);
		Student student4 = new Student("Suhasini", 2.0);
		pq.add(student4);
		// Printing names of students in priority order,poll()
		// method is used to access the head element of queue
		System.out.println("Students served in their priority order");

		while (!pq.isEmpty()) {
			Student pStudent = pq.poll();
			System.out.println(pStudent.getName() + ": " + pStudent.cgpa);
		}
		in.close();
	}
}

class StudentComparator implements Comparator<Student> {

	// Overriding compare()method of Comparator
	// for descending order of cgpa
	public int compare(Student s1, Student s2) {
		if (s1.cgpa > s2.cgpa)
			return 1;
		else if (s1.cgpa < s2.cgpa)
			return -1;
		return 0;
	}
}

class Student {
	public String name;
	public double cgpa;

	// A parameterized student constructor
	public Student(String name, double cgpa) {

		this.name = name;
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}
}
