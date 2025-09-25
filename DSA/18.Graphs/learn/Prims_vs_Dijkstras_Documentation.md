
# Prim's vs Dijkstra's Algorithm - Full Documentation

This document provides a detailed comparison of **Prim's** and **Dijkstra's** algorithms with code examples, use cases, and key differences.

---

## 1. Purpose

| Algorithm      | Purpose                                                     |
|----------------|-------------------------------------------------------------|
| **Dijkstra's** | Find shortest path from a single source to all other nodes. |
| **Prim's**     | Find Minimum Spanning Tree (MST) - minimum cost to connect all nodes without cycles. |

---

## 2. When to Use

| Use Case                     | Algorithm to Use       |
|------------------------------|-------------------------|
| Shortest routes / navigation  | **Dijkstra's**          |
| Network cabling, road design  | **Prim's**              |
| Dense graphs (many edges)     | **Prim's** (vs Kruskal) |
| Sparse graphs (fewer edges)   | **Kruskal** often better |

---

## 3. Graph Example

We will use this weighted, undirected graph for both algorithms:

```
    (1)
   /   \
  2     3
 /       \
(2)---1--(3)
 \       /
  4     5
   \   /
    (4)
```

Edges: `1-2 (2), 1-3 (3), 2-3 (1), 2-4 (4), 3-4 (5)`

---

## 4. Dijkstra's Algorithm (Shortest Path from Node 1)

```java
import java.util.*;

public class DijkstraExample {
    static class Pair {
        int node, weight;
        Pair(int n, int w) { node = n; weight = w; }
    }

    static void dijkstra(int n, List<List<Pair>> graph, int src) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.weight;

            if(cost > dist[node]) continue;

            for(Pair nei : graph.get(node)) {
                if(dist[node] + nei.weight < dist[nei.node]) {
                    dist[nei.node] = dist[node] + nei.weight;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        graph.get(1).add(new Pair(2, 2));
        graph.get(1).add(new Pair(3, 3));
        graph.get(2).add(new Pair(1, 2));
        graph.get(2).add(new Pair(3, 1));
        graph.get(2).add(new Pair(4, 4));
        graph.get(3).add(new Pair(1, 3));
        graph.get(3).add(new Pair(2, 1));
        graph.get(3).add(new Pair(4, 5));
        graph.get(4).add(new Pair(2, 4));
        graph.get(4).add(new Pair(3, 5));

        dijkstra(n, graph, 1);
    }
}
```

**Output:**
```
[∞, 0, 2, 3, 6]
```
Meaning: Node1 → Node2=2, Node3=3, Node4=6

---

## 5. Prim's Algorithm (Minimum Spanning Tree - MST)

```java
import java.util.*;

public class PrimsExample {
    static class Pair {
        int node, weight;
        Pair(int n, int w) { node = n; weight = w; }
    }

    static void primsMST(int n, List<List<Pair>> graph) {
        boolean[] inMST = new boolean[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);

        pq.add(new Pair(1, 0)); // Start from node 1
        int mstCost = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.weight;

            if(inMST[node]) continue;
            inMST[node] = true;
            mstCost += cost;

            for(Pair nei : graph.get(node)) {
                if(!inMST[nei.node]) pq.add(new Pair(nei.node, nei.weight));
            }
        }

        System.out.println("MST Minimum Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        graph.get(1).add(new Pair(2, 2));
        graph.get(1).add(new Pair(3, 3));
        graph.get(2).add(new Pair(1, 2));
        graph.get(2).add(new Pair(3, 1));
        graph.get(2).add(new Pair(4, 4));
        graph.get(3).add(new Pair(1, 3));
        graph.get(3).add(new Pair(2, 1));
        graph.get(3).add(new Pair(4, 5));
        graph.get(4).add(new Pair(2, 4));
        graph.get(4).add(new Pair(3, 5));

        primsMST(n, graph);
    }
}
```

**Output:**
```
MST Minimum Cost: 7
```
Edges used: (2-3:1), (1-2:2), (2-4:4)

---

## 6. Key Differences Table

| Feature                  | Dijkstra's Algorithm            | Prim's Algorithm                  |
|--------------------------|----------------------------------|-----------------------------------|
| Goal                     | Shortest path from one source    | Minimum cost to connect all nodes  |
| Output                   | Distance array                  | MST Cost (or MST edges)            |
| Cycles Allowed           | Yes                             | No (creates a tree)                |
| Edge Weight Requirement  | Non-negative only               | Positive only                      |
| Application Examples     | GPS, routing                    | Network cabling, road construction |

---

## 7. Analogy

- **Dijkstra's**: "Find the shortest route from your house to every city."
- **Prim's**: "Build the cheapest road network connecting all cities."

---

## 8. Recommended Practice Problems

- Dijkstra’s Algorithm: Network Delay Time (Leetcode 743), Cheapest Flights Within K Stops (Leetcode 787)
- Prim’s Algorithm: Connecting Cities with Minimum Cost (Leetcode 1135), Minimum Spanning Tree Problems

---
