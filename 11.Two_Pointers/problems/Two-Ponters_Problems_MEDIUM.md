# Two-Pointer Problems Easy

<details>
<summary>Q1. Two Sum II - Input Array Is Sorted</summary>

__problem statement:__
<https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/>

__Constraints:__
- Index starts with 1
- Your solution must use only constant extra space.

### Approaches:

__1. Brute Force:__ two loops, for each i iterate j-> i+1 to n-1 if sum matches return [i+1, j+1] TC: O(n^2) SC: O(1)
__2. HashMap:__ 
- For each i find k-arr[i] inside the hashmap if pair is found then return [i+1, map.get(arr[i])+1] otherwise store {arr[i]: index} inside the hashmap
- This approach works for both Sorted and Unsorted array
- TC: O(N) SC: O(N) we need to optimize on SC

__3.Binary Search:__
- As given array is sorted, we can use Binary Search to find the compliment in rest of the array
- For each arr[i] find the k-arr[i] by using Binary Search. it takes logn to search on the array.
- TC: O(nlogn) SC: O(1), TC should be Optimized

__4.Two-pointer: Optimized__
- As array is sorted and we need to find only one pair, so we can use the two-pointer approach
- Where to start the pointers initially? p1=0 and p2=n-1
- How to move the pointers? Based on the sum(p1+p2) will decide which pointer to move.
```java
        if(arr[p1]+arr[p2] == k)
            return new int[]{p1+1, p2+1};
        else if(arr[p1] + arr[p2] > k)
            p2--;
        else
            p1++;
```

__Find Pairs Count with duplicates:__
```java
        var pairCount=0;
        if(arr[p1] + arr[p2] > k)
            p2--;
        else if(arr[p1] + arr[p2] < k)
            p1++;
        else{
            if(arr[p1] == arr[p2]){
             int dupCount = p2-p1;
             pairCount += ((dupCount)*(dupCount-1))/2; //freq C 2
            }else {
                int count1 = 0;
                int e1 = arr[p1];
                while(arr[p1] == e1){
                    count1++;
                    p1++;
                }
                int count2 = 0;
                int e2 = arr[p2];
                while(arr[p2] == e2){
                    count2++;
                    p2--;
                }
                
                pairCount += (count1*count2);
            }   
            
        }
```



__code:__

__Notes:__
</details>
