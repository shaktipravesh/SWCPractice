// StructsAndObjects.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;

struct Rectangle {
    int length;
    int breadth;
    Rectangle(){}
    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }
};

int area(Rectangle r);
void maxArea(Rectangle arr[], int n);

//User function Template for C++


int area(Rectangle r)
{
    return r.length * r.breadth;
}


void maxArea(Rectangle arr[], int n)
{

    int iMaxArea = 0;
    int iArea;
    for (int i = 0; i < n; i++) {
        iArea = area(arr[i]);
        if (iMaxArea < iArea)
            iMaxArea = iArea;
    }
    cout << iMaxArea << endl;
}

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Rectangle arr[101];
        for (int i = 0; i < n; i++) {
            int l, b;
            cin >> l >> b;
            Rectangle r(l, b);
            arr[i] = r;
        }
        maxArea(arr, n);
    }
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file

/*

https://practice.geeksforgeeks.org/problems/structs-and-objects/1/

CPP structs are more powerful than C structs as they are just classes with public data members.Here, we will create objects of a rectangle structand find the maximum area of a rectangle.

Input Format :
The first line of input contains T denoting the number of testcases.T testcases follow.Each testcase contains two lines of input.The first line contains N denoting the number of rectangle objects to be created.The next line contains 2 * N elements denoting the length and breadth of N rectangles.

Output Format :
For each testcase, in a new line, print the maximum area.

Your Task :
Since this is a function problem, you don't need to take any input. Just complete the area and maxArea functions.

Constraints :
    1 <= T <= 100
    1 <= length <= 100
    1 <= breadth <= 100

    Examples :
    Input :
    1
    4
    9 8 7 6 5 4 3 2
    Output :
    72

    Explanation :
    Testcase1 : We have N = 4, so 4 rectangle objects.
    Obj1(9, 8), Obj2(7, 6), Obj3(5, 4), Obj4(3, 2)
    Now area is length* breadth.So 9 * 8 = 72 gives maxArea

    * *For More Input / Output Examples Use 'Expected Output' option * *


    */