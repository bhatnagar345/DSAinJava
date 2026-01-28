package Graph;

import java.util.*;
//Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by
// 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge
// weight.
//You have to find the shortest distance of all the vertices from the source vertex src, and return an array of
// integers where the ith element denotes the shortest distance between ith node and source vertex src.
//
//Note: The Graph is connected and doesn't contain any negative weight edge.
//It is guaranteed that all the shortest distance will fit in a 32-bit integer.
//
//Examples:
//Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
//Output: [4, 3, 0]
//Explanation:
//
//Shortest Paths:
//For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
//For 2 to 1 minimum distance will be 3. By following path 2 -> 1
//For 2 to 2 minimum distance will be 0. By following path 2 -> 2
//Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
//Output: [0, 4, 8, 10, 10]
//Explanation:
//
//Shortest Paths:
//For 0 to 1 minimum distance will be 4. By following path 0 -> 1
//For 0 to 2 minimum distance will be 8. By following path 0 -> 2
//For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3
//For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4

public class DijkstraAlgorithm {

    //In Dijkstra we can not use this algorithm in negative weighted graph, because it will into infinite loop.
    // time complexity - O(ElogV)
    // using priorityQueue over queue because it will take the less weight first so it will take less time

    static class Pair {
        int first;   // distance
        int second;  // node

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {

        // Min-heap based on distance
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.first - b.first);

        // Adjacency list: node -> {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected weighted graph
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Start from source
        pq.add(new Pair(0, src));

        // Dijkstra algorithm
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int w = p.first;
            int node = p.second;

            // Skip outdated entry
            if (w > dist[node]) continue;

            for (int[] e : adj.get(node)) {
                int neigh = e[0];
                int weight = e[1];

                if (dist[neigh] > w + weight) {
                    dist[neigh] = w + weight;
                    pq.add(new Pair(dist[neigh], neigh));
                }
            }
        }
        return dist;
    }

    // Main method
    public static void main(String[] args) {

        int V = 6;
        int[][] edges = {
                {0, 1, 4},
                {0, 2, 2},
                {1, 2, 1},
                {1, 3, 5},
                {2, 3, 8},
                {3, 4, 3},
                {4, 5, 2}
        };

        int src = 0;

        int[] result = dijkstra(V, edges, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + result[i]);
        }
    }
}

