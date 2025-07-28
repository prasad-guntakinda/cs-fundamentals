## Easy



## Medium
<details>
<summary> Bitwise OR subarrays sum</summary>

__Problem Statement:__

You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.

``
Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108



Input Format

The first argument given is the integer array A.



Output Format

Return the sum of Value of all subarrays of A % 109 + 7.



Example Input

Input 1: A = [1, 2, 3, 4, 5] Output: 71

Input 2: A = [7, 8, 9, 10] Output: 110

Example Explanation

Explanation 1:

Value([1]) = 1
Value([1, 2]) = 3
Value([1, 2, 3]) = 3
Value([1, 2, 3, 4]) = 7
Value([1, 2, 3, 4, 5]) = 7
Value([2]) = 2
Value([2, 3]) = 3
Value([2, 3, 4]) = 7
Value([2, 3, 4, 5]) = 7
Value([3]) = 3
Value([3, 4]) = 7
Value([3, 4, 5]) = 7
Value([4]) = 4
Value([4, 5]) = 5
Value([5]) = 5
Sum of all these values = 71


``

__CODE:__

```java
public class Solution {
    public int solve(int[] A) {
        final int mod = 1_000_000_007;
        //create bit wise 2D-array for all the numbers
        int[][] bitInds = new int[32][A.length];
        //Get each bit values for all the numbers
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (isIthBitSet(A[j], i)) {
                    bitInds[i][j] = 1;
                } else
                    bitInds[i][j] = 0;
            }
        }

        //after populating bit values calculate how many sub arrays bit doesn't contribute to the sum
        //create new array for each bit and store num of sub arrays for each bit count which are not contribute to sum
        int[] pfSum = new int[32];
        int totalSubArrays = A.length * (A.length + 1) / 2;
        for (int i = 0; i < 32; i++) {
            int unsetCnt = 0;
            for (int j = 0; j < A.length; j++) {
                if (bitInds[i][j] == 0) {
                    unsetCnt++;
                } else {
                    pfSum[i] += unsetCnt * (unsetCnt + 1) / 2;
                    unsetCnt = 0;
                }
            }
            if (unsetCnt > 0) {
                pfSum[i] += unsetCnt * (unsetCnt + 1) / 2;
            }
        }
        int ans = 0;
        for (int i = 0; i < pfSum.length; i++) {
            ans = ((ans % mod) + ((totalSubArrays - pfSum[i]) * (int) Math.pow(2, i)) % mod) % mod;
        }

        return ans;

    }
}

```



__Optimized:__
```java
private boolean isIthBitSet(int num, int ind){
    return (num & (1<<ind))>0;
}

public int optimized(int[]ar){
    final long mod = 1_000_000_007;
    long ans=0;
    //System.out.println("ar.length: "+ar.length);
    long totalSubArrays = (1L*ar.length * (ar.length+1))/2;
    //System.out.println("total sub arrays: "+totalSubArrays);
    long[] pfSum = new long[32];
    for(int i=0;i<32;i++){
        int unsetCnt = 0;
        long totalRemCnt=0;
        for(int j=0;j<ar.length;j++){
            if(isIthBitSet(ar[j], i)){
                totalRemCnt += (1L*unsetCnt*(unsetCnt+1)/2);
                unsetCnt=0;
            }else{
                unsetCnt++;
            }
        }
        if(unsetCnt>0)
            totalRemCnt += (1L*unsetCnt*(unsetCnt+1)/2);
        // System.out.println("i="+i+" totalRemCnt="+totalRemCnt);
        pfSum[i] = totalRemCnt;

    }
    for(int i=0;i<32;i++){
        ans = (ans%mod + ((totalSubArrays - pfSum[i])%mod * (1L << i) % mod)) % mod;
    }
    return (int)(ans%mod);
}
 

```


__Solution-2:__

```java
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pw = 1 << j;
                if ((tmp & pw) != 0) { //if jth bit is set
                    ans += pw * i; // add its contribution in ans for all subarrays ending at index i
                    idx[j] = i; // store the index for next elements
                } else if (idx[j] != 0) // if jth bit is not set
                {
                    ans += pw * idx[j]; // add its contribution in ans for all subarrays ending at index i using 
                } // the information of last element having jth bit set
            }
        }
        return (int)(ans % 1000000007);
    }
}

```
</details>

## Hard
