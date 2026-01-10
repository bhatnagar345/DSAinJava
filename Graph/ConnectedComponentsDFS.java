package Graph;

import java.util.*;
//A connected component is a group of vertices where every vertex is reachable from every other vertex in that
// group.
//        👉 If a graph is disconnected, it will have multiple connected components.
//
//Example graph:
//
//        0 — 1 — 2      3 — 4      5

public class ConnectedComponentsDFS {

    // DFS function
    static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited);
            }
        }
    }

    // Function to count connected components
    static int countConnectedComponents(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int components = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                components++; // one full component found
            }
        }
        return components;
    }

    public static void main(String[] args) {

        int V = 6; // nodes 0 to 5

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (Undirected graph)
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        // Node 5 is isolated

        int result = countConnectedComponents(V, adj);
        System.out.println("Number of connected components: " + result);
    }
}

