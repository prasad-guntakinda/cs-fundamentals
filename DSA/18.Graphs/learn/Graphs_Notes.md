# Graphs: A Comprehensive Guide for DSA Interviews

## What is a Graph?
A **graph** is a data structure that consists of a set of nodes (or vertices) connected by edges. Graphs are widely used to represent relationships between objects, such as networks, paths, and hierarchies.

### Key Terminology:
- **Vertex (Node)**: A fundamental unit of the graph.
- **Edge**: A connection between two vertices.
- **Directed Graph**: Edges have a direction (e.g., A → B).
- **Undirected Graph**: Edges do not have a direction (e.g., A — B).
- **Weighted Graph**: Edges have weights (e.g., cost, distance).
- **Unweighted Graph**: Edges do not have weights.
- **Cyclic Graph**: Contains at least one cycle.
- **Acyclic Graph**: Does not contain any cycles.
- **Connected Graph**: All vertices are reachable from any other vertex.
- **Disconnected Graph**: Some vertices are not reachable from others.

---

## Variations of Graphs

### 1. Directed vs Undirected Graphs
- **Directed Graph**: Edges have a specific direction.
  - Example: Representing one-way roads.
- **Undirected Graph**: Edges have no direction.
  - Example: Representing two-way roads.

### 2. Weighted vs Unweighted Graphs
- **Weighted Graph**: Edges have weights.
  - Example: Representing distances between cities.
- **Unweighted Graph**: Edges have no weights.
  - Example: Representing friendships in a social network.

### 3. Cyclic vs Acyclic Graphs
- **Cyclic Graph**: Contains at least one cycle.
  - Example: Representing a feedback loop in a system.
- **Acyclic Graph**: Does not contain any cycles.
  - Example: Representing a hierarchy or tree.

### 4. Special Graphs
- **Tree**: A connected acyclic graph.
- **DAG (Directed Acyclic Graph)**: A directed graph with no cycles.
  - Example: Representing tasks in a project.
- **Bipartite Graph**: Vertices can be divided into two disjoint sets such that no two vertices within the same set are adjacent.
  - Example: Representing a job assignment problem.

---

## Graph Representations
Graphs can be represented in multiple ways:

### 1. Adjacency Matrix
A 2D array where `matrix[i][j]` indicates the presence (and weight) of an edge between vertex `i` and vertex `j`.

#### Example:
```java
int[][] graph = {
    {0, 1, 0},
    {1, 0, 1},
    {0, 1, 0}
};
```

### 2. Adjacency List
An array of lists where each list represents the neighbors of a vertex.

#### Example:
```java
import java.util.*;

List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < 3; i++) {
    graph.add(new ArrayList<>());
}
graph.get(0).add(1);
graph.get(1).add(0);
graph.get(1).add(2);
graph.get(2).add(1);
```

---

## Common Graph Traversal Algorithms

### 1. Breadth-First Search (BFS)
BFS explores all neighbors at the current depth before moving to the next depth.

#### Example:
```java
import java.util.*;

public class BFS {
    public static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(3);

        bfs(2, graph);
    }
}
```

### 2. Depth-First Search (DFS)
DFS explores as far as possible along each branch before backtracking.

#### Example:
```java
import java.util.*;

public class DFS {
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(3);

        boolean[] visited = new boolean[4];
        dfs(2, visited, graph);
    }
}
```

---

## Common Graph Problems

### 1. Detecting Cycles
- **Problem**: Check if a graph contains a cycle.
- **Approach**: Use DFS with a visited stack.

### 2. Shortest Path
- **Problem**: Find the shortest path between two nodes.
- **Approach**: Use BFS for unweighted graphs, Dijkstra’s algorithm for weighted graphs.

### 3. Topological Sorting
- **Problem**: Order tasks in a DAG such that for every directed edge `u → v`, `u` comes before `v`.
- **Approach**: Use Kahn’s algorithm or DFS.

### 4. Minimum Spanning Tree
- **Problem**: Find a subset of edges that connects all vertices with minimum total weight.
- **Approach**: Use Kruskal’s or Prim’s algorithm.

### 5. Connected Components
- **Problem**: Find all connected components in a graph.
- **Approach**: Use DFS or BFS.

---

## Patterns in Graph Problems

### 1. Traversal-Based Problems
- Examples: BFS, DFS, Connected Components.

### 2. Pathfinding Problems
- Examples: Shortest Path, Longest Path.

### 3. Optimization Problems
- Examples: Minimum Spanning Tree, Maximum Flow.

### 4. Ordering Problems
- Examples: Topological Sorting.

---

This guide provides a comprehensive overview of graphs, their variations, traversal algorithms, common problems, and patterns. Practice these concepts with the provided Java examples to prepare effectively for DSA interviews.