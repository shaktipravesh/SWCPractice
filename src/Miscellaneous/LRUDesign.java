package Miscellaneous;


//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
 int key, value;
 Node next, pre;

 Node(int key, int value) {
     this.key = key;
     this.value = value;
     next = pre = null;
 }
}

public class LRUDesign {

 public static void main(String[] args) throws IOException {
     BufferedReader read =
         new BufferedReader(new InputStreamReader(System.in));

     int t = Integer.parseInt(read.readLine());

     while (t-- > 0) {

         int capacity = Integer.parseInt(read.readLine());
         int queries = Integer.parseInt(read.readLine());
         LRUCache cache = new LRUCache(capacity);
         String str[] = read.readLine().trim().split(" ");
         int len = str.length;
         int itr = 0;

         for (int i = 0; (i < queries) && (itr < len); i++) {
             String queryType = str[itr++];
             if (queryType.equals("SET")) {
                 int key = Integer.parseInt(str[itr++]);
                 int value = Integer.parseInt(str[itr++]);
                 cache.set(key, value);
             }
             if (queryType.equals("GET")) {
                 int key = Integer.parseInt(str[itr++]);
                 System.out.print(cache.get(key) + " ");
             }
         }
         System.out.println();
     }
 }
}
//} Driver Code Ends
/*
class Node
{
 int key, value;
 Node next, pre;

 Node(int key, int value)
 {
     this.key = key;
     this.value = value;
     next = pre = null;
 }
}
*/

class LRUCache {
 private static Map<Integer, Node> hsMap;
 private static int capacity, count;
 private static Node head, tail;

 LRUCache(int cap) {
     // Intialize the cache capacity with the given
     // cap
 }

 // This method works in O(1)
 public static int get(int key) {
	return key;
     // your code here
 }

 // This method works in O(1)
 public static void set(int key, int value) {
     // your code here
 }
}
