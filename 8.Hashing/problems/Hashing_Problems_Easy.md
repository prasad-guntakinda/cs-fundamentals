# Hashing Easy Problem Set:
###### SCD-32 & 33

<details>
<summary>Q1: Check Pair Sum:</summary>

__problem statement:__
````text
Given an Array of integers arr, and a target sum K.
Check if there exists a pair (i,j) such that arr[i] + arr[j] = K and i!=j.
K = 8  arr = [3, 5, 1, 2, 1, 2] output: 1 (3+5)=8
K = 20 arr = [3, 5, 1, 2, 1, 2] output: 0

````
__code:__
````java
private static int isPairSumExists(int[] arr, int k) {
    HashSet < Integer > set = new HashSet< Integer >();
    for(int i = 0 ; i < arr.length ; i++){
        if(set.contains(k - arr[i])){
            return 1;
        }
        set.add(arr[i]);
    }
    return 0;

}
````

</details>

<details>
<summary>Q2: Count Pair Difference</summary>

__Problem Statement:__
```text
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 10^9+7.
A = [3, 5, 1, 2] B = 4 output: 1
A = [1, 2, 1, 2] B = 1 output: 4
```
__Code:__
```java
 public int pairDiffCount(int[] A, int B) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        final int mod = 1_000_000_007;
        long ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            ans += freq.getOrDefault(A[i] - B, 0) + freq.getOrDefault(A[i] + B, 0);
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans % mod);
    }
```
</details>

<details>
<summary> Q3.  Longest Subarray Zero Sum </summary>

```text
Given an array A of N integers. Find the length of the longest subarray in the array which sums to zero.
If there is no subarray which sums to zero then return 0.
 A = [1, -2, 1, 2] Output: 3
 A = [3, 2, -1] output: 0
```

__code:__
````java
public int solve(int[] A) {
    Long pfSum = 0L;
    //System.out.println("pfSum = "+ Arrays.toString(pfSum));
    int maxSize=0;
    HashMap<Long, Integer> map = new HashMap<>();
    map.put(0L, -1);
    for(int i=0;i<A.length;i++){
       pfSum += A[i];
       if(map.containsKey(pfSum)){
           maxSize = Math.max(maxSize, (i-map.get(pfSum)));
           //System.out.println("maxSize = "+maxSize+" i = "+i+" j= "+map.get(pfSum));
       }else {
           map.put(pfSum, i);
       }
    }
    return maxSize;
}
````
</details>

<details>
<summary> Q4. Count Pair Sum</summary>

__Problem Statement:__
```text
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
A = [1, 2, 1, 2] B = 3 Output: 4
```

__code:__
````java
public int solve(int[] A, int B) {
    int mod = 1_000_000_007;
    HashMap<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for(int num: A){
        int comp = B-num;
        if(map.containsKey(comp)){
            ans += map.get(comp);
        }
        
        map.put(num, map.getOrDefault(num,0)+1);
        
    }
    return ans%mod;
}
````

</details>

<details> 
<summary>Q5. Subarray with given sum</summary>

__Problem Statement:__
```text
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

A = [1, 2, 3, 4, 5]  B = 5 Output:  [2, 3]
```

__Code:__
```java
public int[] solve(int[] A, int B) {

    long pfSum = 0L;
    HashMap<Long, Integer> map = new HashMap<>();
    map.put(0L, -1);
    for(int i=0;i<A.length;i++){
        pfSum +=A[i];

        if(map.containsKey(pfSum-B)){
            int startIndex = map.get(pfSum-B);
            return Arrays.copyOfRange(A, startIndex+1, i+1);
        }
        map.put(pfSum, i);

    }

    return new int[]{-1};
}
```

__Two Pointer Approach:__

```java
 public int[] solve(int[] A, int B) {
    long n = A.length;
    int l = 0, r = 0;
    long sum = A[l];
    while (r < n) {
        if (sum == B) {
            // current window sum = B
            int[] ans = new int[r - l + 1];
            for (int i = l; i <= r; i++) ans[i - l] = A[i];
            return ans;
        } else if (sum < B) {
            // current window sum < B
            r++;
            if (r < n) sum += A[r];
        } else {
            // current window sum > B
            sum -= A[l];
            l++;
            if (l > r && l < n - 1) {
                r++;
                sum += A[r];
            }
        }
    }
    int ans[] = new int[1];
    ans[0] = -1;
    return ans;
}
```
</details>
<details>

<summary>Q6. Frequency of element query </summary>

__problem statement:__
```text
Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
A = [1, 2, 1, 1] B = [1, 2] Output: [3,1] 1 repeated for 3 times and 0 repeated for 1 time
```
__code:__
```java
public int[] findFreq(int[] A, int[] B) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: A){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }else{
                freqMap.put(num, 1);
            }
        }
        int[] ans = new int[B.length];
        for(int i=0;i<B.length;i++){
            ans[i] = freqMap.getOrDefault(B[i],0);
        }

        return ans;
    }
```
</details>


<details>

<summary>Q7. Count distinct elements </summary>

__problem statement:__

```text
Given an array A of N integers, return the number of unique elements in the array.
```

__solution:__
- add all the elements to HashSet and return it's size
</details>


<details>

<summary>Q8. First Repeating element </summary>

__problem statement:__

