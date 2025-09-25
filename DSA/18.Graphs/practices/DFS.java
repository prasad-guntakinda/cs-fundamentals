import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        Map<Integer, List<Integer>> graph = createGraph(n, edges);
        System.out.println("Graph: " + graph);
        dfsTraversal(n, graph, 1);

    }

    private static void dfsTraversal(int n, Map<Integer, List<Integer>> graph, int src) {
        boolean[] visited = new boolean[n + 1];
        System.out.println("Graph DFS Traversal: ");
        dfs(src, graph, visited);
    }

    private static void dfs(int src, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        System.out.print(src);

        for (int neighbor : graph.get(src)) {
            if (visited[neighbor] == false) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    private static Map<Integer, List<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }
        return graph;
    }
}
