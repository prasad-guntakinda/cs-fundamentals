# Carry Forward Technique

###### Revision-2================

###### 1

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

##### Examples with Pseudo Code
1. **AG pairs:** You have given a string `str` with length of N having Uppercase English letters. You have to find how many times subsequence "AG" is there in the given string.
- Examples
  - Input: 'BCADEG' Output: 1
  - Input: 'ABGCDGAMGAKG' Output: 7 
  - Input: 'AAAAAAAAAAG'  Output: 10
- To Simply the question, here we want to calculate how many `G`s are present after the char `A` where `A` index < `G` Index
- Brute-force:
   - Iterate over the array if we find `A` then write a nested loop to find the num of `G`s occurred in the rest of the string like this we iterate for all the elements in an array
- **Optimization:** 
   - While iterating somehow if we know how many `G`s present on the right side of `A` then we can calculate num of pairs in one iteration
   - If we start iterating string from end to start then we can easily keep track of `G`s count for the current `A`
   - If we know after current `A` there are 2 `G` available then it means there are two `AG` pairs available
- **Pseudo Code:**
```java
private int calculateAGPairs(String str) {
    //str = "ABGCDGAMGAKG";
    int gCount = 0;
    int pairCount = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
        if (str.charAt(i) == 'G') {
            gCount++;
        } else if (str.charAt(i) == 'A') {
            pairCount=pairCount+gCount;
        }
    }
    System.out.println("Number of AG pairs = " + pairCount);
    return pairCount;
}
```  
2. **Smallest Sub Array which contains both max and min values of the array:**
- Given an array of N integers, return the length of the smallest sub-array which contains both max and min values of the array.
- Examples:
  - Input: 1,2,5,4,6,5,8,4,1,5,2    Output: 3   Smallest Array with min:1 max:8 = [8,4,1]
  - Input: 6,4,2,1,4,1,1,2,1,6,5    Output: 2   Smallest Array with min:1 max:6 = [1,6]
- **Brute-force:**
  - create all the sub arrays and find what is the smallest sub array which contains both min and max values of the array
- **Optimization:**
- smallest sub array which contains min and max means, start and end indexes of this array should be either min or max.
- consider this as a normal array problems forget about sub arrays:
- Here, if we find min first then if max is already there calculate length
- else, look for max and see how many elements are there b/w these, mark this length for consideration
- if we find max value first then if min already present then calcualte the length and update ans otherwise, look for min and update ans

- **Pseudo Code:**
```java
private int smallestSubArrayWithMinAndMax(int[] arr){
    int min = arr[0];
    int max = arr[0];
    for (int i=1;i<arr.length;i++){
        if(arr[i]<min){
            min = arr[i];
        }
        if(arr[i]>max){
            max = arr[i];
        }
    }
    // if array elements all are same then min and max values will be same 
    //eg: [4,4,4,4]
    if(min == max){
        return 1;
    }
    int minIndex = -1;
    int maxIndex = -1;
    int smallestLength=Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++){
        if(arr[i] == min){
            minIndex = i;
            if(maxIndex != -1){
                //maxIndex already present means [maxIndex, minIndex] 
                smallestLength = Math.min(smallestLength, (minIndex-maxIndex+1));
            }
        }else if(arr[i] == max){
            maxIndex = i;
            if(minIndex != -1){
                //minIndex already present means [minIndex, maxIndex]
                smallestLength = Math.min(smallestLength, (maxIndex-minIndex+1));
            }
        }
    }
    System.out.println("smallest subarray length = "+smallestLength);
    return smallestLength;
}

```

#### Problems:
1. **Find all the leaders in array:** 
- Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
- An element is a leader if it is strictly greater than all the elements to its right side.
- NOTE: The rightmost element is always a leader.
- Example:
  - Input : A = [16, 17, 4, 3, 5, 2]   Output : [17, 2, 5]
  - Explanation:
    Element 17 is strictly greater than all the elements on the right side to it.
    Element 2 is strictly greater than all the elements on the right side to it.
    Element 5 is strictly greater than all the elements on the right side to it.
    So we will return these three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
  
2. **Best Time to Buy and Sell Stocks:** 
- Say you have an array, A, for which the ith element is the price of a given stock on day i.
- If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.Return the maximum possible profit.
- Examples: A = [1, 4, 5, 2, 4]  Output: 5  Explanation: Buy the stock on day 0, and sell it on day 2.

3. You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum. But the sum must not exceed B.


