
# Graphs in DSA - Summary & Problem List

Got it. Let’s break down **Graphs in DSA** systematically so you can clearly understand the **types of questions**, **common patterns**, **segregation of patterns**, and see **detailed examples** for each.

This will help you master Graphs for interviews, especially for companies like Microsoft, Amazon, and Google, where graph problems are common.

---

## **1. Overview of Graphs in DSA**

A **graph** is a data structure with:

* **Vertices (nodes)**: Points representing entities
* **Edges**: Connections between vertices

### Graph Types

* **Directed / Undirected**
* **Weighted / Unweighted**
* **Cyclic / Acyclic**
* **Connected / Disconnected**
* **Special graphs**: Trees, DAGs (Directed Acyclic Graphs), Bipartite graphs, etc.

---

## **2. Categories of Graph Problems**

Most graph questions fall under these main categories:

1. **Traversal & Representation**
2. **Connected Components & BFS/DFS Applications**
3. **Shortest Path Problems**
4. **Cycle Detection Problems**
5. **Topological Sorting (DAG)**
6. **Graph Coloring / Bipartite Check**
7. **Minimum Spanning Tree (MST)**
8. **Strongly Connected Components (SCC)**
9. **Flow Problems (Advanced)**
10. **Special Problems (Union-Find, Bridges, Articulation Points, etc.)**

---

## **3. Patterns with Examples**

Let's see each pattern with its **question types** and **examples**.

---

### **Pattern 1: Graph Representation & Traversal**

**Key Idea:** Represent graph using **Adjacency List** (most common) or **Adjacency Matrix** and traverse with **BFS** or **DFS**.

#### Questions:

* Traverse all nodes of a graph
* Count connected components
* Check if graph is connected

#### Examples:

1. **Number of Islands** (Leetcode 200)
2. **Flood Fill** (Leetcode 733)

#### Example: DFS Traversal

```java
void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    for (int nei : adj.get(node)) {
        if (!visited[nei]) dfs(nei, adj, visited);
    }
}
```

---

### **Pattern 2: BFS / DFS Applications**

**Key Idea:** BFS for shortest paths in **unweighted** graphs, DFS for exploring components.

#### Questions:

* Shortest path in unweighted graph
* Rotten Oranges problem
* Word Ladder problem

#### Examples:

1. **Shortest Path in Binary Matrix** (Leetcode 1091) → BFS
2. **Rotten Oranges** (Leetcode 994) → BFS

#### BFS Example:

```java
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{0,0});
while(!q.isEmpty()){
    int[] cell = q.poll();
    // process cell
}
```

---

### **Pattern 3: Cycle Detection**

**Key Idea:**

* **Undirected Graph:** Use DFS with parent tracking or Union-Find
* **Directed Graph:** Use DFS with recursion stack or Kahn's Algorithm

#### Questions:

1. Detect cycle in undirected/directed graph
2. Course Schedule (Leetcode 207)

#### Example: Directed Cycle using DFS

```java
boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
    visited[node] = 1; // 1=visiting
    for (int nei : adj.get(node)) {
        if (visited[nei] == 1) return true; // cycle
        if (visited[nei] == 0 && dfs(nei, adj, visited)) return true;
    }
    visited[node] = 2; // 2=visited
    return false;
}
```

---

### **Pattern 4: Topological Sorting (DAG)**

**Key Idea:**
For **DAGs**, order nodes such that for every directed edge U→V, U comes before V.

#### Questions:

1. Course Schedule II (Leetcode 210)
2. Alien Dictionary (Leetcode 269)

#### Approaches:

* DFS-based topological sort
* Kahn’s Algorithm (BFS + In-degree)

---

### **Pattern 5: Shortest Path Problems**

**Key Idea:**

* **Unweighted:** BFS
* **Weighted Positive:** Dijkstra’s Algorithm
* **Negative edges:** Bellman-Ford
* **All pairs:** Floyd-Warshall

#### Questions:

1. Network Delay Time (Leetcode 743)
2. Cheapest Flights Within K Stops (Leetcode 787)

#### Example: Dijkstra

```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
pq.add(new int[]{src, 0});
while(!pq.isEmpty()){
    int[] curr = pq.poll();
    // relax edges
}
```

---

### **Pattern 6: Graph Coloring / Bipartite Check**

**Key Idea:** Use BFS or DFS to color graph with 2 colors. If conflict → not bipartite.

#### Question:

* Is Graph Bipartite? (Leetcode 785)

---

### **Pattern 7: Minimum Spanning Tree (MST)**

**Key Idea:**

* **Kruskal’s Algorithm** → Union-Find
* **Prim’s Algorithm** → Min Heap

#### Questions:

1. Minimum Spanning Tree cost
2. Connecting Cities with Minimum Cost (Leetcode 1135)

---

### **Pattern 8: Strongly Connected Components (SCC)**

**Key Idea:** Kosaraju’s or Tarjan’s Algorithm for directed graphs.

#### Question:

* Find SCCs in a graph (Leetcode 1192)

---

### **Pattern 9: Union-Find / Disjoint Set**

**Key Idea:** Used in Kruskal’s, cycle detection, connectivity problems.

#### Questions:

1. Redundant Connection (Leetcode 684)
2. Number of Connected Components (Leetcode 323)

---

