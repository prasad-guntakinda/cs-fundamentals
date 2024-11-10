## Bit Manipulation Easy Problems:



<details>
<summary> Problem-1: Min XOR value: </summary>

__Problem Statement:__ Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

__Brute Force:__
- For each i-th element iterate over i+1 to till N and calculate XOR and maintain a minXOR value
__CODE:__
````java
 public int findMinXor(int[] A) {
    int ans = Integer.MAX_VALUE;
    for(int i=0; i<A.length; i++){
        for(j=i+1;j<A.length;j++){
            ans = Math.min(ans, A[i] ^ A[j] );    
        }
    }
    return ans;
    //TC: O(N^2) SC: O(1)
}
````

__Optimization:__
- Adjacent numbers XOR is always smaller than non-adjacent elements. `A<=B<=C then XOR(A, B) or XOR(B,C) is always less than XOR(A,C)`
- Example: XOR(20,21) < XOR(20,24)
- Proof: For adjacent elements, most of MSB's (Most Significant Bits) will be same, when we do XOR on same bits it will be set to zero
- That's why adjacent elements XOR will be lesser than non-adjacent bits
````text
20 - 10100
21 - 10101
24 - 11000

XOR(20,21) = 1
XOR(20,24) = 12
For adjacent elements most of the MSB's will be cancelled by XOR
````

__CODE:__
```java
 public int findMinXor(int[] A) {
    Arrays.sort(A);
    int ans = Integer.MAX_VALUE;
    for(int i=0; i<A.length-1; i++){
        ans = Math.min(ans, A[i] ^ A[i+1] );
    }
    return ans;
    //TC: O(NlogN) for sorting + O(N) for calculating minXOR
    //TC: O(NlogN) SC: O(1)
}
```
</details>


