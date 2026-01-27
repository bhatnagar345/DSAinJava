package Graph;

//Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][],
// where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given
// graph.
//
//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every
// directed edge u -> v, vertex u comes before v in the ordering.
//Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]
//                       3<-2<-5->0<-4->1->3
//
//Output: :
//        [4, 5, 0, 1, 2, 3]
//        [5, 2, 4, 0, 1, 3]

import java.util.*;

public class TopologicalSortDFS {

    // DFS helper function
    private static void dfs(int node, List<List<Integer>> adj,
                            boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, stack);
            }
        }

        // Push node after visiting all neighbors
        stack.push(node);
    }

    // Function to perform topological sort
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }

        // Step 2: DFS traversal
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 3: Stack → Topological order
        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }

        return topo;
    }

    // Main method
    public static void main(String[] args) {

        int V = 6;
        int[][] edges = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        ArrayList<Integer> result = topoSort(V, edges);

        System.out.println("Topological Sort (DFS): " + result);
    }
}