### **Pattern 10: Advanced Problems**

* Bridges and Articulation Points
* Max Flow (Ford-Fulkerson, Edmonds-Karp)
* Minimum Cut Problems

---

## **4. Segregation Table for Quick Reference**

| Pattern                  | Algorithms       | Problems Examples                    |
| ------------------------ | ---------------- | ------------------------------------ |
| Graph Representation     | BFS, DFS         | Number of Islands, Flood Fill        |
| Connected Components     | BFS, DFS         | Count Islands, Connected Graph       |
| Shortest Path            | BFS, Dijkstra    | Network Delay Time, Word Ladder      |
| Cycle Detection          | DFS, Union-Find  | Course Schedule, Detect Cycle        |
| Topological Sort         | DFS, Kahn’s Algo | Course Schedule II, Alien Dictionary |
| Graph Coloring/Bipartite | BFS/DFS          | Is Bipartite Graph?                  |
| MST                      | Kruskal, Prim    | Connecting Cities, MST Cost          |
| SCC                      | Kosaraju, Tarjan | SCC in Directed Graphs               |
| Union-Find               | DSU              | Redundant Connection                 |
| Advanced (Flow, Bridges) | Ford-Fulkerson   | Max Flow, Min Cut                    |

---

## **5. Recommended Practice Order**

1. BFS/DFS Basics
2. Connected Components
3. Cycle Detection
4. Topological Sort
5. Shortest Paths
6. MST & Union-Find
7. SCC & Advanced Problems

---



## 1. Summary of Graph Concepts

Graphs are versatile data structures widely used in problem-solving for MAANG-level interviews.  
They can be classified as:
- **Directed / Undirected**
- **Weighted / Unweighted**
- **Cyclic / Acyclic**
- **Connected / Disconnected**

### Common Problem Patterns in Graphs
| Pattern                     | Algorithms          | Example Problems                  |
|-----------------------------|---------------------|-----------------------------------|
| Graph Representation        | BFS, DFS            | Number of Islands, Flood Fill      |
| Connected Components        | BFS, DFS            | Count Islands, Connected Graph     |
| Shortest Path                | BFS, Dijkstra       | Network Delay Time, Word Ladder    |
| Cycle Detection              | DFS, Union-Find     | Course Schedule, Detect Cycle      |
| Topological Sort             | DFS, Kahn’s Algo    | Course Schedule II, Alien Dictionary|
| Graph Coloring/Bipartite     | BFS/DFS             | Is Bipartite Graph?                |
| MST                          | Kruskal, Prim       | Connecting Cities, MST Cost        |
| SCC                          | Kosaraju, Tarjan    | SCC in Directed Graphs             |
| Union-Find                   | DSU                | Redundant Connection               |
| Advanced (Flow, Bridges)     | Ford-Fulkerson      | Max Flow, Min Cut                  |

---

## 2. Problem List with Increasing Difficulty

### **Level 1: Basics (Graph Representation & Traversal)**
1. Number of Islands (Leetcode 200)
2. Flood Fill (Leetcode 733)
3. Matrix DFS/BFS Traversal Problems
4. Connected Components in Graph (Leetcode 323)

### **Level 2: BFS & DFS Applications**
5. Rotten Oranges (Leetcode 994)
6. Shortest Path in Binary Matrix (Leetcode 1091)
7. Word Ladder (Leetcode 127)

### **Level 3: Cycle Detection**
8. Course Schedule (Leetcode 207)
9. Detect Cycle in Undirected Graph (GeeksforGeeks)

### **Level 4: Topological Sorting (DAG Problems)**
10. Course Schedule II (Leetcode 210)
11. Alien Dictionary (Leetcode 269)

### **Level 5: Shortest Paths**
12. Network Delay Time (Leetcode 743)
13. Cheapest Flights Within K Stops (Leetcode 787)
14. Bellman-Ford Algorithm Practice Problems

### **Level 6: Graph Coloring / Bipartite**
15. Is Graph Bipartite? (Leetcode 785)
16. Possible Bipartition (Leetcode 886)

### **Level 7: MST & Union-Find**
17. Kruskal’s MST Practice Problem
18. Prim’s MST Practice Problem
19. Connecting Cities with Minimum Cost (Leetcode 1135)
20. Redundant Connection (Leetcode 684)

### **Level 8: Strongly Connected Components (SCC)**
21. Kosaraju’s Algorithm Practice Problem
22. Tarjan’s Algorithm Practice Problem

### **Level 9: Advanced Problems**
23. Bridges in Graph (Leetcode 1192)
24. Articulation Points Problem
25. Max Flow - Ford-Fulkerson Algorithm

---

## 3. Recommended Practice Order
1. Start with BFS/DFS basics  
2. Move to Connected Components & Cycle Detection  
3. Learn Topological Sort for DAGs  
4. Master Shortest Paths (BFS, Dijkstra, Bellman-Ford)  
5. Practice MST (Kruskal & Prim) & Union-Find  
6. Solve SCC problems (Kosaraju/Tarjan)  
7. Explore advanced concepts like Bridges, Articulation Points, Max Flow  

---

## 4. Resources
- **Leetcode Graph Problems**: https://leetcode.com/tag/graph/
- **GeeksforGeeks Graph Tutorials**: https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/
- **CP Algorithms**: https://cp-algorithms.com/
