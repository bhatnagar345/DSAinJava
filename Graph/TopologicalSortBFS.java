package Graph;
//Topological Sort using BFS (Kahn’s Algorithm)
//🔑 Core Idea
//Topological sorting in BFS works using indegree:
//Calculate indegree of every vertex
//Push all vertices with indegree = 0 into a queue
//Repeatedly:
//Remove node from queue
//Add it to result
//Reduce indegree of its neighbors
//If any neighbor’s indegree becomes 0, push it into queue

import java.util.*;

public class TopologicalSortBFS {

    // Function to perform topological sort using BFS (Kahn's Algorithm)
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Compute indegree
        int[] indegree = new int[V];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Step 3: Push all indegree-0 nodes into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: BFS
        ArrayList<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
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

        System.out.println("Topological Sort (BFS / Kahn's): " + result);

        // Optional cycle check
        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
        }
    }
}