```text
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.
```
__Approach:__
- Iterate over the array from right to left and maintain a HashMap/HashSet for storing the visited elements
- If HashMap contains the element means it is repeated update answer flag, repeat this until 0-index then return answer.

</details>


<details>

<summary>Q9. Sub-array with 0 sum </summary>

__problem statement:__

```text
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.
A = [4, -1, 1] Output: true [1,-1]
A = [1,2,3,4,5,0] Output: true [0]
A = [1,2,3,4,5] Output: false 

```

__Approach:__
- Calculate the prefix sum 
- If prefix sum array has either 0 or repeated element means there is a sub array whose sum is zero
- To check the repetition use HashSet 

__code:__
```java
public int solve(ArrayList < Integer > A) {
    HashSet < Long > set = new HashSet < Long > ();
    long sum = 0;
    set.add(sum);
    for (int x: A) {
        sum += x;
        if (set.contains(sum)) return 1;
        else {
            set.add(sum);
        }
    }
    return 0;
}
```
</details>

<details>

<summary>10. Common Elements </summary>

__problem statement:__

```text
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:
Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.

 A = [1, 2, 2, 1]  B = [2, 3, 1, 2] Output: [1, 2, 2]
 A = [2, 1, 4, 10] B = [3, 6, 2, 10, 10] Output:  [2, 10]
```
__code:__
```java
 public ArrayList<Integer> findCommonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        HashMap<Integer, Integer> aMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();

        for(Integer num: A){
            if(aMap.containsKey(num)){
                aMap.put(num, aMap.get(num)+1);
            }else {
                aMap.put(num, 1);
            }

        }

        for(Integer num: B){
            if(bMap.containsKey(num)){
                bMap.put(num, bMap.get(num)+1);
            }else {
                bMap.put(num, 1);
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer num: aMap.keySet()){
            Integer repetitionCount = Math.min(aMap.get(num), bMap.getOrDefault(num,0));
            //System.out.println("num = "+ num +" repetitionCount= "+repetitionCount);
            for(int rep = 0; rep < repetitionCount; rep++){
                    ans.add(num);
            }
        }

        return ans;
    }
```
</details>


<details>

<summary>11. Count unique elements </summary>

__problem statement:__

```text
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
```
__code:__
```java
 public int countUniqueElements(int[] A) {
    Map<Integer, Integer> freq = new HashMap<>();
    for(int i = 0 ; i < A.length ; i++){
        if(freq.containsKey(A[i])){
            freq.put(A[i], freq.get(A[i]) + 1);
        } 
        else{
            freq.put(A[i], 1);
        }
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
        if(entry.getValue() == 1){
            count++;
        }
    }
    return count;
}
```
</details>

<details>

<summary> 12. Count Subarray Zero Sum</summary>

__problem statement:__

```text
Given an array A of N integers. Find the count of the subarrays in the array which sums to zero.
A = [1, -1, -2, 2] Output: 3 
```

__Approach:__
__1.__
````text
Since we are looking subarrays with sum = 0. Let’s try to create a pSum[] and let’s have some observation.

pSum[i] = Sum of all elements from index 0 to index i.

A[] = [4, 8, 3, 6, -5, -4, 7, -2, 1, -6, 2]

pSum[] = [4, 12, 15, 21, 16, 12, 19, 17, 18, 12, 14]

Here, sum of elements from index 0 to 1 is 12, and from index 0 to 5 is also 12. That means sum of elements from index 2 to 5 is zero.

12 is again present at index 9 and since it has appeared 2 times before it.

That means there are two more subarrays with sum = 0, subarray from index 2 to 9 and subarray from index 6 to 9.

So, we should keep a track of the number of times an element has appeared in pSum[]. For this, we can use hashmap/dictionary.

If an element has appeared x number of times in pSum[] and it is again appearing for (x+1)th time, the answer must be incremented by x.
````
__2.__

````text
Take a hashmap/dictionary and a variable sum.

Iterate on all the elements of the array and for every index i, update the value of sum. And then check if sum has already appeared. If it has already appeared, add its frequency in the answer. Also, update its frequency in the hashmap/dictionary.

Note - Since sum of elemets can be large, use the appropiate data type for storing sum. Also, ans can be very large, take appropiate data type for ans as well and remember to take modulo.
````

````text
Approach:

There are three steps:
1. Take a hashmap/dictionary and initialise sum and ans with 0.
2. Iterate on all elements and update the sum. Check if sum is already present in the map, 
   If it is already present in the map, increment the ans by the frequency of sum,
   otherwise, add the sum in the hashmap/dictionary with frequency 1. 
3. Be careful while deciding the data type of sum and ans. Also, don't forget to make modulo of ans with 10^9+7.
````
__code:__
```java
    public int solve(int[] A) {

    HashMap<Long, Integer> map =  new HashMap<>();
    map.put(0L,1);
    int mod = 1_000_000_007;
    Long sum = 0L;
    int count = 0;
    for(int num: A){
        sum = (sum%mod+num%mod)%mod;

        if(map.containsKey(sum)){
            count = (count%mod+map.get(sum)%mod)%mod;
            map.put(sum, map.get(sum)+1);
        }else {
            map.put(sum, 1);
        }

    }
    return count%mod;
}
```
</details>


<details>

<summary> </summary>

__problem statement:__

```text

```
__code:__
```java

```
</details>