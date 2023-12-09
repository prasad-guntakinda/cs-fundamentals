# Contribution Technique or  (Contribution to the sum)

- The contribution technique is an algorithm for finding the sum of all subarrays of an array.
- This technique is used to identify how many times an element will contribute to the answer
### For Example:
1. sum of an array:
```text
arr = [1,2,3]
sum= arr[0]+arr[1]+arr[2] = 1+2+3 =6
here how many times each element of an array is contributed(appears) to sum?
every element is contributed one time to get the sum
```
2. Sum of all Sub-arrays:
```text
arr=[1,2,3]
sub arrays = [1],[1,2],[1,2,3],[2],[2,3],[3] = 6 subarrays
sum of all sub arrays = 1+1+2+1+2+3+2+2+3+3 = 20
here how many times each element of an array is contributed to sum?
arr[0] = 1  contributed 3 times
arr[1] = 2  contributed 4 times
arr[2] = 3  contributed 3 times
can we add sum of all sub arrays = 1*3+2*4+3*3 = 3+8+9 = 20

we can simply say times of contribution = num of subarrays arr[i] is present
so sum of all sub arrays = arr[i]* (num of subarrays arr[i] is present)
```

## How to calculate in how many sub-arrays arr[i] is present?

#### Example:
```text
 arr = [1,2,3,4,5,6]
 - from what all the indexes it can start the subarray to have an arr[0]
    - it should start from 0th index
    - it can end any index from 0,1,2,3,4,5
 - sub arrays = [0,0],[0,1], [0,2] [0,3], [0,4],[0,5] = 6
 
 - for i=1 we can start from either 0 or 1
    - as sub array should be continuous indexes, if you start from 2 we cannot have 1, so it has to from lower indexes not from higher indexes  
 - end points it has to start same index to towards end of the array i.e 1,2,3,4,5   
    
  i                 start points                end points           possible subarray ranges which contains arr[i]  
 i=0                    0                       0,1,2,3,4,5          [0,0],[0,1], [0,2] [0,3], [0,4],[0,5] = 6
 i=1                    0,1                     1,2,3,4,5            [1,1], [1,2], [1,3], [1,4], [1,5] = 5 + (6-1)from arr[0] subarrays except [0,0]
                                                                                                        = 10 sub arrays i.e (num of start points * num of end points)
 i=2                    0,1,2                   2,3,4,5              (num of start points * num of end points) = 3*4 = 12 (2 is part of 12 sub arrays)
 .
 .
 i=i                    0,1,2,3,....i           i,i+1+i+2,...n-1      (i+1* [i,n-1]) = (i+1)*(n-i)                                                                                                                                   
```
- let us validate above example:
```text
 arr = [1,2,3,4,5,6]
 i              (i+1)*(n-i)
 0               1*6=6
 1               2*5 =10
 2               3*4 =12
```
      
## Pseudo Code
```java
ar = [1,2,3,4,5,6]
n=ar.length
sum=0
for(i=0;i<n;i++){
    sum+= ar[i]*((i+1)*(n-i)) //ar[i]*(num of sub-arrays ar[i] present)
}
 TC = O(n)
 SC = O(1) 
```

#### Problems:
1. You are given an integer array A of length N.
   You have to find the sum of all subarray sums of A.
   More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
   A subarray sum denotes the sum of all the elements of that subarray.

Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.

2. Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise



##### Summary:

- num of sub arrays arr[i] is present  = (num of start points)\*(num of end points)= **(i+1)*(n-i)**
#### References:
1. https://blog.devgenius.io/algorithm-contribution-pattern-c9c52fcdd8e9
2. 