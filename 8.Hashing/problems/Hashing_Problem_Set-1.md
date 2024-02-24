# Hashing Easy Problem Set:

Problem-1: Given N elements find the count of distinct elements.
Example: [1,5,6,2,1,3,2,5,6,1] Output: 5 => [1,2,3,5,6]
Hint: Insert all the elements in a HashSet and get the Count.

__Problem-2:__ Sub Array Sum equals to Zero
Given an array of N elements check if there exists a sub array with sum is zero.
````text
    arr = [ 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 ]
    output: true
````
__Problem-3:__ Longest Subarray Zero Sum:

__Code:__

````java
// [-16, 16, 2]
// [ 2, 2, 1, -3, 4, 3, 1, -2, -3, 2 ]

int longestSubArrayWithZeroSum(int[] A){
    HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
    Long curr = 0L;
    int ans = 0;
    //we add zero to mitigate if any pfSum becomes zero then we can consider that starting of the array to till i is subarray
    pref.put(0L, 0);
    for(int i = 1 ; i <= A.length ; i++){
        curr += A[i - 1];
        if(pref.containsKey(curr)){
            ans = Math.max(ans, i - pref.get(curr));
        }
        else{
            pref.put(curr, i);
        }
    }
    return ans;    
}

````