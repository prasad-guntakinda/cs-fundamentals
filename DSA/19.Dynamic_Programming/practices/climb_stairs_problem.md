# Climb Stairs:

<details>

<summary>Combinatorics: Addition Rule and Product Rule</summary>



## Combinatorics: Addition Rule and Product Rule

### Addition Rule:
The **Addition Rule** in combinatorics states that if there are two or more mutually exclusive ways of doing something, the total number of ways is the sum of the ways of doing each action.

#### Example:
Imagine you have two routes to reach a destination:
1. Route A has 3 paths.
2. Route B has 2 paths.

Since you can only take one route (mutually exclusive), the total number of ways to reach the destination is:
```
Total ways = Paths in Route A + Paths in Route B = 3 + 2 = 5
```

### Product Rule:
The **Product Rule** in combinatorics states that if there are two or more independent choices to be made, the total number of ways is the product of the ways of making each choice.

#### Example:
Imagine you are choosing an outfit:
1. You have 4 shirts.
2. You have 3 pairs of pants.

Since the choice of shirt is independent of the choice of pants, the total number of outfits is:
```
Total outfits = Number of shirts × Number of pants = 4 × 3 = 12
```

</details>

---

<details>

<summary> Intuition for Climb Stairs Problem: </summary>



### Intuition for Climb Stairs Problem:
The **Climb Stairs Problem** can be understood as a combination of the **Addition Rule** and the **Product Rule** in combinatorics. Let’s break it down further:

1. **Addition Rule**:
   - At each step, you have two mutually exclusive choices:
     - Take 1 step.
     - Take 2 steps.
   - These choices are mutually exclusive because you cannot take both 1 step and 2 steps at the same time. Therefore, the total number of ways to climb the stairs is the sum of the ways to climb the remaining stairs after taking 1 step and after taking 2 steps.

   - Mathematically, if `f(n)` represents the number of ways to climb `n` stairs, the relationship can be expressed as:
     ```
     f(n) = f(n-1) + f(n-2)
     ```
     This is because:
     - `f(n-1)` represents the ways to climb the stairs if you take 1 step first.
     - `f(n-2)` represents the ways to climb the stairs if you take 2 steps first.

2. **Product Rule**:
   - If you think of the problem in terms of sequences of steps, each sequence is formed by making independent choices at each step.
   - For example, if you decide to take 1 step, the remaining problem (climbing `n-1` stairs) is independent of the first step. Similarly, if you decide to take 2 steps, the remaining problem (climbing `n-2` stairs) is also independent.
   - This independence allows us to multiply the number of ways to solve the smaller subproblems to get the total number of ways for the larger problem.

3. **Recursive Nature**:
   - The problem can be visualized as a tree of decisions:
     - At the root, you decide whether to take 1 step or 2 steps.
     - Each branch represents the remaining stairs to climb, which can be solved recursively using the same logic.
   - This recursive structure is why the problem is often solved using dynamic programming, where we store the results of smaller subproblems to avoid redundant calculations.

4. **Dynamic Programming Insight**:
   - By combining the **Addition Rule** and the **Product Rule**, we can see that the problem boils down to solving smaller subproblems and combining their results.
   - Using dynamic programming, we can compute the number of ways to climb the stairs iteratively or recursively, storing intermediate results to optimize the solution.

#### Example Problem:
Let’s revisit the example of climbing 3 stairs:
- **Step 1**: Take 1 step, leaving 2 stairs to climb.
- **Step 2**: Take 2 steps, leaving 1 stair to climb.

Using the **Addition Rule**, the total ways to climb 3 stairs is:
```
Ways to climb 3 stairs = Ways to climb 2 stairs + Ways to climb 1 stair
```
- If `f(2) = 2` (ways to climb 2 stairs: [1+1, 2]) and `f(1) = 1` (ways to climb 1 stair: [1]), then:
```
f(3) = f(2) + f(1) = 2 + 1 = 3
```
- The 3 ways to climb 3 stairs are:
  - [1, 1, 1]
  - [1, 2]
  - [2, 1]

This recursive relationship and the use of combinatorics rules form the foundation of the solution.

</details>


---

<details>

<summary> Climbing Stairs - Count ways to reach Nth stair (Order does not matter) </summary>


</details>


#### Variations:
<ul>

<li>Find the nth Fibonacci Number.</li>
<li>Find the number of ways to climb N stairs by taking at most k steps.</li><li>Count the number of ways to reach the nth stair using steps 1, 2, or 3.</li>
<li>Consider a game where a player can score 3, 5, or 10 points in a move. Given a total score of n, find the number of ways to reach the given score.</li>
<li>Given n, count the number of ways to express n as a sum of 1, 3, and 4.</li>
<li>Count the number of paths from the top left corner to the bottom right corner of an MxN grid, where you can only move down or right.</li>
<li>Given a set of distinct integers, find all possible subsets that add up to a target sum.</li>
</ul>

### Reference:
1. https://www.enjoyalgorithms.com/blog/climbing-stairs-problem
2. https://www.geeksforgeeks.org/dsa/count-ways-reach-nth-stair/