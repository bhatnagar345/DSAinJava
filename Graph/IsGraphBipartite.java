package Graph;
import java.util.*;

//There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D
// array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
//
//There are no self-edges (graph[u] does not contain u).
//There are no parallel edges (graph[u] does not contain duplicate values).
//If v is in graph[u], then u is in graph[v] (the graph is undirected).
//The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
//A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in
// the graph connects a node in set A and a node in set B.
//
//Return true if and only if it is bipartite.
//Example 1:
//Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//Output: false
//Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
//Example 2:
//Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//Output: true
//Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

//A graph is bipartite if:
//We can color all nodes using 2 colors
//No two adjacent nodes have the same color

public class IsGraphBipartite {
    // if a cycle is present in graph and edges used to make cycle is in odd then graph is not bipartite
    // if edges used to make cycle in even then graph is bipartite
    // Function to check if graph is bipartite
    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means uncolored

        // Graph may be disconnected
        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0; // first color

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neigh : graph[node]) {

                        // If neighbor is uncolored, color it opposite
                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[node];
                            queue.offer(neigh);
                        }
                        // If same color as current node -> not bipartite
                        else if (color[neigh] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        // Example 1 (NOT bipartite)
        int[][] graph1 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println("Graph 1 Bipartite? " + isBipartite(graph1));

        // Example 2 (Bipartite)
        int[][] graph2 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        System.out.println("Graph 2 Bipartite? " + isBipartite(graph2));
    }
}
