# Graphs Easy Problem Set:


---

<details>

<summary> 1. Create an Adjacency List for graph representation from list of Edges </summary>

![graph_example.png](images/graph_example.png)

__problem statement:__

```text
Given a list of edges, create an adjacency list.
Edges = {}
```
__code:__
```java

```
</details>

---


<details>

<summary> 2. Print graph elements using DFS Traversal </summary>

![graph_example.png](images/graph_example.png)

__problem statement:__

```text
Given a list of edges, create an adjacency list.
Edges = {}
```
__code:__
```java

```
</details>

---

<details>

<summary> 3. DFS Traversal for Disconnected graphs and count the components </summary>

![graph_example.png](images/graph_example.png)

__problem statement:__

```text
Given a list of edges, create an adjacency list.
Edges = {}
```
__code:__
```java

```
</details>

---


<details>

<summary> 4. Detecting Cycles in a Directed Graph </summary>

__problem statement:__

![cyclic_graph.png](images/cyclic_graph.png)

```text
Check if the given graph has a cycle:
Given Edges: {()}
```

__Approaches:__
- Create an Adjacency Matrix from the given Edges
- Maintain a visited array
- Maintain a path till now visited
- For example: 
- If we start DFS from Node-0 then 
````text
path1: 0 -> 1 -> 4 
path2: 0 -> 2 -> 3 -> 1 -> 4
path3: 0 -> 1 -> 2 -> 3 -> 1 
````
- If any node repeats on the path means there is a cycle.
- In path3 node-1 is repeated, so there is a cycle exists on the given graph

__code:__
```java
import java.util.List;
import java.util.Collections;
public class GraphCycleDetector {
    List<List<Integer>> graph = List.of(List.of(1,2), List.of(2,4), List.of(3), List.of(1), Collections.emptyList());
    boolean[] visited = new boolean[graph.size()];
    boolean[] path = new boolean[graph.size()];

    public static void main(String... ar){
        GraphCycleDetector cd = new GraphCycleDetector();
        System.out.println("Does Cycle Exists: "+cd.dfs(0));
    }

    boolean dfs(int node){
        //check if node is already present on the path or not
        if(path[node]){
            return true;
        }
        //mark node is visited
        visited[node] = true;
        //mark node is part of the path
        path[node] = true;
        //check for neighbors
        for(var i=0; i<graph.get(node).size();i++){
            int neighbor = graph.get(node).get(i);
            //Check neighbor is already on the path
            if(path[neighbor]){
                return true;
            }
            //neighbor is not visited then do recursive dfs for neighbor
            if(!visited[neighbor] && dfs(neighbor)){
                return true;
            }
        }
        //before back-tracking remove the node from the path
        path[node] = false;
        return false;
    }
}
```
</details>

---

<details>

<summary>5. Number of Islands </summary>

__problem statement:__

```text

```
__code:__
```java

```
</details>

---