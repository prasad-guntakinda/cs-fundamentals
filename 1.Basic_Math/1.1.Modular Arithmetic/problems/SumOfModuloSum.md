
Problem Description
Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 10^5

1 <= A[i] <= 10^3



Input Format
The only argument given is the integer array A.



Output Format
Return a single integer denoting sum % (10^9 + 7).



Example Input
Input 1:

A = [1, 2, 3]
Input 2:

A = [17, 100, 11]


Example Output
Output 1:

5
Output 2:

61

##### Brute-force:
````java
public int solve(int[] A) {
        int sum =0;
        int mod = 1000_000_007;
        //Aproach: take each index and do modulo with next index onwards in both ways at a time (a%b)+(b%a)
        //You can always go forward don't need to look back for previous indexes it is already calculated
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                sum = sum%mod + (A[i]%A[j])%mod + (A[j]%A[i])%mod;
                
            }
        }
        //System.out.println("sum="+sum);
        return sum;
    }
````
- Time Limit Exceeded Error

#### Optimization:

Hint:
1. Calculate the frequency of all the elements from 1 to 1000.
2. For all values i from 1 to 1000 calculate sumi as sum of i % A[j] , where 1 <= j <= n
3. Sum of all such ((sumi) * (frequency of i)) would be the final answer.

__Code:__
``````java
 public int solve(ArrayList<Integer> A) {
        
        int n = A.size(), mod = 1000 * 1000 * 1000 + 7;
        
        // To store the frequency of each element
        int[] cnt = new int[1009];
        
        // Store the frequency of each element
        for(int a: A)    
            cnt[a]++;
            
        // To store the required answer
        int ans = 0;
        
        // For all valid pairs
        for(int i = 1; i <= 1000; i++){
            if(cnt[i] == 0)    
                continue;
            for(int j = 1; j <= 1000; j++){
                if(cnt[j] == 0)    
                    continue;
                // Update the count
                int val = j % i;
                int temp = cnt[i] * cnt[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;
    }
``````
