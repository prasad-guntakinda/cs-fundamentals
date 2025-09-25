import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphCycleDetector {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };
        Map<Integer, List<Integer>> graph = createGraph(n, edges);
        System.out.println("Graph: " + graph);
        System.out.println(" hasCycle: " + hasCycle(graph));
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size() + 1];
        int parent = -1;
        return dfs(1, visited, graph, parent);
    }

    private static boolean dfs(int src, boolean[] visited, Map<Integer, List<Integer>> graph, int parent) {
        visited[src] = true;
        System.out.println(src + ", " + parent);
        for (int neighbor : graph.get(src)) {
            if (visited[neighbor] && neighbor != parent) {
                System.out.println("Cycle detected at src: " + src + " and at neighbor:" + neighbor);
                return true;
            }
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, graph, src)) {
                    return true;
                }
            }
        }
        System.out.println("No Cycle detected..");
        return false;
    }

    // if it has a cycle then creation of graph will contain self loops
    private static Map<Integer, List<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[0] == edge[1])
                continue;
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
