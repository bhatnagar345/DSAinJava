package Graph;

import java.util.*;

public class DetectCycleUndirected {

    // Function to detect cycle in an undirected graph
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Try DFS from every unvisited node (handles disconnected graph)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    // DFS helper with parent tracking
    private static boolean dfs(int current, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[current] = true;

        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, current, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited neighbor but not the parent => cycle
                return true;
            }
        }

        return false;
    }

    // Main method to test
    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add undirected edges
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3); // This edge forms a cycle
        adj.get(2).add(4); adj.get(4).add(2);

        boolean result = hasCycle(V, adj);
        System.out.println("Cycle detected? " + result); // true
    }
}
