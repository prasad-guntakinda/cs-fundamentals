# Hashing Problems Medium


<details>
<summary>Q1. Subarray Sum Equals K</summary>

__Problem Statement:__
```text
Given an array of integers and an integer K. Find the total number of subarrays having sum equals to K.
A = [1, 0, 1] B = 1 Output: 4
A = [0, 0, 0] B = 0 Output: 6
```
- Sub array = [start, end] of the indexes.

__code:__
````java
 public int solve(int[] arr, int k) {
        //prepare prefix sum array
        // iterate over the array and check element's compliment is available on map and update the count
        int n = arr.length;
        int[] pfSum = new int[n];
        pfSum[0] = arr[0];
        for(int i=1;i<n;i++){
            pfSum[i] = pfSum[i-1] + arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int i=0;i<n; i++){
            int elem = pfSum[i];
           
            int comp = elem - k;
            
            if(map.containsKey(comp)){
                ans += map.get(comp);
            }

            map.put(elem, map.getOrDefault(elem, 0)+1);
        }
        
        return ans;
    }
````

__Optimization:__

````java
public int solve(int[] arr, int k) {
        Map<Integer, Integer> prevSum = new HashMap<Integer, Integer>();
        prevSum.put(0, 1);
        int currSum = 0, ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            currSum += arr[i];
            if(prevSum.containsKey(currSum - k)){
                ans += prevSum.get(currSum - k);
            }
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
````

</details>

<details>
<summary>Q2. Distinct Numbers in Window</summary>

__Problem Statement:__
```text
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

A = [1, 2, 1, 3, 4, 3] B = 3 Output:  [2, 3, 3, 2]
First window: [1,2,1] distinct = [1,2]
second window: [2,1,3] distinct = [2,1,3]
```
- `No of windows with K elements in an array of size N => N-K+1`

```java
public int[] dNums(int[] A, int B) {

    if(B>A.length){
        return new int[]{};
    }

    int[] uniquesCount = new int[A.length-B+1];
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<B; i++){
        map.put(A[i], map.getOrDefault(A[i], 0)+1);
    }

    uniquesCount[0] = map.size();
    int start = 1, end=B;
    while(end < A.length){
        int incoming = A[end];
        int out = A[start-1];
        map.put(incoming, map.getOrDefault(incoming,0)+1);
        if(map.get(out) == 1){
            map.remove(out);
        }else{
            map.put(out, map.get(out)-1);
        }
        uniquesCount[start] = map.size();
        start++;
        end++;
    }

    return uniquesCount;
}
```
</details>


