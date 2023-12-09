# Range Sum Query:
##### Revision-1=================
- The range sum query technique is a method for answering queries that ask for the sum of a range of elements in an array.
- The basic idea behind the range sum query technique is to precompute the sum of all the elements in the array.
- This can be done by creating a prefix sum array, which is an array where the ith element is equal to the sum of all the elements in the array from index 0 to index i.
- `prefixSum[i] = prefixSum[0]+ prefixSum[1]+ .....+ prefixSum[i-1] + prefixSum[i]`

### How to create a Prefix Sum Array?

```java
     int[] input = {1,5,3,4,6,7,10};
     int[] prefixSum = new int[input.length];
     for(int i=0; i< input.length; i++){
            if(i==0)
                prefixSum[i] = input[i];
            else
                prefixSum[i] = prefixSum[i-1] + input[i];
        }
```
- Remember this: `prefixSum[i] = prefixSum[0]+ prefixSum[1]+ .....+ prefixSum[i-1]+prefixSum[i]`
- as part of cumulative sum if you want ot find the sum of `ith` element you can directly add `ith` value to previous sum(which is `i-1th` sum)  `prefixSum[i] = prefixSum[i-1] + input[i]`


### How to calculate range_sum from prefix sum array?

- Once the prefix sum array has been created, answering a range sum query is very simple.
- To answer a query that asks for the sum of the elements in the range from index 'L' to index 'R', 
- range sum[L, R]:
  
        - If L==0 then range sum = prefixSum[R]
        - Otherwise,
        - we simply subtract the sum of the elements in the range from index 0 to index L-1 from the sum of the elements in the range from index 0 to index R.
        - rangeSum[L,R] = prefixSum[R]-prefixSum[L-1]

  
### When to Use?

        - Respond to range-sum-queries and range-xor-queries
        - Find sum of all elements in a given range
        - Locate subarrays having the highest sum
        - Locate the subarray whose total is closest to a given value
        - Locate subarrays of two arrays that are the same length and sum
        - Simulate parallel algorithms

#### Example:
- Let us take cricket score board example
- 
```java
  //TODO: add cricket score board example for better understanding

```

##### Summary
- PrefixSum formula for **i<sup>th</sup>** element:
         
        - If i=0 then pfSum[0] = ar[0]
        - Otherwise, pfSum[i] = pfSum[i-1]+ar[i]
- RangeSum formula for index range [L,R]:
           
        - If L=0 then rangeSum[L,R] = pfSum[R]
        - Otherwise, rangeSum[L,R] = pfSum[R]-pfSum[L-1]

### Problems
1. Q4.Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
2. Q3. You are given an integer array A of length N.
   You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
   For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
   More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
3. AQ2. Problem Description
   You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.

4. AQ3. Given an array A of N integers. Construct prefix sum of the array in the given array itself.
5. 

#### References:
1. https://www.jordan-cp.com/blog/prefix_sum
2. https://www.scaler.com/topics/prefix-sum/
3. 


