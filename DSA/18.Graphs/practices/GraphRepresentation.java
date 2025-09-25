import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class GraphRepresentation {

    public static void main(String[] args) {
        int nodes = 4;
        int[][] edges = new int[][] {
                { 1, 2 }, { 1, 3 }, { 2, 4 }
        };
        int[][] graph = createAdjcencyMatrix(nodes, edges);
        printAdjMatrix(graph);

        List<List<Integer>> graphL = createAdjList(nodes, edges);
        System.out.println(graphL);

        Map<Integer, List<Integer>> graphM = createAdjListAsMap(nodes, edges);
        System.out.println(graphM);

    }

    private static Map<Integer, List<Integer>> createAdjListAsMap(int nodes, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                List<Integer> neighbors = new ArrayList<>();
                graph.put(edge[0], neighbors);
            }

            if (!graph.containsKey(edge[1])) {
                List<Integer> neighbors = new ArrayList<>();
                graph.put(edge[1], neighbors);
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }
        return graph;
    }

    private static void printAdjList(List<List<Integer>> graphL) {
        System.out.println(graphL);
    }

    private static int[][] createAdjcencyMatrix(int n, int[][] edges) {
        if (n <= 0) {
            return new int[][] {};
        }

        int[][] graph = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            graph[src][des] = 1;
            graph[des][src] = 1;
        }
        return graph;

    }

    private static List<List<Integer>> createAdjList(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    private static void printAdjMatrix(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + "  ");
            }

            System.out.println();
        }
    }

}