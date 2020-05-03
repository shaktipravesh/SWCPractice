package algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ImplementingDijkstraSet1AdjacencyMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int iSource = 0;
			ArrayList<ArrayList<Integer>> list = new ArrayList<>(iSize);
			for(int i = 0; i < iSize; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(iSize);
				list.add(temp);
			}
			
			for(int i = 0; i < iSize; i++) {
				ArrayList<Integer> temp = list.get(i);
				for(int j = 0; j < iSize; j++) {
					temp.add(sc.nextInt());
				}
			}
			iSource = sc.nextInt();
			Solution.dijkstra(list, iSource, iSize);
			System.out.println();
		}
		sc.close();
	}

}


class Solution
{
    static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V)
    {
       ArrayList<Integer> iNodeList = new ArrayList<Integer>();
       boolean[] iVisitedNode = new boolean[V];
       int[] iDistace = new int[V];
       iNodeList.add(src);

       Collections.sort(iNodeList);
       for(int i = 0; i < iNodeList.size(); i++) {
    	   int iNum = iNodeList.get(i);
    	   int iValue = iNum /1000;
    	   int iIndex = iNum % 1000;
    	   if(iVisitedNode[iIndex] == false) {
    		   iDistace[iIndex] = iValue;
    		   iVisitedNode[iIndex] = true;
    		   ArrayList<Integer> tempArray = list.get(iIndex);
    		   addAllActiveNode(iNodeList, tempArray, V, iVisitedNode, iValue);
    	   }
       }
       printResult(iDistace);
    }

	private static void printResult(int[] iDistace) {
		for(int i = 0; i < iDistace.length; i++) {
			System.out.print(iDistace[i] + " ");
		}
		
	}

	private static void addAllActiveNode(ArrayList<Integer> iNodeList, ArrayList<Integer> tempArray, int V, boolean[] iVisitedNode, int iValue) {
		for(int i = 0; i < V; i++) {
			if(iVisitedNode[i] == false) {
				int iDistance = tempArray.get(i);
				if(iDistance == 0)
					iDistance = 1001;
		    	iNodeList.add((iValue + iDistance)*1000 + i);
			}
		}
		Collections.sort(iNodeList);
	}
}


/*
 * https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * 
 * Given a graph of V nodes represented in the form of the adjacency matrix. The
 * task is to find the shortest distance of all the vertex's from the source
 * vertex.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. The first line of each test case
 * contains an integer V denoting the size of the adjacency matrix and in the
 * next line are V*V space-separated values, which denote the weight of an edge
 * of the matrix (gr[i][j] represents the weight of an edge from ith node to jth
 * node). The third line of each test case contains an integer denoting the
 * source vertex s.
 * 
 * Output: For each test, case output will be V space-separated integers where
 * the ith integer denotes the shortest distance of the ith vertex from source
 * vertex.
 * 
 * Your task: You are required to complete the function Dijkstra() which takes 3
 * arguments. The first argument is the adjacency matrix (graph), the second
 * argument is the source vertex s and the third argument is V denoting the size
 * of the matrix. The function prints V space-separated integers where ith
 * integer denotes the shortest distance of the ith vertex from source vertex.
 * 
 * Constraints: 1 <= T <= 20 1 <= V <= 100 0 <= graph[i][j] <= 1000 0 <= s < V
 * 
 * Example: Input: 2 2 0 25 25 0 0 3 0 1 43 1 0 6 43 6 0 2
 * 
 * Output: 0 25 7 6 0
 * 
 * Explanation: Testcase 1: Shortest distance of source node 0 to 1 is 25, and
 * shortest distance of source to source is 0.
 * 
 * Note: You must assume that graph[i][j] = 0 means that the path from i to j
 * does not exist.
 */

//3
//2
//0 25 25 0
//0
//3
//0 1 43 1 0 6 43 6 0
//2
//3
//3 1 0 9 34 21 6 78 43
//1
