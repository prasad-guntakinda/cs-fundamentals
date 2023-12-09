# Carry Forward Technique

###### Revision-1================

- It is an algorithm used to solve problems where the solution to one sub-problem depends on the solution to the previous sub-problem. 
- The idea is to keep track of(carry forward) the solution to the previous sub-problem and use it to solve the current sub-problem.
- The carry forward technique is a powerful algorithm that can be used to solve a wide variety of problems.

#### Examples:
1. problem of finding the maximum sum of a contiguous sub-array in an array.
        
        - The solution to this problem is to keep track of the maximum sum of a contiguous subarray that has been found so far.
        - When processing the current element in the array, we can either add it to the current maximum sum or start a new contiguous subarray.
2. Another example is the problem of finding the longest common subsequence of two strings. 
        
        - The solution to this problem is to keep track of the longest common subsequence of the two strings that has been found so far. 
        - When processing the current characters in the two strings, we can either extend the current longest common subsequence or start a new longest common subsequence.




#### Problems:
1. **AG pairs:** You have given a string `str` with length of N having Uppercase English letters. You have to find how many times subsequence "AG" is there in the given string.
2. Given an array of N integers, return the length of the smallest sub-array which contains both max and min values of the array.
3. **Find all the leaders in array:** Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
4. Say you have an array, A, for which the ith element is the price of a given stock on day i.
   If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.Return the maximum possible profit.

5. Q3. You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.

6. Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

NOTE: The rightmost element is always a leader.

7. You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
   But the sum must not exceed B.
8. 

