import java.util.*;

public class DetectCycleDirectedGraph {

    // DFS function to detect cycle
    private static boolean dfs(int node, boolean[] visited, boolean[] recStack,
                               List<List<Integer>> adj) {

        visited[node] = true;
        recStack[node] = true;

        for (int neigh : adj.get(node)) {

            // If neighbor is not visited, recurse
            if (!visited[neigh]) {
                if (dfs(neigh, visited, recStack, adj))
                    return true;
            }
            // If neighbor is in recursion stack → cycle found
            else if (recStack[neigh]) {
                return true;
            }
        }

        // Remove node from recursion stack
        recStack[node] = false;
        return false;
    }

    // Function to check cycle in directed graph
    public static boolean isCyclic(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Run DFS for all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj))
                    return true;
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {

        int V = 4; // number of vertices

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Creates a cycle

        // Check for cycle
        if (isCyclic(V, adj)) {
            System.out.println("Cycle detected in directed graph");
        } else {
            System.out.println("No cycle in directed graph");
        }
    }
}
