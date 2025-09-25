# Dynamic Programming (DP) Concepts

Dynamic Programming is a commonly used algorithmic technique used to optimize recursive solutions when same subproblems are called again.

- The core idea behind DP is to store solutions to subproblems so that each is solved only once.
- To solve DP problems, we first write a recursive solution in a way that there are overlapping subproblems in the recursion tree (the recursive function is called with the same parameters multiple times)
- To make sure that a recursive value is computed only once (to improve time taken by algorithm), we store results of the recursive calls.
- There are two ways to store the results, one is top down (or memoization) and other is bottom up (or tabulation).
---

<details>
<summary>When to Use Dynamic Programming?</summary>

## When to Use Dynamic Programming?

Dynamic Programming is a method for solving problems by:
1. Breaking the problem into smaller subproblems.
2. Solving each subproblem only once and storing the results (memoization).
3. Using the stored results to solve larger subproblems.

### Key Characteristics:
- **Optimal Substructure:** The solution to a problem can be constructed from the solutions of its subproblems.
- **Overlapping Subproblems:** The same subproblems are solved multiple times.

### Example Problems:
- Fibonacci Numbers
- Knapsack Problem
- Longest Common Subsequence
- Matrix Chain Multiplication

</details>

---

<details>
<summary>Top-Down vs Bottom-Up Approaches</summary>

## Top-Down vs Bottom-Up Approaches
Tabulation and memoization are two techniques used to implement dynamic programming. Both techniques are used when there are overlapping subproblems 
### Top-Down (Memoization):
- Solve the problem recursively.
- Store the results of subproblems in a table to avoid redundant calculations.

**Example:** Fibonacci Numbers (Top-Down)
```java
import java.util.HashMap;

public class FibonacciTopDown {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // Output: 55
    }
}
```

### Bottom-Up (Tabulation):
- Solve the problem iteratively.
- Build a table from the smallest subproblems to the largest.

**Example:** Fibonacci Numbers (Bottom-Up)
```java
public class FibonacciBottomUp {
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // Output: 55
    }
}
```

</details>

---

<details>
<summary>Common DP Problems and Solutions</summary>

## Common DP Problems and Solutions

### 1. Longest Common Subsequence (LCS)
**Problem:** Find the length of the longest subsequence common to two strings.

**Code:**
```java
public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "ace")); // Output: 3
    }
}
```

### 2. 0/1 Knapsack Problem
**Problem:** Maximize the value of items in a knapsack of limited capacity.

**Code:**
```java
public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        System.out.println(knapsack(weights, values, capacity)); // Output: 55
    }
}
```

</details>

---

<details>
<summary>Tips for Solving DP Problems</summary>

## Tips for Solving DP Problems

1. **Identify Subproblems:** Break the problem into smaller subproblems.
2. **Define State:** Decide what each state in the DP table represents.
3. **State Transition:** Determine how to compute the value of each state from previous states.
4. **Base Cases:** Define the initial values for the DP table.What are the simplest states that can be solved directly?
5. **Solving the subproblems:**
   
    5.1 **Memoization (Top-down):** Start from the main problem and recursively solve subproblems, storing results as they are computed.

    5.2. **Tabulation (Bottom-up):** Start from the base cases and iteratively build up solutions for larger states.

6. **Optimize Space:** Use a 1D array instead of a 2D array if possible.
7. **Practice:** Solve a variety of DP problems to build intuition.


</details>

---

<details>
<summary>Advanced DP Concepts</summary>

## Advanced DP Concepts

### 1. DP with Bitmasking
- Solve problems involving subsets efficiently using bitmasks.

### 2. DP on Trees
- Solve problems on tree structures using post-order traversal.

### 3. DP with Sliding Window
- Optimize space complexity by using a sliding window instead of a full DP table.

</details>


#### References: 
1. https://www.geeksforgeeks.org/competitive-programming/dynamic-programming/
2. https://brilliant.org/wiki/rule-of-sum/
3. https://calcworkshop.com/combinatorics/fundamental-counting-principle
4. https://library.fiveable.me/combinatorics/unit-1/applications-basic-counting-principles/study-guide/N6ymihoFD34cp1M7
5. 