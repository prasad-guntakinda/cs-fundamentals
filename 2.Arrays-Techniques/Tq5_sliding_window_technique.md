# Sliding Window Technique
######  R-1 ==============
- Sliding Window Algorithm is a technique for reducing the complexity of algorithms.
- In this technique, we reuse the result of the previous step to compute the result of the next step.

- It is an algorithm where we can fast compute the things which have a fixed window for calculation and we can fetch the result in an optimized manner than using the nested loops(naive approach). 
- The main goal of this algorithm is to reuse the result of one window to compute the result of the next window.


### Examples:
1. How many sub arrays are there in an array of size N with length K?
```text
index 0,1,2,3,4,5,6,7,8
ar = [1,2,3,4,5,6,7,8,9]
 
N=9
K=5
num of sub arrays with size 5 = [0,4],[1,5],[2,6],[3,7],[4,8]
which is nothing but = [0,k-1],[1,k],[2,k+1],....[?,n-1]
num of sub arrays with size k = [k-1, n-1] = num of elements b/w [k-1, n-1]
[a,b] = b-a+1 ==> [k-1,n-1] = n-1-(k-1)+1 = n-k+1

```
- Here we call size of `K` elements as window, below example explains where can we actually use sliding window technique.

2. Given an array of size N find the maximum subarray sum for subarrays with length K

**Explanation:**
- As we see this question is talks about sum of an array elements from start index to end index

**Approach-1:** As it has start and end indexes and doing sum, we can consider it as RangeSum technique
##### pseudo code for range sum
```java
index=0,1,2,3,4,5,6,7
ar = [1,2,5,6,2,1,3,4]
n=8
k=5
//1.calculate prefixSum array formula: pfSum[i] = pfSum[i-1]+ar[i]
index =  0,1,2,3, 4, 5, 6, 7
pfSum = [1,3,8,14,16,17,20,24];  
maxSum=0;
start=0;
end=k-1;
while(end<n){
    //sum = [start, end] = [L,R] = pfSum[R]-pfSum[L-1]
    sum = pfSum[end]-pfSum[start-1];
    maxSum = max(maxSum, sum);
    start++;
    end++;
}
return maxSum;
TC=O(n)
SC=O(n)
```

**Approach-2:**
- If you observe on the above approach every time we moving forward with `k` elements.
- will start from `0 to k-1` next to `1 to k`, next `2 to k+1` and so on to `? to n-1`
- if we consider `k` elements as a range window then we are moving forward(sliding) one step towards end of the array
- If you observe first `k` elements `sum` it is a normal sum from `ar[0]+ar[1]+..+ar[k-1]` normal sum
- next step onwards we are adding one right index value and removing one left index value
##### For Example:
```text
index=0,1,2,3,4,5,6,7
ar = [1,2,5,6,2,1,3,4]
k=5 
i=0; kSum = [0,k-1] = 1+2+5+6+2 = 16
i=1; kSum = kSum+ar[k]-ar[0] = 16+1-1 = 16
i=2  kSum = kSum+ar[k+1]-ar[1] = 16+3-2 = 17
i=3  kSum = kSum+ar[k+2]-ar[2] = 17+4-5 = 16
.
. 
until i<(n-k+1) // num of sub arrays with length k  
```
- so instead of calculating prefixSum array we can calculate max sum of sub array with length k

#### pseudo code for sliding window
```java
index=0,1,2,3,4,5,6,7
ar = [1,2,5,6,2,1,3,4]
n=8
k=5
maxSum=0
kSum = 0
for(int i=0;i<k;i++){
    sum+=ar[i];
}
//from 0 to k-1 we already calculated kSum
//so starting from next window [1,k]
startIndex=1;
endIndex = k;
maxSum = kSum;
while(endIndex<n){
  // new window sum = kSum+incomingValue-outgoingValue
  kSum = kSum+ar[endIndex]-ar[startIndex];
  maxSum = max(maxSum, kSum);
  startIndex++;
  endIndex++;
}
return maxSum
TC= k+n-k iterations = O(n)
SC=O(1)
```


#### References:
1. https://www.scaler.com/topics/sliding-window-algorithm/
2. 

##### Summary:
- num of sub arrays with size `k` in an array of size `n` = `[k-1,n-1] = n-k+1`