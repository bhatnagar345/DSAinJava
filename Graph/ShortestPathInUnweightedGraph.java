package Graph;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    private static int[] shortestPath(int v, int[][] edges, int src) {
        int[] dist = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int[] e : edges){
            int x = e[0];
            int u = e[1];
            adj.get(x).add(u);
            adj.get(u).add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int e : adj.get(node)){
                if(dist[e]> dist[node]+1){
                    dist[e] = dist[node] + 1;
                    q.offer(e);
                }

            }
        }
        return dist;
    }
    public static void main(String[] args) {

        int V = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        int src = 0;

        int[] result = shortestPath(V, edges, src);

        System.out.println("Shortest distance from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + result[i]);
        }
    }


}
